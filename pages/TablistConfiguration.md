The tab list layout is configured in the `tabLists/default.yml` file. This page explains the how that file is structured.

It is possible to create multiple tab list layouts by creating multiple `*.yml` files in the `tabLists` directory with the format described here. Doing so can be useful to e.g. display a different tab list to admins or to players on a particular server. For more information see [Multiple tablist configuration files](MultipleTablists).

Each tab list configuration file is divided into two parts. The _common part_ that is the same in all tab list configuration files and a _type specific part_ that is different depending on whether you want to create a tab list with fixed size or with dynamic size(adjusting to the number of players online).

| FIXED_SIZE                     | DYNAMIC_SIZE                        |
| ------------------------------ | ----------------------------------- |
| ![](images/default-config.gif) | ![](images/dynamic-size-config.png) |

Common Part
===========

```yaml
showTo: "all"
priority: 0

showHeaderFooter: true
header:
- '&cWelcome &f${viewer name}'
- '&eW&celcome &f${viewer name}'
- '&eWe&clcome &f${viewer name}'
- '&eWel&ccome &f${viewer name}'
- '&eWelc&come &f${viewer name}'
- '&eWelco&cme &f${viewer name}'
- '&eWelcom&ce &f${viewer name}'
- '&eWelcome &f${viewer name}'
- '&cW&eelcome &f${viewer name}'
- '&cWe&elcome &f${viewer name}'
- '&cWel&ecome &f${viewer name}'
- '&cWelc&eome &f${viewer name}'
- '&cWelco&eme &f${viewer name}'
- '&cWelcom&ee &f${viewer name}'
- '&cWelcome &f${viewer name}'
headerAnimationUpdateInterval: 0.2
footer:
- |-
  &6Line 1
  &eLine 2
- |-
  &eLine 1
  &6Line 2
footerAnimationUpdateInterval: 0.5

customPlaceholders:
  afk_tag:
    !conditional
    condition: ${player essentials_afk}
    true: '&7|&oaway'
    false: ''
  viewer_colored_ping0:
    !conditional
    condition: "${viewer ping} < 50"
    true: "&a${viewer ping}"
    false: "&e${viewer ping}"
  viewer_colored_ping:
    !conditional
    condition: "${viewer ping} < 150"
    true: ${viewer_colored_ping0}
    false: "&c${viewer ping}"

playerSets:
  global: all

type: FIXED_SIZE
```

Below every line of the above config is explained:

```yaml
showTo: <Expression>
```

Together with the `priority` option this is used by the plugin to determine which tab list each player should see. If no tab list matches a player then he will see the local tab list of the Minecraft server the player is connected to. For more information on multiple tab list config files see [Multiple tablist configuration files](MultipleTablists).
  
Examples:
```yaml
# This tab list is shown to all players.
showTo: 'all'

# This tab list can only seen by a specific player
showTo: '${viewer name} == "CodeCrafter47"'.

# Show the tab list to all players on server "survival" in world "world_nether"
showTo: '${viewer server} == "survival" and ${viewer world} == "world_nether"'

# Show the tab list to players with a specific permission
showTo: '${viewer permission tablist.vip} == true'

# Create a tab list the is visible on only some of your servers
showTo: '${viewer server} == "survival" or ${viewer server} == "plotworld" or ${viewer server} == "creative"'
```

```yaml
priority: 1
```
If after checking the `showTo` option multiple tab lists still apply to the player the plugin chooses the one with the highest priority.
  
```yaml
shownFooterHeader: true
```

You can use this to disable header/footer if you're using a Bukkit side plugin for that.

If you set this to false you can ignore the four options below.

```
header:
- ''
- '&bW'
- '&bWe'
- '&bWel'
- '&bWelc'
- '&bWelco'
- '&bWelcom'
- '&bWelcome'
- '&bWelcome'
- '&bWelcome'
- '&bWelcome'
- ''
- '&6${viewer name}'
- '&6${viewer name}'
- '&6${viewer name}'
- '&6${viewer name}'
- '&6${viewer name}'
- '&6${viewer name}'
- '&6${viewer name}'
- '&6${viewer name}'
```

Text to show above the tablist. This requires client version 1.8 or higher.

```yaml
headerAnimationUpdateInterval: 0.25
```

The interval in seconds after which the header animation is updated.

