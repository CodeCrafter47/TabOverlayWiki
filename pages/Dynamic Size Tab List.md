As you have already learned there are two types of tab lists.
This page discusses the `DYNAMIC_SIZE` tab list type.
It is able to adjust its size to the number of players much like vanilla, but it does not allow for slots with custom content.

The image below shows how a dynamic size tab list can look.
![](images/dynamic-size-ato.png)

### Example

Here is a simple tab list configuration file to create a dynamic size tab list.
You can use this as starting point for creating your own tab list configuration file.

```yaml
showTo: all
priority: 0

# Hidden players show up on the tab list, avoids glitches
hiddenPlayers: VISIBLE

playerSets:
  all_players: all

showHeaderFooter: true
header: "&cWelcome &f${viewer name}"
footer: "&f&oplay.example.net"

type: DYNAMIC_SIZE

playerSet: all_players
playerOrder: "name"
playerComponent: "${player name}"
```

### `DYNAMIC_SIZE` Specific Options

In the following we have a closer look at the options specific to the `DYNAMIC_SIZE` tab list type.

* ##### `playerSet`

    The `playerSet` option selects which players to display on the tab list.
    
    [!]: ifBTLP
    If you want to change which players the tab list displays, e.g. so it only displays players on a specific server, do the following:
    
    [!]: endIf
    [!]: ifATO
    If you want to change which players the tab list displays, e.g. so it only displays players in a specific world or players with a specific permission, do the following:
    
    [!]: endIf
    1.  Create a player set containing the players you want to display.
        Check out the [Player Sets](Player-Sets) wiki page for more information.
    2.  Set `playerSet` to the name of the player set you created in step i.

* ##### `playerOrder`

    The `playerOrder` option specifies the order in which players are displayed on the tab list.
    Have a look at the [Player Order](Player-Order) wiki page for more information.

* ##### `playerComponent`
    
    The `playerComponent` option controls the text displayed in player slots.
    You can use placeholders to display nicknames, prefixes and suffixes and otherwise change the appearance of the player name.
    
    Note that when using placeholders you should use the `player` variant of the placeholder.
    If you were to use the `viewer` variant the plugin would resolve the placeholder for the person looking at the tab list.
    You would notice that mistake pretty quickly if all the players suddenly have your name.

--------------------------------------------------------------------------------

Next: [Fixed Size Tab List](Fixed-Size-Tab-List)