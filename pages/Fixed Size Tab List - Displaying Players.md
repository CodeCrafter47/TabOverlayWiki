Now it is time to display players to the tab list.
[!]: ifBTLP
There are two ways to add players to
 the tab list. Either you use the `!players` or the `!players_by_server`
 component.

You can see the difference in the following comparison.

| `!players` component                | `!players_by_server` component       |
| ---------------------------------- | ----------------------------------- |
| ![](images/fixed-size-players.png) | ![](images/players-by-server-5.png) |

As you can see the `!players` component just lists the players while the `!players_by_server` component displays them grouped by server.

[!]: endIF
[!]: ifATO
This is done using the `!players` component.
[!]: endIF

### Content
[!]: ToC

### Using the `!players` component

In the following you see a very simplistic example displaying players on the tab list using the `!players` component.

![](images/fixed-size-players-2.png)

```yaml
showTo: "true"
priority: 1

showHeaderFooter: false

playerSets:
  all_players: all

type: FIXED_SIZE

size: 80

defaultIcon: colors/black.png
defaultPing: 1000

components:
- !players
  playerSet: all_players
  playerComponent: "${player name}"
  morePlayersComponent: "... and ${other_count} others"
```

The `!players` tag tells the plugin that we want to use the `!players`
 component at that position. After that tag we need to configure some options
 for the `!players` component.

#### Options of the `!players` Component

Here we have a look at the three options of the `!players` component used in the example above.
There are more options available.
Those are described in the [Components](Components) wiki page.

* ##### `playerSet`

    The `playerSet` option selects which players to display on the tab list.
    
    If you want to change which players the tab list displays, e.g. so it only displays players in a specific group, do the following:
    1.  Create a player set containing the players you want to display.
        Check out the [Player Sets](Player-Sets) wiki page for more information.
    2.  Set `playerSet` to the name of the player set you created in step i.

* ##### `playerComponent`
    
    The `playerComponent` option controls the text displayed in player slots.
    You can use placeholders to display nicknames, prefixes and suffixes and otherwise change the appearance of the player name.
    
    Note that when using placeholders you should use the `player` variant of the placeholder.

* ##### `morePlayersComponent`

    The `morePlayersComponent` option is a custom slot that is displayed if there
     is not enough space on the tab list to display all of the players:
    ![](images/more-players-component-2.png)
 
#### Adding Back our Custom Slots

When using the players component we can still use custom slots. Here is how it
 works:

```yaml
showTo: "true"
priority: 1

showHeaderFooter: false

playerSets:
  all_players: all

type: FIXED_SIZE

size: 80

defaultIcon: colors/black.png
defaultPing: 1000

components:
-
- {right: "&bWelcome"}
- "${viewer name}"
-
-
-
-
-
- !players
  playerSet: all_players
  playerComponent: "${player name}"
  morePlayersComponent: "... and ${other_count} others"
```

And here is how it looks:
![](images/fixed-size-players.png)

#### Adding Custom Slots at the Bottom

Let's see what happens if we add some custom slots below the `!players`
 component like this:

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
-
- {right: '&bWelcome'}
- '${viewer name}'
-
-
-
-
-
- !players
  playerSet: all_players
  playerComponent: "${player name}"
  morePlayersComponent: '... and ${other_count} others'
# Add four more custom slots here:
- "&eFour"
- "&emore"
- "&ecustom"
- "&eSlots"
```

The result of that modification is the following:

![](images/fixed-size-players-3.png)

Not exactly what we want. Now need some way to tell the plugin to move the last
 four custom slots to the bottom. To do that we need to use `!spacer` component:

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
-
- {right: '&bWelcome'}
- '${viewer name}'
-
-
-
-
-
- !players
  playerSet: all_players
  playerComponent: "${player name}"
  morePlayersComponent: '... and ${other_count} others'
# Add the !spacer component
- !spacer
# Add four more custom slots here:
- "&eFour"
- "&emore"
- "&ecustom"
- "&eSlots"
```

This is finally what we wanted:

![](images/fixed-size-players-4.png)

But how does it work? The `!spacer` component will _occupy_ as many unused slots
 as it can, which will force our four custom slots to be at the very bottom
 of the tab list.
 
#### Using the `!players` Component Multiple Times

In this example we will use the `!players` component twice to display staff separately from the other players.
For the purpose of this example we assume that all staff member have the `tablist.staff` permission.
We create two player sets:
One called `staff` which contains all players with the `tablist.staff` permission.
And one called `non_staff` which contains all players not have the `tablist.staff` permission.

