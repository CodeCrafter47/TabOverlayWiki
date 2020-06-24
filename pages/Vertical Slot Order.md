Usually !!name will fill the slots of the tab list from left to right then top to bottom.
This is different from how vanilla Minecraft does it: top to bottom then left to right.
However, there are different options available to change that, which are explained below.

### Change the Slot Order in the `!players` Component

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
  playerOrder: "alphabetically"
  playerComponent: "${player name}"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
  fillSlotsVertical: true
- !spacer
-
-
- {text: "&cTime: &6${time H:mm:ss}", icon: "default/clock.png", ping: 0}
- {text: "&cPlayers: &6${playerset:all_players size}", icon: "default/players.png", ping: 0}
```

[!]: ifBTLP
### Change the Slot Order in the `!players_by_server` Component

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
  playerOrder: "alphabetically"
  playerComponent: "${player name}"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
  fillSlotsVertical: true
```

[!]: endIF

### Change the Slot Order using the `!container` Component

This option is slightly more complicated, but allows changing the slot order in case where you using multiple `!players` (and other) Components.
To explain how this works let's start with a tab list configuration that uses the default (left-to-right) slot order that we want to change.
What's special about the example below is that staff members are displayed first followed by a list the remaining players .
This is achieved by first using the `!player` component to display all staff members and then another `!players` component to display the remaining players.

![](images/vertical-component-1.png)

```yaml
showTo: all
priority: 0

showHeaderFooter: false

playerSets:
  all_players: all
  staff: ${player permission tablist.staff} = true
  non_staff: ${player permission tablist.staff} = false

type: FIXED_SIZE
size: 60

defaultIcon: colors/dark_gray.png
defaultPing: 1000

components:
- {center: "&e&l━━━ Staff ━━━"}
- !players
  playerSet: staff
  playerComponent: "${player name}"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
-
- {center: "&e&l━━━ Players ━━━"}
- !players
  playerSet: nonstaff
  playerComponent: "${player name}"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
```

Here's a simplified view of what we have to do in order to use the `!container` component to change get a top-to-bottom slot order. Currently, our config (simplified) looks like this:
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

![](images/vertical-component-2.png)

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
  - {center: "&e&l━━━ Staff ━━━"}
  - !players
    playerSet: staff
    playerComponent: "${player name}"
    morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
  -
  - {center: "&e&l━━━ Players ━━━"}
  - !players
    playerSet: non_staff
    playerComponent: "${player name}"
    morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
```

--------------------------------------------------------------------------------

Next: [Component Reference Page](Components)