```
footer:
- "&eWebsite: &4www.example.com\n&eTeamspeak: &4ts3.example.com"
```

Text to show below the tablist. This requires client version 1.8 or higher.

```yaml
footerAnimationUpdateInterval: 0.5
```

The interval in seconds after which the footer animation is updated.

Custom placeholders are a powerful mechanism to add more dynamic content
to the tab list.
```yaml
customPlaceholders:
  # Defines the ${afk_tag} placeholder which is used to add "|away"
  # to the players name if he is afk.
  afk_tag:
    !conditional
    condition: ${player essentials_afk}
    true: '&7|&oaway'
    false: ''
  # Defines the ${viewer_colored_ping0} placeholder which displays the ping in green
  # if it is below 50ms, otherwise in yellow.
  viewer_colored_ping0:
    !conditional
    condition: "${viewer ping} < 50"
    true: "&a${viewer ping}"
    false: "&e${viewer ping}"
  # Defines ${the viewer_colored_ping} placeholder which displays the ping in red
  # if it is above 150ms, otherwise it is replaced with the ${viewer_colored_ping0}
  # placeholder ( < 50 -> green, > 50 -> yellow).
  # That results in the following color scheme:
  # 0 - 49   -> green
  # 50 - 149 -> yellow
  # 150+     -> red
  viewer_colored_ping:
    !conditional
    condition: "${viewer ping} < 150"
    true: "${viewer_colored_ping0}"
    false: "&c${viewer ping}"
```
See [Custom Placeholders](CustomPlaceholders) for more detailed explanations.

Player sets are required to display players and player counts on the tab list. To display a player count use `${playerset:<name> size}`, example: `${playerset:global size}`. How to display players will be discussed later.
  
```yaml
playerSets:
  global: all
  ...
```

Some more examples:
```yaml
playerSets:
  # The global player set contains all players (hidden players are only visible to admins)
  global:
    filter: all
  # All players, except for hidden players
  global_without_hidden:
    filter: all
    hiddenPlayers: INVISIBLE
  # All players, always contains hidden players.
  global_with_hidden:
    filter: all
    hiddenPlayers: VISIBLE
  survival:
    filter: |-
      ${player server} == "survival"
  # Player set containing all players on the same server as the player viewing the tab list:
  currentserver:
    filter: |-
      ${player server} == ${viewer server}
  # Player set containing all players on a specific server and world:
  survival_nether:
    filter: |-
      ${player server} == "survival"
      and ${player world} == "world_nether"
  # Player set containing all admins:
  admins:
    filter: |-
      ${player vault_primary_group} == "admin"
      or ${player vault_primary_group} == "owner"
```
See [Player sets](PlayerSets) for more information.

`type: FIXED_SIZE`
  
This can be set to `FIXED_SIZE` or `DYNAMIC_SIZE`.

The `FIXED_SIZE` option gives you a tab list (with fixed size) that looks a bit like the pre 1.8 tab list. It allows
for custom slots to display additional information to the player.

The `DYNAMIC_SIZE` option is a bit like the vanilla tab list. It changes its size to adjust to the amount of players
online. However it does not allow for custom slots.


`FIXED_SIZE` Specific Part
==========================

