As you've already learned BungeeTabListPlus distinguishes between two types of
 tab lists. This page discusses the dynamic size tab list. The dynamic size tab
 list adjusts it's size to the number of players that are to be displayed and it
 doesn't allow for slots with custom content.

The image below shows how a dynamic size tab list can look.
![Image of a dynamic size tab list](images/dynamic-size-config.png)

Now here's a tab list configuration file to create a dynamic size tab list:

```yaml
showTo: "all"
priority: 0

# Hidden players show up on the tab list, avoids glitches
hiddenPlayers: VISIBLE

playerSets:
  all_players: all

# A simple header and footer
showHeaderFooter: true
header:
- '&cWelcome &f${viewer name}'
headerAnimationUpdateInterval: 1.0
footer:
- '&f&oPowered by BungeeTabListPlus'
footerAnimationUpdateInterval: 1.0

# We want a dynamic size tab list
type: DYNAMIC_SIZE

# Below are the options specific to the dynamic size tab list

# Here you can configure which players to display by specifying a player set.
# For this example we are using the `all_players` player set created above.
playerSet: all_players

# Here the order of the players can be configured.
playerOrder: "alphabetically"

# This option controls the format of the players names.
playerComponent: "${player name}"
```

Now let's have a closer look at the dynamic size tab list specific configuration
 options:

The `playerSet` option is used to configure which players are displayed on the 
 tab list.

The `playerOrder` option is used to configure the order of the players. 
 [More info](PlayerOrder)
   
The `playerComponent` controls the format of the player slot. Add prefixes as 
 you like. Note when using [Placeholders](Placeholders) that you should use the 
 `player` variant of the placeholder.

--------------------------------------------------------------------------------

Next: [Configuration Basics Part 6 - Fixed Size Tablist Introduction](Configuration-Basics-Part-6---Fixed-Size-Tablist-Introduction)