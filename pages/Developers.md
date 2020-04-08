Maven Repository
================

To get easy access to the required dependencies you should add my maven repository to your project.
```
<repository>
    <id>codecrafter47-repo</id>
    <url>http://nexus.codecrafter47.de/content/repositories/public/</url>
</repository>
```

Javadoc
=======

[Bukkit side API](http://ci.codecrafter47.dyndns.eu/job/BungeeTabListPlus/codecrafter47.bungeetablistplus$bungeetablistplus-api-bukkit/javadoc/)

[Bungee side API](http://ci.codecrafter47.dyndns.eu/job/BungeeTabListPlus/codecrafter47.bungeetablistplus$bungeetablistplus-api-bungee/javadoc/)

[Sponge side API](http://ci.codecrafter47.dyndns.eu/job/BungeeTabListPlus/codecrafter47.bungeetablistplus$bungeetablistplus-api-sponge/javadoc/)

Bukkit side API
===============

If BungeeTabListPlus_BukkitBridge.jar is installed on the Bukkit server it provides an API allowing developers register custom variables.

1.  Add this to plugin.yml:
    ```
    depend: ['BungeeTabListPlus']
    ```
    or if you want your plugin to be able to run without BungeeTabListPlus being installed add this:
    ```
    softdepend: ['BungeeTabListPlus']
    ```

2.  Add a dependency to the BungeeTabListPlus API to your maven project.
    ```
    <dependency>
        <groupId>codecrafter47.bungeetablistplus</groupId>
        <artifactId>bungeetablistplus-api-bukkit</artifactId>
        <version>2.7.0</version>
        <scope>provided</scope>
    </dependency>
    ```

3.  Create a class for your custom variable
    ```
    import codecrafter47.bungeetablistplus.api.bukkit.Variable;

    public class TestVariable extends Variable {
        public TestVariable() {
            // name of the variable without { }
            super("test");
        }

        @Override
        public String getReplacement(Player player) {
            // return the replacement for the variable
            return ...;
        }
    }
    ```

4.  Register your variable in onEnable
    ```
    BungeeTabListPlusBukkitAPI.registerVariable(this, new TestVariable());
    ```

5.  Use your variable:
   
    Assuming you've registered a variable called `my_variable` then you can use `${viewer my_variable}` and `${player my_variable}` in your config.

Bungee side API
===============

The plugin provides an extensive API on BungeeCord allowing third party plugins to create custom variables as well as set a custom tab list for players.

Add the BungeeTabListPlus API dependency to your project
--------------------------------------------------------

Add this to bungee.yml (or plugin.yml):
```
depends: ['BungeeTabListPlus']
```
or if you only want to hook BungeeTabListPlus optionally use:
```
softDepends: ['BungeeTabListPlus']
```

Add a dependency to the BungeeTabListPlus API to your maven project.
```
<dependency>
    <groupId>codecrafter47.bungeetablistplus</groupId>
    <artifactId>bungeetablistplus-api-bungee</artifactId>
    <version>2.7.0</version>
    <scope>provided</scope>
</dependency>
```

Adding custom placeholders
--------------------------

1.  Create a class for your custom variable
    ```java
    import codecrafter47.bungeetablistplus.api.bungee.Variable;
    import net.md_5.bungee.api.connection.ProxiedPlayer;
    
    public class MyVariable extends Variable {
    
        public MyVariable() {
            super("my_variable");
        }
    
        @Override
        public String getReplacement(ProxiedPlayer player) {
            return null;
        }
    }
    ```

2.  Register your variable in onEnable
    ```java
    BungeeTabListPlusAPI.registerVariable(this, new MyVariable());
    ```

3.  Use your variable:
   
    Assuming you've registered a variable called `my_variable` then you can use `${viewer my_variable}` and `${player my_variable}` in your config.

Creating a custom tab list
--------------------------

1.  Create a custom tab list
    ```java
    CustomTablist customTablist = BungeeTabListPlusAPI.createCustomTablist();
    ```
    Change the size of the tab list
    ```java
    customTablist.setSize(80);
    ```
    Change the content of the tab list
    ```java
    customTablist.setSlot(row, column, icon, text, ping);
    ```
2.  Apply your custom tab list to a player
    ```java
    BungeeTabListPlusAPI.setCustomTabList(player, new MyTabListProvider());
    ```

    To remove the custom tab list from a player use
    ```java
    BungeeTabListPlusAPI.removeCustomTabList(player);
    ```

**Example:**
You can find the full source code of the example at [https://github.com/CodeCrafter47/BungeeTabListPlus/example/bungee](https://github.com/CodeCrafter47/BungeeTabListPlus/example/bungee).
![](images/api-demo-clock.gif)
```java
public class DemoPlugin extends Plugin {

    private CustomTablist customTablist;
    private Icon icon = Icon.DEFAULT;

    @Override
    public void onEnable() {
        // create a custom tab list
        customTablist = BungeeTabListPlusAPI.createCustomTablist();
        // with 19 rows and 1 column
        customTablist.setSize(19);

        // if the player types /tabdemo he will see the custom tab list
        getProxy().getPluginManager().registerCommand(this, new Command("tabdemo") {
            @Override
            public void execute(CommandSender sender, String[] args) {
                if (sender instanceof ProxiedPlayer) {
                    BungeeTabListPlusAPI.setCustomTabList(((ProxiedPlayer) sender), customTablist);
                }
            }
        });

        // every second call updateCustomTablist to update the content of our custom tab list
        getProxy().getScheduler().schedule(this, this::updateCustomTablist, 1, 1, TimeUnit.SECONDS);

        // Create our icon. Use the default icon until the custom one is created.
        try {
            BufferedImage image = ImageIO.read(getResourceAsStream("icon.png"));
            BungeeTabListPlusAPI.createIcon(image, icon -> this.icon = icon);
        } catch (IOException ex) {
            getLogger().log(Level.SEVERE, "Failed to load icon.", ex);
        }
    }

    /**
     * This method renders an analogue clock to the tab list.
     */
    private void updateCustomTablist() {
        // create an image
        BufferedImage image = new BufferedImage(19, 19, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        // background
        g.setColor(getAWTColor(ChatColor.DARK_GRAY));
        g.fillRect(0, 0, 19, 19);
        // circle
        g.setColor(getAWTColor(ChatColor.GRAY));
        for (int x = 0; x < 19; x++)
            for (int y = 0; y < 19; y++)
                if ((8.5 - x) * (8.5 - x) + (8.5 - y) * (8.5 - y) < 81)
                    g.drawRect(x, y, 1, 1);
        // arrows
        int hour = Calendar.getInstance().get(Calendar.HOUR);
        g.setColor(getAWTColor(ChatColor.DARK_RED));
        g.drawLine(9, 9, (int) round(9 + 8 * sin(hour / 6.0 * PI)), (int) round(9 - 8 * cos(hour / 6.0 * PI)));
        int minute = Calendar.getInstance().get(Calendar.MINUTE);
        g.setColor(getAWTColor(ChatColor.RED));
        g.drawLine(9, 9, (int) round(9 + 8 * sin(minute / 30.0 * PI)), (int) round(9 - 8 * cos(minute / 30.0 * PI)));
        int second = Calendar.getInstance().get(Calendar.SECOND);
        g.setColor(getAWTColor(ChatColor.GOLD));
        g.drawLine(9, 9, (int) round(9 + 9 * sin(second / 30.0 * PI)), (int) round(9 - 9 * cos(second / 30.0 * PI)));
        // convert the image to chat lines
        for (int line = 0; line < 19; line++) {
            String text = "";
            for (int x = 0; x < 19; x++) {
                ChatColor chatColor = getSimilarChatColor(new Color(image.getRGB(x, line)));
                text += chatColor == null ? ' ' : chatColor.toString() + '█';
            }
            customTablist.setSlot(line, 0, icon, text, 0);
        }
    }
}
```

Controlling fake players
------------------------

Get the FakePlayerManager:
```
FakePlayerManager fakePlayerManager = BungeeTabListPlusAPI.getFakePlayerManager();
```

Enable disable fake players from the config randomly joining the game:
```
fakePlayerManager.setRandomJoinLeaveEnabled(true);
fakePlayerManager.setRandomJoinLeaveEnabled(false);
```

Get all fake players which are displayed in the tab list:
```
Collection<FakePlayer> onlineFakePlayers = fakePlayerManager.getOnlineFakePlayers();
```

Add a fake player to the tab list:
```
ServerInfo server = ...;
FakePlayer fakePlayer = fakePlayerManager.createFakePlayer("Name", server);

fakePlayer.setPing(47);
fakePlayer.setRandomServerSwitchEnabled(true);
fakePlayer.setSkin(BungeeTabListPlusAPI.getSkinForPlayer("Herobrine"));
```

Remove a fake player from the tab list:
```
fakePlayerManager.removeFakePlayer(fakePlayer);
```

Sponge side API
===============

If BungeeTabListPlus_SpongeBridge.jar is installed on your Sponge server it provides an API allowing developers register custom placeholders.

1.  Add the BungeeTabListPlus dependency to your @Plugin annotation:
    ```
    @Plugin(id = "your_id", name = "your_name", version = "your_version", dependencies = {@Dependency(id = "bungeetablistplus")})
    ```
    or if you want your plugin to be able to run without BungeeTabListPlus being installed:
    ```
    @Plugin(id = "your_id", name = "your_name", version = "your_version", dependencies = {@Dependency(id = "bungeetablistplus", optional = true)})
    ```

2.  Add a dependency to the BungeeTabListPlus API to your maven project.
    ```
    <dependency>
        <groupId>codecrafter47.bungeetablistplus</groupId>
        <artifactId>bungeetablistplus-sponge-bukkit</artifactId>
        <version>2.7.0</version>
        <scope>provided</scope>
    </dependency>
    ```

3.  Create a class for your custom variable
    ```
    import codecrafter47.bungeetablistplus.api.sponge.Variable;

    public class TestVariable extends Variable {
        public TestVariable() {
            // name of the variable without { }
            super("test");
        }

        @Override
        public String getReplacement(Player player) {
            // return the replacement for the variable
            return ...;
        }
    }
    ```

4.  Register your placeholder. You should do this during the POST_INITIALIZATION phase or later.
    ```
    BungeeTabListPlusSpongeAPI.registerVariable(this, new TestVariable());
    ```

5.  Use your variable:
   
    Assuming you've registered a variable called `my_variable` then you can use `${viewer my_variable}` and `${player my_variable}` in your config.