```yaml
size: 60

defaultIcon: colors/dark_gray.png
defaultPing: 1000

components:
- {text: "&cServer: &6${viewer server}", icon: "default/server.png", ping: 0}
- {text: "&cRank: &6${viewer vault_primary_group}", icon: "default/rank.png", ping: 0}
- {text: "&cPing: ${viewer_colored_ping}ms", icon: "default/ping.png", ping: 0}
-
-
-
- !players_by_server
  playerSet: global
  serverHeader:
  - {text: "&e&n${server}&f&o (${server_player_count}):", icon: "colors/yellow.png", ping: 0}
  serverSeparator:
  -
  -
  -
  includeEmptyServers: true
  playerComponent: "${player vault_prefix}${player name}${afk_tag}"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
- !spacer {}
-
-
-
- !animated
  interval: 0.2
  components:
  - {text: "&6&c=&6==============", icon: "colors/gold.png", ping: 0}
  - {text: "&6=&c=&6=============", icon: "colors/gold.png", ping: 0}
  - {text: "&6==&c=&6============", icon: "colors/gold.png", ping: 0}
  - {text: "&6===&c=&6===========", icon: "colors/gold.png", ping: 0}
  - {text: "&6====&c=&6==========", icon: "colors/gold.png", ping: 0}
  - {text: "&6=====&c=&6=========", icon: "colors/gold.png", ping: 0}
  - {text: "&6======&c=&6========", icon: "colors/gold.png", ping: 0}
  - {text: "&6=======&c=&6=======", icon: "colors/gold.png", ping: 0}
  - {text: "&6========&c=&6======", icon: "colors/gold.png", ping: 0}
  - {text: "&6=========&c=&6=====", icon: "colors/gold.png", ping: 0}
  - {text: "&6==========&c=&6====", icon: "colors/gold.png", ping: 0}
  - {text: "&6===========&c=&6===", icon: "colors/gold.png", ping: 0}
  - {text: "&6============&c=&6==", icon: "colors/gold.png", ping: 0}
  - {text: "&6=============&c=&6=", icon: "colors/gold.png", ping: 0}
  - {text: "&6==============&c=&6", icon: "colors/gold.png", ping: 0}
- !animated
  interval: 0.2
  components:
  - {text: "&6&c=&6==============", icon: "colors/gold.png", ping: 0}
  - {text: "&6=&c=&6=============", icon: "colors/gold.png", ping: 0}
  - {text: "&6==&c=&6============", icon: "colors/gold.png", ping: 0}
  - {text: "&6===&c=&6===========", icon: "colors/gold.png", ping: 0}
  - {text: "&6====&c=&6==========", icon: "colors/gold.png", ping: 0}
  - {text: "&6=====&c=&6=========", icon: "colors/gold.png", ping: 0}
  - {text: "&6======&c=&6========", icon: "colors/gold.png", ping: 0}
  - {text: "&6=======&c=&6=======", icon: "colors/gold.png", ping: 0}
  - {text: "&6========&c=&6======", icon: "colors/gold.png", ping: 0}
  - {text: "&6=========&c=&6=====", icon: "colors/gold.png", ping: 0}
  - {text: "&6==========&c=&6====", icon: "colors/gold.png", ping: 0}
  - {text: "&6===========&c=&6===", icon: "colors/gold.png", ping: 0}
  - {text: "&6============&c=&6==", icon: "colors/gold.png", ping: 0}
  - {text: "&6=============&c=&6=", icon: "colors/gold.png", ping: 0}
  - {text: "&6==============&c=&6", icon: "colors/gold.png", ping: 0}
- !animated
  interval: 0.2
  components:
  - {text: "&6&c=&6==============", icon: "colors/gold.png", ping: 0}
  - {text: "&6=&c=&6=============", icon: "colors/gold.png", ping: 0}
  - {text: "&6==&c=&6============", icon: "colors/gold.png", ping: 0}
  - {text: "&6===&c=&6===========", icon: "colors/gold.png", ping: 0}
  - {text: "&6====&c=&6==========", icon: "colors/gold.png", ping: 0}
  - {text: "&6=====&c=&6=========", icon: "colors/gold.png", ping: 0}
  - {text: "&6======&c=&6========", icon: "colors/gold.png", ping: 0}
  - {text: "&6=======&c=&6=======", icon: "colors/gold.png", ping: 0}
  - {text: "&6========&c=&6======", icon: "colors/gold.png", ping: 0}
  - {text: "&6=========&c=&6=====", icon: "colors/gold.png", ping: 0}
  - {text: "&6==========&c=&6====", icon: "colors/gold.png", ping: 0}
  - {text: "&6===========&c=&6===", icon: "colors/gold.png", ping: 0}
  - {text: "&6============&c=&6==", icon: "colors/gold.png", ping: 0}
  - {text: "&6=============&c=&6=", icon: "colors/gold.png", ping: 0}
  - {text: "&6==============&c=&6", icon: "colors/gold.png", ping: 0}
- {text: "&cTime: &6${time H:mm:ss}", icon: "default/clock.png", ping: 0}
- {text: "&cPlayers: &6${playerset:global size}", icon: "default/players.png", ping: 0}
- {text: "&cBalance: &6${viewer vault_balance 1.2}", icon: "default/balance.png", ping: 0}
```

Now follows an explanation of every single line:
```yaml
size: 60
```

Size of the tab list.

Possible values:

| Size | Columns | Rows |
| ---- | ------- | ---- |
| 20   | 1       | 20   |
| 30   | 2       | 15   |
| 40   | 2       | 20   |
| 60   | 3       | 20   |
| 80   | 4       | 20   |

__Important:__ If you have 1.7 or older clients this should match the tab_size configured in BungeeCords config.yml.

```yaml
defaultIcon: "colors/dark_gray.png"
```

The `defaultIcon` option tells the plugin which icon to use for all slots for which you don't explicitely configure a different icon.

Icons in the tab list are a feature which has been added in Minecraft version 1.8. You won't see them using older clients. This option is used to set the icon for all slots which are not used by any of the components configured below.

You have two options:

1. You can set this to the name of a 8x8 pixel .png file you saved in the heads folder, e.g. `colors/blue.png`

2. Set it to a player name or uuid. You can set this to a name which doesn't belong to player to save bandwidth/ see random skins. See <http://www.reddit.com/r/MinecraftHeads/comments/1m1s0g/official_heads_made_by_mojang_marc/> for cool skins/heads.

```yaml
defaultPing: 1000
```

This option is used to set the ping for all slots which are not used by any of the components configured below.

Ping values:

| Value     | Description          | Image                         |
| --------- | -------------------- | ----------------------------- |
| < 0       | crossed out ping bar | ![](images/ping_bar_-1.png)   |
| 0 - 149   | five bars            | ![](images/ping_bar_0.png)    |
| 150 - 299 | four bars            | ![](images/ping_bar_150.png)  |
| 300 - 599 | three bars           | ![](images/ping_bar_300.png)  |
| 600 - 999 | two bars             | ![](images/ping_bar_600.png)  |
| > 1000    | one bar              | ![](images/ping_bar_1000.png) |

The components are used to configure the actual content of the tab list. There are different components available for creating custom slots, adding players, creating animations, adding dynamic content, and a lot of other stuff. You can find a [list of all components here](Components).