We use the `!players` component twice. The first time with the `staff` player set and the second time with the `non_staff` player set.
Custom slots are used to clearly separate the two. 

![](images/separate-staff.png)

```yaml
showTo: all
priority: 1000

showHeaderFooter: false

playerSets:
  all_players: all
  staff: ${player permission tablist.staff}
  non_staff: ( !${player permission tablist.staff} )

type: FIXED_SIZE
size: 60

defaultIcon: colors/dark_gray.png
defaultPing: 1000

components:
- {text: "&cRank: &6${viewer vault_primary_group}", icon: "default/rank.png", ping: 0}
- {text: "&cPing: &6${viewer ping}ms", icon: "default/ping.png", ping: 0}
[!]: ifBTLP
- {text: "&cTPS: &6${viewer server tps}", icon: "default/server.png", ping: 0}
[!]: endIF
[!]: ifATO
- {text: "&cTPS: &6${viewer server_tps}", icon: "default/server.png", ping: 0}
[!]: endIF
- 
- 
- 
- {center: "&e&l━━━━━━━━━━"}
- {center: "&e&lStaff"}
- {center: "&e&l━━━━━━━━━━"}
- !players
  playerSet: staff
  playerComponent: "${player name}"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
- !table {} # Adding an empty table component will cause the next component to be in the leftmost column
-
-
-
- {center: "&e&l━━━━━━━━━━"}
- {center: "&e&lPlayers"}
- {center: "&e&l━━━━━━━━━━"}
- !players
  playerSet: non_staff
  playerComponent: "${player name}"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
- !spacer
-
-
-
- {text: "&6=============", icon: "colors/gold.png", ping: 0}
- {text: "&6=============", icon: "colors/gold.png", ping: 0}
- {text: "&6=============", icon: "colors/gold.png", ping: 0}
- {text: "&cTime: &6${time H:mm:ss}", icon: "default/clock.png", ping: 0}
- {text: "&cPlayers: &6${playerset:all_players size}", icon: "default/players.png", ping: 0}
- {text: "&cBalance: &6${viewer vault_balance}", icon: "default/balance.png", ping: 0}
```
 
[!]: ifBTLP
### Using the `!players_by_server` component

Now here's how to use the `!players_by_server` component to display players on
 the tab list.

![](images/players-by-server-1.png)

```yaml
showTo: "true"
priority: 1

showHeaderFooter: false

playerSets:
  all_players: all

type: FIXED_SIZE

size: 80

defaultIcon: colors/black.png
defaultPing: 1000

components:
-
- {right: "&bWelcome"}
- "${viewer name}"
-
- !players_by_server
  playerSet: all_players
  serverHeader:
  - "&b&l>&3 ${server}(${server_player_count}):"
  showServers: NON_EMPTY
  playerComponent: "${player name}"
  morePlayersComponent: "... and ${other_count} others"
```

The `!players_by_server` tag tells the plugin that we want to use the
 `!players_by_server` component to display players in the tab list at that
 position.

After that tag we need to specify some options for the _players bu server_
 component.

#### Options of the `!players_by_server` Component

Here we have a look at the options of the `!players_by_server` component used in the example above.
There are more options available.
Some will be described as we learn more about the `!players_by_server` component with the following examples.
A complete list can be found on the [Components](Components) wiki page.

* ##### `playerSet`

    The `playerSet` option selects which players to display on the tab list.
    
    If you want to change which players the tab list displays, e.g. so it only displays players in a specific group, do the following:
    1.  Create a player set containing the players you want to display.
        Check out the [Player Sets](Player-Sets) wiki page for more information.
    2.  Set `playerSet` to the name of the player set you created in step i.

* ##### `serverHeader`

    Then there's the `serverHeader` option. It is a list of custom slots displayed
     for each server above the players on that server. Here two special placeholders
     `${server}` and `${server_player_count}` can be used to display the name of the
     server and the number of players on it.

* ##### `showServers`

    The `showServers` controls which servers should appear on the tablist:
    
    | Option      | Description                          |
    | ----------- | ------------------------------------ |
    | `ALL`       | All servers are displayed            |
    | `ONLINE`    | Only running servers are displayed   |
    | `NON_EMPTY` | Only non empty servers are displayed |
    
    Example:
    
    | ALL | NON_EMPTY |
    | ---- | ----- |
    | ![](images/players-by-server-2.png) | ![](images/players-by-server-3.png) |

* ##### `playerComponent`
    
    The `playerComponent` option controls the text displayed in player slots.
    You can use placeholders to display nicknames, prefixes and suffixes and otherwise change the appearance of the player name.
    
    Note that when using placeholders you should use the `player` variant of the placeholder.

