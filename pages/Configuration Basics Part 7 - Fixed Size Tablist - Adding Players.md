Now let's add some players to the tab list. There are two ways to add players to
 the tab list. Either you use the _players_ or the _players by server_
 component.

Here's the difference:

| _players_ component                | _players by server_ component       |
| ---------------------------------- | ----------------------------------- |
| ![](images/fixed-size-players.png) | ![](images/players-by-server-5.png) |

As you can see the _players_ component just lists the players while the _players
 by server_ component displays them grouped by server.
 
--------------------------------------------------------------------------------

### Using the _players_ component

So here's how to add players to the tab list using the _players_ component:

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
  morePlayersComponent: '... and ${other_count} others'
```

The `!players` marker tells the plugin that we want to use the _players_
 component at that position. After that marker we need to configure some options
 for the _players_ component.

First there's the `playerSet` option. It is used to configure which
 players are displayed on the tab list by specifying a _player set_.

The `playerComponent` controls the format of the player slot. You can use color
 codes and placeholders to customize it. Note when using 
 [Placeholders](Placeholders) that you should use the `player` variant of the 
 placeholder.

The `morePlayersComponent` option is a custom slot that is displayed if there
 isn't enough space for all players on the tab list:
![](images/more-players-component.png)
 
--------------------------------------------------------------------------------

### Adding back our custom slots

When using the players component we can still use custom slots. Here's how it
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
- {text: '&bWelcome', alignment: RIGHT}
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
```

And here's how it looks:
![](images/fixed-size-players.png)

Adding custom slots at the bottom will be discussed later.
 
--------------------------------------------------------------------------------

### Using the _players by server_ component

Now here's how to use the _players by server_ component to display players on
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
- {text: '&bWelcome', alignment: RIGHT}
- '${viewer name}'
-
- !players_by_server
  playerSet: all_players
  serverHeader:
  - '&b&l>&3 ${server}(${server_player_count}):'
  showServers: NON_EMPTY
  playerComponent: "${player name}"
  morePlayersComponent: '... and ${other_count} others'
```

The `!players_by_server` marker tells the plugin that we want to use the
 _players by server_ component to display players in the tab list at that
 position.

After that marker we need to specify some options for the _players bu server_
 component.

First there's the `playerSet` option. It is used to configure which
 players are displayed on the tab list by specifying a _player set_.

Then there's the `serverHeader` option. It is a list of custom slots displayed
 for each server above the players on that server. Here two special placeholders
 `${server}` and `${server_player_count}` can be used to display the name of the
 server and the number of players on it.

The `showServers` controls which servers should appear on the tablist:

| Option      | Description                          |
| ----------- | ------------------------------------ |
| `ALL`       | All servers are displayed            |
| `ONLINE`    | Only running servers are displayed   |
| `NON_EMPTY` | Only non empty servers are displayed |

| ALL | NON_EMPTY |
| ---- | ----- |
| ![](images/players-by-server-2.png) | ![](images/players-by-server-3.png) |

The `playerComponent` controls the format of the player slot. You can use color
 codes and placeholders to customize it. Note when using 
 [Placeholders](Placeholders) that you should use the `player` variant of the 
 placeholder.

The `morePlayersComponent` option is a custom slot that is displayed if there
 isn't enough space for all players on the tab list:
![](images/more-players-component.png)

--------------------------------------------------------------------------------

### Improving the design

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
- {text: '&bWelcome', alignment: RIGHT, icon: colors/gray.png}
- {text: '${viewer name}', icon: colors/gray.png}
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
  - {text: '&b&l>&3 ${server}(${server_player_count}):', icon: 'colors/aqua.png'}
  showServers: NON_EMPTY
  playerComponent: "${player name}"
  morePlayersComponent: '... and ${other_count} others'
```
 
--------------------------------------------------------------------------------

### Adding an empty row between the servers

Now it still looks a bit crowded with the servers following immediately after
 one another. So we solve this by adding an empty row between the servers. To
 do this we use the `serverSeparator` option of the _players by server_
 component:

