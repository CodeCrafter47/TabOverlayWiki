This page discusses the `FIXED_SIZE` tab list type.
Using the `FIXED_SIZE` tab list type enables you to have custom text slots and gives you access to a variety of different layouts.

### Content
[!]: ToC

### `FIXED_SIZE` Specific Options

First we have a look at the options available specifically for the `FIXED_SIZE` tab list type.

* ##### `size` or `columns`

    You can use either the `size` or the `columns` option to configure the size of the tab list.
    
    The following table shows some possible values for the `size` option:
    
    | Size | Columns | Rows |
    | ---- | ------- | ---- |
    | 20   | 1       | 20   |
    | 30   | 2       | 15   |
    | 40   | 2       | 20   |
    | 60   | 3       | 20   |
    | 80   | 4       | 20   |
    
    [!]: ifBTLP
    __Important:__ If you have 1.7 or older clients the `size` in the tab list configuration file must match the `tab_size` configured in BungeeCords `config.yml`.
    [!]: endIF
    
    The `columns` option allows you to specify the number of columns directly.
    It can be set to `1`, `2`, `3` or `4`.
    To use it remove the `size` option from your tab list configuration file and replace it with a line similar to the following:
    ```yaml
    columns: 3
    ```
    The difference when using the `columns` option compared to the `size` option is that the plugin will adjust the number of rows depending on the content.
    So if you use the `columns` option the tab list can dynamically adjust its size, even though you're using the `FIXED_SIZE` type.
    Note that there is a minimum number of rows depending on the number of columns which limits the amount by which the tab list can grow/ shrink.
    E.g. when using three columns there will be at least 14 rows.
    
    Note that the tab will **not** add extra columns to display more players. You have to either use the `DYNAMIC_SIZE` Tab list or the `size` option.  
    The tab may also bug out when more players are online than what can be displayed on the set amount of columns.

* ##### `defaultIcon`

    The `defaultIcon` option tells the plugin which icon to use for all slots which are neither player slots nor explicitly configured to use a different icon.
    
    Icons in the tab list are a feature which has been added in Minecraft version 1.8.
    You will not see them using older clients.
    They are not available in offline mode either.
    
    The `defaultIcon` option can be set to one of the following:
    
    1. The name of a 8x8 pixel `.png` file you saved in the `!!iconFolder` directory, e.g. `colors/blue.png`.
    
    2. A player name or uuid. You can set this to a name which does not belong to player to save bandwidth/ see random alex or steve skins. See <http://www.reddit.com/r/MinecraftHeads/comments/1m1s0g/official_heads_made_by_mojang_marc/> for cool skins/heads.

* ##### `defaultPing`

    The `defaultPing` configures the ping for all slots which are neither player slots nor explicitly configured to use a different ping.
    The following table shows the effect of different ping values:
    
    | Value     | Description          | Image                         |
    | --------- | -------------------- | ----------------------------- |
    | < 0       | crossed out ping bar | ![](images/ping_bar_-1.png)   |
    | 0 - 149   | five bars            | ![](images/ping_bar_0.png)    |
    | 150 - 299 | four bars            | ![](images/ping_bar_150.png)  |
    | 300 - 599 | three bars           | ![](images/ping_bar_300.png)  |
    | 600 - 999 | two bars             | ![](images/ping_bar_600.png)  |
    | > 1000    | one bar              | ![](images/ping_bar_1000.png) |
    
* ##### `components`
    
    The `components` option is used to configure the content of the tab list.
    A large part of the changes you are going to make to the configuration will happen here.
    
    The content of the tab list is defined by combining different components (hence the name of the option).
    There are different components available for tasks such as
     * Adding custom text slots
     * Adding players
     * Creating a table-like layout
     * Creating animations
     * And many more...
    
    Using components is a complex topic - as such there are multiple wiki pages explaining it:
    * [Fixed Size Tab List - Displaying Players](Fixed-Size-Tab-List---Displaying-Players)
    * [Fixed Size Tab List - The Table Component](Fixed-Size-Tab-List---The-Table-Component)
    * [Vertical Slot Order](Vertical-Slot-Order)
    * [Component Reference Page](Components)
    
### Getting Started with Components

#### A Simple Example

This example shows the order in which components appear on the tab list.
It also gives a first impression on how to create custom text slots.

![](images/fixed-size-1.png)

```yaml
showTo: all
priority: 1

showHeaderFooter: false

playerSets: {} # none yet

type: FIXED_SIZE

size: 80

defaultIcon: colors/black.png
defaultPing: 1000

components:
- "Slot 1"
- "Slot 2"
- "Slot 3"
- "Slot 4"
- "Slot 5"
- "Slot 6"
- "Slot 7"
- "Slot 8"
- "Slot 9"
- "Slot 10"
```

You can try adding more custom slots or changing the size of the tab list by
 yourself now.
 
#### Using Color Codes and Placeholders in Custom Slots

This example demonstrates the use of color codes and shows how to use placeholders to display the total player count as well as the ping and world of the viewer (player looking at the tab list) in a custom slot.

![](images/fixed-size-2.png)

```yaml
showTo: all
priority: 1

showHeaderFooter: false

playerSets:
  all_players: all

type: FIXED_SIZE

size: 80

defaultIcon: colors/black.png
defaultPing: 1000

components:
- "&aGreen"
- "&bBlue"
- "&cRed"
- "&eYellow"
- "Players: ${playerset:all_players size}"
- "Ping: ${viewer ping}"
- "World: ${viewer world}"
```

#### Changing the Ping and Icon of a Custom Slot