* ##### `morePlayersComponent`

    The `morePlayersComponent` option is a custom slot that is displayed if there
     is not enough space on the tab list to display all of the players:
    ![](images/more-players-component.png)

#### Adding Custom Slots at the Top

Now let's improve the above design a little:

![](images/players-by-server-4.png)

```yaml
showTo: "true"
priority: 1

showHeaderFooter: false

playerSets:
  all_players: all

type: FIXED_SIZE

size: 80

defaultIcon: colors/black.png
defaultPing: 1000

components:
# Use colors/gray.png as icon for the first row
- {icon: colors/gray.png}
- {right: "&bWelcome", icon: colors/gray.png}
- {text: "${viewer name}", icon: colors/gray.png}
- {icon: colors/gray.png}
# add another row of empty slots here:
-
-
-
-
- !players_by_server
  playerSet: all_players
  # Add an icon to the server header
  serverHeader:
  - {text: "&b&l>&3 ${server}(${server_player_count}):", icon: "colors/aqua.png"}
  showServers: NON_EMPTY
  playerComponent: "${player name}"
  morePlayersComponent: "... and ${other_count} others"
```

#### Adding an Empty Row Between the Servers


![](images/players-by-server-5.png)

Now it still looks a bit crowded with the servers following immediately after
 one another. So we solve this by adding an empty row between the servers. To
 do this we use the `serverSeparator` option of the `!players_by_server`
 component:

```yaml
- !players_by_server
  playerSet: all_players
  serverHeader:
  - {text: "&b&l>&3 ${server}(${server_player_count}):", icon: "colors/aqua.png"}
  serverSeparator:
  -
  -
  -
  -
  showServers: NON_EMPTY
  playerComponent: "${player name}"
  morePlayersComponent: "... and ${other_count} others"
```

The `serverSeparator` option is a list of custom slots displayed between each 
 two adjacent servers.


And here's the complete config again for reference:
```yaml
showTo: "true"
priority: 1

showHeaderFooter: false

playerSets:
  all_players: all

type: FIXED_SIZE

size: 80

defaultIcon: colors/black.png
defaultPing: 1000

components:
- {icon: colors/gray.png}
- {right: "&bWelcome", icon: colors/gray.png}
- {text: "${viewer name}", icon: colors/gray.png}
- {icon: colors/gray.png}
-
-
-
-
- !players_by_server
  playerSet: all_players
  serverHeader:
  - {text: "&b&l>&3 ${server}(${server_player_count}):", icon: "colors/aqua.png"}
  serverSeparator:
  -
  -
  -
  -
  showServers: NON_EMPTY
  playerComponent: "${player name}"
  morePlayersComponent: "... and ${other_count} others"
```

### Adding Custom Slots at the Bottom

![](images/custom-slots-bottom-2.png)
We can add custom slots at the bottom the same way as when using the `!players` component.

```yaml
showTo: "true"
priority: 1

showHeaderFooter: false

playerSets:
  all_players: all

type: FIXED_SIZE

size: 80

defaultIcon: colors/black.png
defaultPing: 1000

components:
- {icon: colors/gray.png}
- {right: "&bWelcome", icon: colors/gray.png}
- {text: "${viewer name}", icon: colors/gray.png}
- {icon: colors/gray.png}
-
-
-
-
- !players_by_server
  playerSet: all_players
  serverHeader:
  - {text: "&b&l>&3 ${server}(${server_player_count}):", icon: "colors/aqua.png"}
  serverSeparator:
  -
  -
  -
  -
  showServers: NON_EMPTY
  playerComponent: "${player name}"
  morePlayersComponent: "... and ${other_count} others"
# Add a spacer component
- !spacer {}
# Our four custom slots at the bottom:
- "Four"
- "more"
- "custom"
- "Slots"
```
[!]: endIF

### Further reading

[!]: ifBTLP
Both the `!players` and the `!players_by_server` component have more options that
 can used to customize them further. For example you can customize how the
 players are ordered, and in the case of the `!players_by_server` component also
 the order in which the servers appear.
 
[!]: endIF
[!]: ifATO

The `!players` component has more options that can used to customize its appearance further.

[!]: endIF

You can find out about configuring the player order on the [Player Order](Player-Order) page.

For all possible options of the components have a look at the
 [Components](Components) page.

--------------------------------------------------------------------------------

Next: [Fixed Size Tab List - The Table Component](Fixed-Size-Tab-List---The-Table-Component)