```yaml
components:
# Three info slots at the top
- {text: "&cServer: &6${viewer server}", icon: "default/server.png", ping: 0} # 1st row, 1st column
- {text: "&cRank: &6${viewer vault_primary_group}", icon: "default/rank.png", ping: 0} # 1st row, 2nd column
- {text: "&cPing: ${viewer_colored_ping}ms", icon: "default/ping.png", ping: 0} # 1st row, 2nd column
# A row of empty slots below
-
-
-
# The players by server component adds players to the tab list grouped by server
- !players_by_server
  # The global player set is configured above
  playerSet: global
  # The server header is shown for each server above the players on that server.
  # We use it to display the server name and the player count.
  serverHeader:
  - {text: "&e&n${server}&f&o (${server_player_count}):", icon: "colors/yellow.png", ping: 0}
  # The server separator is shown between two consecutive servers. 
  # Here it use used to separate the servers with an empty row of slots.
  serverSeparator:
  -
  -
  -
  # Whether empty servers should show up too
  includeEmptyServers: true
  # Format of the player slot. Add prefixes as you like
  playerComponent: "${player vault_prefix}${player name}${afk_tag}"
  # If there isn't enough space for all players the morePlayersComponent is displayed. We use to to display the number of players which couldn't be displayed on the tab list.
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
# A spacer creates as many empty slots as possible.
- !spacer {}
# Because the spacer has eaten up all the remaining free slots, the nine slots below are guaranteed to be at the bottom of the tab list.
# Let's start with another empty row
-
-
-
# Then some nice animations at the bottom
- !animated # 19th row, 1st column
  interval: 0.2 # The animation is updated every 0.2 seconds
  components:
  - {text: "&6&c=&6==============", icon: "colors/gold.png", ping: 0}
  - {text: "&6=&c=&6=============", icon: "colors/gold.png", ping: 0}
  - {text: "&6==&c=&6============", icon: "colors/gold.png", ping: 0}
  - {text: "&6===&c=&6===========", icon: "colors/gold.png", ping: 0}
  - {text: "&6====&c=&6==========", icon: "colors/gold.png", ping: 0}
  - {text: "&6=====&c=&6=========", icon: "colors/gold.png", ping: 0}
  - {text: "&6======&c=&6========", icon: "colors/gold.png", ping: 0}
  - {text: "&6=======&c=&6=======", icon: "colors/gold.png", ping: 0}
  - {text: "&6========&c=&6======", icon: "colors/gold.png", ping: 0}
  - {text: "&6=========&c=&6=====", icon: "colors/gold.png", ping: 0}
  - {text: "&6==========&c=&6====", icon: "colors/gold.png", ping: 0}
  - {text: "&6===========&c=&6===", icon: "colors/gold.png", ping: 0}
  - {text: "&6============&c=&6==", icon: "colors/gold.png", ping: 0}
  - {text: "&6=============&c=&6=", icon: "colors/gold.png", ping: 0}
  - {text: "&6==============&c=&6", icon: "colors/gold.png", ping: 0}
- !animated # 19th row, 2nd column
  interval: 0.2
  components:
  - {text: "&6&c=&6==============", icon: "colors/gold.png", ping: 0}
  - {text: "&6=&c=&6=============", icon: "colors/gold.png", ping: 0}
  - {text: "&6==&c=&6============", icon: "colors/gold.png", ping: 0}
  - {text: "&6===&c=&6===========", icon: "colors/gold.png", ping: 0}
  - {text: "&6====&c=&6==========", icon: "colors/gold.png", ping: 0}
  - {text: "&6=====&c=&6=========", icon: "colors/gold.png", ping: 0}
  - {text: "&6======&c=&6========", icon: "colors/gold.png", ping: 0}
  - {text: "&6=======&c=&6=======", icon: "colors/gold.png", ping: 0}
  - {text: "&6========&c=&6======", icon: "colors/gold.png", ping: 0}
  - {text: "&6=========&c=&6=====", icon: "colors/gold.png", ping: 0}
  - {text: "&6==========&c=&6====", icon: "colors/gold.png", ping: 0}
  - {text: "&6===========&c=&6===", icon: "colors/gold.png", ping: 0}
  - {text: "&6============&c=&6==", icon: "colors/gold.png", ping: 0}
  - {text: "&6=============&c=&6=", icon: "colors/gold.png", ping: 0}
  - {text: "&6==============&c=&6", icon: "colors/gold.png", ping: 0}
- !animated # 19th row, 3rd column
  interval: 0.2
  components:
  - {text: "&6&c=&6==============", icon: "colors/gold.png", ping: 0}
  - {text: "&6=&c=&6=============", icon: "colors/gold.png", ping: 0}
  - {text: "&6==&c=&6============", icon: "colors/gold.png", ping: 0}
  - {text: "&6===&c=&6===========", icon: "colors/gold.png", ping: 0}
  - {text: "&6====&c=&6==========", icon: "colors/gold.png", ping: 0}
  - {text: "&6=====&c=&6=========", icon: "colors/gold.png", ping: 0}
  - {text: "&6======&c=&6========", icon: "colors/gold.png", ping: 0}
  - {text: "&6=======&c=&6=======", icon: "colors/gold.png", ping: 0}
  - {text: "&6========&c=&6======", icon: "colors/gold.png", ping: 0}
  - {text: "&6=========&c=&6=====", icon: "colors/gold.png", ping: 0}
  - {text: "&6==========&c=&6====", icon: "colors/gold.png", ping: 0}
  - {text: "&6===========&c=&6===", icon: "colors/gold.png", ping: 0}
  - {text: "&6============&c=&6==", icon: "colors/gold.png", ping: 0}
  - {text: "&6=============&c=&6=", icon: "colors/gold.png", ping: 0}
  - {text: "&6==============&c=&6", icon: "colors/gold.png", ping: 0}
- {text: "&cTime: &6${time H:mm:ss}", icon: "default/clock.png", ping: 0} # 20th row, 1st column
- {text: "&cPlayers: &6${playerset:global size}", icon: "default/players.png", ping: 0} # 20th row, 2nd column
- {text: "&cBalance: &6${viewer vault_balance 1.2}", icon: "default/balance.png", ping: 0} # 20th row, 3rd column
```

`DYNAMIC_SIZE` Specific Part
============================

```yaml

playerSet: global

playerOrder: "vaultGroupInfo,alphabetically"

playerComponent: "${player name}"
```

The `playerSet` option is used to configure which players are displayed on the tab list.

The `playerOrder` option is used to configure the order of the players. [More info](PlayerOrder)
   
The `playerComponent` controls the format of the player slot. Add prefixes as you like.