In the previous example we used
```yaml
- "&aGreen"
```
to create a custom slot. The above is actually a short form for
```yaml
- {text: "&aGreen"}
```
The long form has the advantage that it allows to change the icon and ping
 of the slot too: 
```yaml
- {text: "&aGreen", icon: "colors/green.png", ping: 100}
```

Now let's have a look at how we can improve the above example using that
 knowledge:

![](images/fixed-size-3.png)
```yaml
showTo: all
priority: 1

playerSets:
  all_players: all

type: FIXED_SIZE

size: 80

defaultIcon: colors/black.png
defaultPing: 1000

components:
- {text: "&aGreen", icon: "colors/green.png"}
- {text: "&bBlue", icon: "colors/aqua.png"}
- {text: "&cRed", icon: "colors/red.png"}
- {text: "&eYellow", icon: "colors/yellow.png"}
- {text: "Players: ${playerset:all_players size}", icon: "default/players.png"}
- {text: "Ping: ${viewer ping}", icon: "default/ping.png", ping: "${viewer ping}"}
- {text: "World: ${viewer world}", icon: "MHF_Question"}
```

Same as for the `defaultIcon` option you can set the `icon` property to one of the following:

1. The name of a 8x8 pixel `.png` file you saved in the `!!iconFolder` directory, e.g. `colors/blue.png`

2. A player name or uuid. You can use a name which does not belong to player to save bandwidth/ see random steve or alex skins. See <http://www.reddit.com/r/MinecraftHeads/comments/1m1s0g/official_heads_made_by_mojang_marc/> for cool skins/heads.

The values for the `ping` option of the custom slot are the same as for the `defaultPing` option:
 
| Value     | Description          | Image                         |
| --------- | -------------------- | ----------------------------- |
| < 0       | crossed out ping bar | ![](images/ping_bar_-1.png)   |
| 0 - 149   | five bars            | ![](images/ping_bar_0.png)    |
| 150 - 299 | four bars            | ![](images/ping_bar_150.png)  |
| 300 - 599 | three bars           | ![](images/ping_bar_300.png)  |
| 600 - 999 | two bars             | ![](images/ping_bar_600.png)  |
| > 1000    | one bar              | ![](images/ping_bar_1000.png) |

#### Different Icons

Here is a showcase of the different icons included, some player icons and the different ping values:

![](images/fixed-size-icon-showcase.png)

```yaml
showTo: all
priority: 1

type: FIXED_SIZE

size: 38

defaultIcon: colors/black.png
defaultPing: 1000

components:
- "&nIncluded Icons"
-
- {text: "&0Black", icon: "colors/black.png"}
- {text: "&1Dark Blue", icon: "colors/dark_blue.png"}
- {text: "&2Dark Green", icon: "colors/dark_green.png"}
- {text: "&3Dark Aqua", icon: "colors/dark_aqua.png"}
- {text: "&4Dark Red", icon: "colors/dark_red.png"}
- {text: "&5Dark Purple", icon: "colors/dark_purple.png"}
- {text: "&6Gold", icon: "colors/gold.png"}
- {text: "&7Gray", icon: "colors/gray.png"}
- {text: "&8Dark Gray", icon: "colors/dark_gray.png"}
- {text: "&9Blue", icon: "colors/blue.png"}
- {text: "&aGreen", icon: "colors/green.png"}
- {text: "&bBlue", icon: "colors/aqua.png"}
- {text: "&cRed", icon: "colors/red.png"}
- {text: "&dLight Purple", icon: "colors/light_purple.png"}
- {text: "&eYellow", icon: "colors/yellow.png"}
- {text: "&fWhite", icon: "colors/white.png"}
- {text: "Balance", icon: "default/balance.png"}
- {text: "Clock", icon: "default/clock.png"}
- {text: "Ping", icon: "default/ping.png"}
- {text: "Players", icon: "default/players.png"}
- {text: "Rank", icon: "default/rank.png"}
- {text: "Server", icon: "default/server.png"}
- "&nPlayer Icons"
-
- {text: "MHF_ArrowRight", icon: "MHF_ArrowRight"}
- {text: "MHF_Question", icon: "MHF_Question"}
- {text: "MHF_Chicken", icon: "MHF_Chicken"}
- {text: "Herobrine", icon: "Herobrine"}
- "&nPing"
- {text: "0", ping: 0}
- {text: "150", ping: 150}
- {text: "250", ping: 300}
- {text: "600", ping: 600}
- {text: "1000", ping: 1000}
- {text: "-1", ping: -1}
- {text: "Player (${viewer ping})", ping: "${viewer ping}"}
```

#### Text Alignment

Instead of the `text` option we can use the `left`, `center` and `right` options to specify the text to be displayed.
Using the `left` option will align the specified text to the left of the slots, same as when using the `text` option.
Using the `center` option will display the text in the middle of the slot and using the `right` option will display the text at the right border of the slot.

![](images/fixed-size-4.png)

```yaml
showTo: all
priority: 1

showHeaderFooter: false

playerSets:
  all_players: all

type: FIXED_SIZE

size: 80

defaultIcon: colors/black.png
defaultPing: 1000

components:
- {left: "Slot 1"}
- {center: "Slot 2"}
- {center: "Slot 3"}
- {right: "Slot 4"}
```

You can also use the `left`, `center` and `right` options simultaneously to display multiple pieces of text with different alignment.
In the following example we display the name and ping of a player.
```yaml
playerComponent: {left: "${player name}", right: "${player ping}"}
```
![](images/alignment-ping.png)

--------------------------------------------------------------------------------

Next: [Fixed Size Tab List - Displaying Players](Fixed-Size-Tab-List---Displaying-Players)