```yaml
- !players_by_server
  playerSet: all_players
  serverHeader:
  - {text: '&b&l>&3 ${server}(${server_player_count}):', icon: 'colors/aqua.png'}
  serverSeparator:
  -
  -
  -
  -
  showServers: NON_EMPTY
  playerComponent: "${player name}"
  morePlayersComponent: '... and ${other_count} others'
```

The `serverSeparator` option is a list of custom slots displayed between each 
 two adjacent servers. Since it is a list of custom slots we could also add some
 text to it:

```yaml
- !players_by_server
  playerSet: all_players
  serverHeader:
  - {text: '&b&l>&3 ${server}(${server_player_count}):', icon: 'colors/aqua.png'}
  serverSeparator:
  -
  - {text: '-=-', alignment: CENTER}
  - {text: '-=-', alignment: CENTER}
  -
  showServers: NON_EMPTY
  playerComponent: "${player name}"
  morePlayersComponent: '... and ${other_count} others'
```

So this is how it looks in action:
![](images/players-by-server-5.png)

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
- {text: '&bWelcome', alignment: RIGHT, icon: colors/gray.png}
- {text: '${viewer name}', icon: colors/gray.png}
- {icon: colors/gray.png}
-
-
-
-
- !players_by_server
  playerSet: all_players
  serverHeader:
  - {text: '&b&l>&3 ${server}(${server_player_count}):', icon: 'colors/aqua.png'}
  serverSeparator:
  -
  -
  -
  -
  showServers: NON_EMPTY
  playerComponent: "${player name}"
  morePlayersComponent: '... and ${other_count} others'
```
 
--------------------------------------------------------------------------------

### Adding custom slots at the bottom

Let's see what happens if we add some custom slots below the _players by server_
 component like that:

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
- {text: '&bWelcome', alignment: RIGHT, icon: colors/gray.png}
- {text: '${viewer name}', icon: colors/gray.png}
- {icon: colors/gray.png}
-
-
-
-
- !players_by_server
  playerSet: all_players
  serverHeader:
  - {text: '&b&l>&3 ${server}(${server_player_count}):', icon: 'colors/aqua.png'}
  serverSeparator:
  -
  -
  -
  -
  showServers: NON_EMPTY
  playerComponent: "${player name}"
  morePlayersComponent: '... and ${other_count} others'
# Adding four more custom slots here:
- "Four"
- "more"
- "custom"
- "Slots"
```

The result of that modification is the following:

![](images/custom-slots-bottom-1.png)

Not exactly what we want. Now need some way to tell the plugin to move the last
 four custom slots to the bottom. To do that we need to use _spacer_ component:

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
- {text: '&bWelcome', alignment: RIGHT, icon: colors/gray.png}
- {text: '${viewer name}', icon: colors/gray.png}
- {icon: colors/gray.png}
-
-
-
-
- !players_by_server
  playerSet: all_players
  serverHeader:
  - {text: '&b&l>&3 ${server}(${server_player_count}):', icon: 'colors/aqua.png'}
  serverSeparator:
  -
  -
  -
  -
  showServers: NON_EMPTY
  playerComponent: "${player name}"
  morePlayersComponent: '... and ${other_count} others'
# Adding a spacer component
- !spacer {}
# Our four custom slots at the bottom:
- "Four"
- "more"
- "custom"
- "Slots"
```

This is finally what we wanted:

![](images/custom-slots-bottom-2.png)

But how does it work? The spacer component will _occupy up_ as many unused slots
 as it can get which will force our four custom slots to be at the very bottom
 of the tab list.
 
--------------------------------------------------------------------------------

### Further reading

Both the _players_ and the _players by server_ component have more options that
 can used to customize them further. For example you can customize haw the
 players are ordered, and in the case of the _players by server_ component also
 the order in which the servers appear.

You can find out about configuring the player order [here](PlayerOrder).

For all possible options of the components read the
 [Component Reference Page](Components).

--------------------------------------------------------------------------------

Next: [Configuration Basics Part 8 - Fixed Size Tablist - The Table Component](Configuration-Basics-Part-8---Fixed-Size-Tablist---Table)