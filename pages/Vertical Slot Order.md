Usually BungeeTabListPlus will fill the slots of the tab list from left to right then top to bottom.
This is different from how vanilla Minecraft does it: top to bottom then left to right.
However there are different options available to change that, which are explained below.

Change the Slot Order in the `!players` Component
-------------------------------------------------

The `!players` component provides a `fillSlotsVertical` option that can be set to `true` to change the slot order.
In the provided default configuration file this line is not present however you can just add it.

Here's a code snippet illustrating that:
```yaml
- !players
  playerSet: all_players
  fillSlotsVertical: true
  # ...
```

All you have to do is to add the `fillSlotsVertical: true` line to your configuration file.

Here's a screenshot of what this does:

| `fillSlotsVertical: false`            | `fillSlotsVertical: true`             |
| ------------------------------------- | ------------------------------------- |
| ![](images/vertical-slot-order-1.png) | ![](images/vertical-slot-order-2.png) |

The code below is the configuration file which belongs to the above example with `fillSlotsVertical` set to `true`. If you want the other one just change it to `false`.

```yaml
showTo: all
priority: 1
showHeaderFooter: false
playerSets:
  all_players: all
type: FIXED_SIZE
size: 40
defaultIcon: colors/dark_gray.png
defaultPing: 1000
components:
- !players
  playerSet: all_players
  playerOrder: 'alphabetically'
  playerComponent: "${player name}"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
  fillSlotsVertical: true
- !spacer {}
-
-
- {text: "&cTime: &6${time H:mm:ss}", icon: "default/clock.png", ping: 0}
- {text: "&cPlayers: &6${playerset:all_players size}", icon: "default/players.png", ping: 0}
```


Change the Slot Order in the `!players_by_server` Component
-----------------------------------------------------------

If you're using the `!players_by_server` component instead of the `!players` component, don't worry it has the `fillSlotsVertical` option too.
And it works pretty similar to the `!players` component.
All you have to do is to add a line saying `fillSlotsVertical: true`.

Here's a code snippet illustrating that:
```yaml
- !players_by_server
  playerSet: all_players
  fillSlotsVertical: true
  # ...
```

Here's a screenshot showing the difference between setting the `fillSlotsVertical` option to `false` (same as not having it at all) and setting it to `true`:

| `fillSlotsVertical: false`            | `fillSlotsVertical: true`             |
| ------------------------------------- | ------------------------------------- |
| ![](images/vertical-slot-order-4.png) | ![](images/vertical-slot-order-3.png) |

```yaml
showTo: all
priority: 10
showHeaderFooter: false
playerSets:
  all_players: all
type: FIXED_SIZE
size: 40
defaultIcon: colors/dark_gray.png
defaultPing: 1000
components:
- !players_by_server
  playerSet: all_players
  serverHeader:
  - {text: "&e&n${server}&f&o (${server_player_count}):", icon: "colors/yellow.png", ping: 0}
  serverSeparator:
  -
  playerOrder: 'alphabetically'
  playerComponent: "${player name}"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
  fillSlotsVertical: true
```

Change the Slot Order using the `!container` Component
------------------------------------------------------

This option is slightly more complicated, but allows changing the slot order in case where you using multiple `!players` (and other) Components.
To explain how this works let's start with a tab list configuration that uses the default (left-to-right) slot order that we want to change.
What's special about the example below is that admins are displayed first followed by a list of all players grouped by server.
This is achieved by first using the `!player` component to display all admins and then the `!players_by_server` component to display all players grouped by their server.
There are also some custom text slots, one to create a label saying `Admins` and three to create a row of empty slots between the admins in the list of all players.

![](images/vertical-slot-order-5.png)

```yaml
showTo: all
priority: 100

showHeaderFooter: false

playerSets:
  all_players: all
  admins: ${player vault_primary_group} == "Admin"

type: FIXED_SIZE
size: 60

defaultIcon: colors/dark_gray.png
defaultPing: 1000

components:
- {text: "&c&nAdmins&f&o (${playerset:admins size}):", icon: "colors/red.png", ping: 0}
- !players
  playerSet: admins
  playerComponent: "${player vault_prefix}${player name}"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
- ""
- ""
- ""
- !players_by_server
  playerSet: all_players
  serverOrder: "playercount,online,alphabetically"
  serverHeader:
  - {text: "&e&n${server}&f&o (${server_player_count}):", icon: "colors/yellow.png", ping: 0}
  serverSeparator:
  - ""
  playerComponent: "${player vault_prefix}${player name}"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
```

Here's a simplified view of what we have to do in order to use the `!container` component to change get a top-to-bottom slot order. Currently our config (simplified) looks like this:
```yaml
components:
- Component 1
- Component 2
- Component 3
- Component 4
```
Adding the `!container` component and moving all other components inside makes it look like this:
```yaml
components:
- !container
  fillSlotsVertical: true
  components:
  - Component 1
  - Component 2
  - Component 3
  - Component 4
```

By applying that idea to our example configuration from above we get the following result:

![](images/vertical-slot-order-6.png)

```yaml
showTo: all
priority: 100

showHeaderFooter: false

playerSets:
  all_players: all
  admins: ${player vault_primary_group} == "Admin"

type: FIXED_SIZE
size: 60

defaultIcon: colors/dark_gray.png
defaultPing: 1000

components:
- !container
  fillSlotsVertical: true
  components:
  - {text: "&c&nAdmins&f&o (${playerset:admins size}):", icon: "colors/red.png", ping: 0}
  - !players
    playerSet: admins
    playerComponent: "${player vault_prefix}${player name}"
    morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
  - ""
  - !players_by_server
    playerSet: all_players
    serverOrder: "playercount,online,alphabetically"
    serverHeader:
    - {text: "&e&n${server}&f&o (${server_player_count}):", icon: "colors/yellow.png", ping: 0}
    serverSeparator:
    - ""
    playerComponent: "${player vault_prefix}${player name}"
    morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
```

If you compare this result with the original config you may notice that the number of empty slots between the admins and the list of all players has been reduced from three to one. That is because in the original we wanted an entire row of empty slots whereas with the changed slot order we only want a single empty slot.