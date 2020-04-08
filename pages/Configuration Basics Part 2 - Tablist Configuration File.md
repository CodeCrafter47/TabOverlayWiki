The look of the tab list is configured in the `tabLists/default.yml` file. This page explains the how that file is structured.

It is possible to create multiple tab list layouts by creating multiple `*.yml` files in the `tabLists` directory with the format described here. Doing so can be useful to e.g. display a different tab list to admins or to players on a particular server. For more information see [Multiple tablist configuration files](MultipleTablists).

Each tab list configuration file is divided into two parts. The _common part_ that is the same in all tab list configuration files and a _type specific part_ that is different depending on whether you want to create a tab list with fixed size or with dynamic size(adjusting to the number of players online).

| FIXED_SIZE                     | DYNAMIC_SIZE                        |
| ------------------------------ | ----------------------------------- |
| ![](images/default-config.gif) | ![](images/dynamic-size-config.png) |

Common Part
===========

The following code sample is just there so you see which config entries make up
 the common part of the tab list configuration file. If some of them look
 complicated to you, don't worry there will be detailed explanations following.

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

hiddenPlayers: VISIBLE_TO_ADMINS

playerSets:
  all_players: all

type: FIXED_SIZE
```


The `type` can either be set to `FIXED_SIZE` or `DYNAMIC_SIZE`. Depending on
 which one you choose different type specific config options will be available.

The `FIXED_SIZE` option gives you a tab list (with fixed size) that looks a bit like the pre 1.8 tab list. It allows
for custom slots to display additional information to the player.

The `DYNAMIC_SIZE` option is a bit like the vanilla tab list. It changes its size to adjust to the amount of players
online. However it does not allow for custom slots.


`FIXED_SIZE` Specific Part
==========================

This code sample is there to show which config entries make up the fixed size
 specific part of the config. Don't worry if you don't understand it yet, it's
 just there as an example.
 
```yaml
size: 60

defaultIcon: colors/dark_gray.png
defaultPing: 1000

longText: CROP_2DOTS

components:
- {text: "&cServer: &6${viewer server}", icon: "default/server.png", ping: 0}
- {text: "&cRank: &6${viewer vault_primary_group}", icon: "default/rank.png", ping: 0}
- {text: "&cPing: ${viewer_colored_ping}ms", icon: "default/ping.png", ping: 0}
-
-
-
- !players_by_server
  playerSet: all_players
  serverHeader:
  - {text: "&e&n${server}&f&o (${server_player_count}):", icon: "colors/yellow.png", ping: 0}
  serverSeparator:
  -
  -
  -
  includeEmptyServers: true
  playerComponent: "${player vault_prefix}${player name}${afk_tag}"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
- !spacer
-
-
-
- {text: "&cTime: &6${time H:mm:ss}", icon: "default/clock.png", ping: 0}
- {text: "&cPlayers: &6${playerset:all_players size}", icon: "default/players.png", ping: 0}
- {text: "&cBalance: &6${viewer vault_balance}", icon: "default/balance.png", ping: 0}
```

`DYNAMIC_SIZE` Specific Part
============================

```yaml
playerSet: all_players

playerOrder: "vault_primary_group_weight asc,name"

playerComponent: "${player name}"
```

--------------------------------------------------------------------------------

Next: [Configuration Basics Part 3 - Header and Footer](Configuration-Basics-Part-3---Header-and-Footer)