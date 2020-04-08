#### Default config

![](images/default-config.gif)

```yaml
showTo: "all"

priority: 21

type: FIXED_SIZE

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

defaultIcon: colors/dark_gray.png
defaultPing: 1000
size: 60
playerSets:
  all_players: all
components:
- {text: "&cServer: &6${viewer server}", icon: "default/server.png", ping: 0}
- {text: "&cRank: &6${viewer vault_primary_group}", icon: "default/rank.png", ping: 0}
# Show ping in different colors depending on how good/ bad it is
- {text: "&cPing: ${viewer_colored_ping}ms", icon: "default/ping.png", ping: 0}
- !players_by_server
  playerSet: all_players
  serverHeader:
  - {text: "", icon: "colors/dark_gray.png", ping: 1000}
  - {text: "", icon: "colors/dark_gray.png", ping: 1000}
  - {text: "", icon: "colors/dark_gray.png", ping: 1000}
  - {text: "&e&n${server}&f&o (${server_player_count}):", icon: "colors/yellow.png", ping: 0}
  showServers: ALL
  playerComponent: {text: "${player name}${afk_tag}", icon: "${player skin}", ping: "${player ping}"}
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
# We want to components below to be at the very bottom of the tab list
- !spacer {}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
# Nice animations at the bottom
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
- {text: "&cPlayers: &6${playerset:all_players size}", icon: "default/players.png", ping: 0}
- {text: "&cBalance: &6${viewer vault_balance 1.2}", icon: "default/balance.png", ping: 0}

```

#### One column per server

![](images/one-server-per-column.gif)

```yaml
showTo: "all"

priority: 22

type: FIXED_SIZE

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

defaultIcon: colors/dark_gray.png
defaultPing: 1000
size: 60
playerSets:
  all_players: all
  lobby: ${player server} == "lobby"
  survival: ${player server} == "survival"
  creative: ${player server} == "creative"
components:
- !table
  columns:
    0:
      - {text: "&2&lLobby", icon: "colors/dark_green.png", ping: 0}
      - !players
        playerSet: lobby
        playerComponent: {text: "${player name}${afk_tag}", icon: "${player skin}", ping: "${player ping}"}
        morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/dark_green.png", ping: 0}
    1:
      - {text: "&3&lSurvival", icon: "colors/dark_aqua.png", ping: 0}
      - !players
        playerSet: survival
        playerComponent: {text: "${player name}${afk_tag}", icon: "${player skin}", ping: "${player ping}"}
        morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/dark_aqua.png", ping: 0}
    2:
      - {text: "&6&lInfo", icon: "colors/gold.png", ping: 0}
      - !animated
        interval: 1.5
        components:
        - {text: "&cBalance: &6${viewer vault_balance 1.2}", icon: "default/balance.png", ping: 0}
        - {text: "&cServer: &6${viewer server}", icon: "default/server.png", ping: 0}
        - {text: "&cRank: &6${viewer vault_primary_group}", icon: "default/rank.png", ping: 0}
        - {text: "&cPing: ${viewer_colored_ping}ms", icon: "default/ping.png", ping: 0}
      - !animated
        interval: 1.5
        components:
        - {text: "&6━━━━━━━━━━━━━━━━━━━━", icon: "colors/gold.png", ping: 0}
        - {text: "&c━━━━━━━━━━━━━━━━━━━━", icon: "colors/gold.png", ping: 0}
      - {text: "", icon: "colors/dark_gray.png", ping: 1000}
      - {text: "&4&lCreative", icon: "colors/dark_red.png", ping: 0}
      - !players
        playerSet: creative
        playerComponent: {text: "${player name}${afk_tag}", icon: "${player skin}", ping: "${player ping}"}
        morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/dark_red.png", ping: 0}
```

#### Global tab list, dynamic size

![](images/dynamic-size-config.png)

```yaml
showTo: "all"
priority: 100

type: DYNAMIC_SIZE

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
- '&f&oPowered by BungeeTabListPlus'

footerAnimationUpdateInterval: 0.5

customPlaceholders:
  other_server_prefix: # makes players on other servers gray
    !conditional
    condition: '${viewer server} == ${player server}'
    true: '&f'
    false: '&7'

# Hidden players show up on the tab list, avoids gliches
hiddenPlayers: VISIBLE

playerSets:
  all_players: all

playerSet: all_players

playerOrder: "playerServerFirst,serverAlphabetically,vaultGroupInfo,alphabetically"

playerComponent: "${other_server_prefix}${player name}"
```

#### Info column, two columns for one server, two servers in one column

![](images/table-demo-config.png)

```yaml
showTo: 'all'
priority: 30

type: FIXED_SIZE

showHeaderFooter: false

defaultIcon: "colors/dark_gray.png"
defaultPing: 1000
size: 80

playerSets:
  all_players: all
  lobby: ${player server} == "spawn"
  survival: ${player server} == "survival"
  creative: ${player server} == "creative"

components:
- !table
  columns:
    0:
    - {text: "&lInfo", icon: "colors/gold.png", ping: 0}
    - {text: "", icon: "colors/gold.png", ping: 0}
    - {text: "", icon: "colors/gold.png", ping: 0}
    - {text: "&cServer:", icon: "default/server.png", ping: 0}
    - {text: "&6${viewer server}", icon: "default/server.png", ping: 0}
    - {text: "", icon: "colors/gold.png", ping: 0}
    - {text: "&cRank:", icon: "default/rank.png", ping: 0}
    - {text: "&6${viewer vault_primary_group}", icon: "default/rank.png", ping: 0}
    - {text: "", icon: "colors/gold.png", ping: 0}
    - {text: "&cPing:", icon: "default/ping.png", ping: 0}
    - {text: "&6${viewer ping}ms", icon: "default/ping.png", ping: 0}
    - {text: "", icon: "colors/gold.png", ping: 0}
    - {text: "&cPlayers:", icon: "default/players.png", ping: 0}
    - {text: "&6${playerset:all_players size}", icon: "default/players.png", ping: 0}
    - {text: "", icon: "colors/gold.png", ping: 0}
    - {text: "&cBalance:", icon: "default/balance.png", ping: 0}
    - {text: "&6${viewer vault_balance}", icon: "default/balance.png", ping: 0}
    - {text: "", icon: "colors/gold.png", ping: 0}
    - {text: "&cTime:", icon: "default/clock.png", ping: 0}
    - {text: "&6${time HH:mm:ss}", icon: "default/clock.png", ping: 0}
    1-2:
    - {text: "&a&lLobby", icon: "colors/green.png", ping: 0}
    - {text: "&a&lLobby", icon: "colors/green.png", ping: 0}
    - !players
      playerSet: lobby
      playerComponent: {text: "${player vault_prefix}${player name}", icon: "${player skin}", ping: "${player ping}"}
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
    3:
    - {text: "&b&lSurvival", icon: "colors/aqua.png", ping: 0}
    - !players
      playerSet: survival
      playerComponent: {text: "${player vault_prefix}${player name}", icon: "${player skin}", ping: "${player ping}"}
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
      minSize: 9
      maxSize: 9
    - {text: "&c&lCreative", icon: "colors/red.png", ping: 0}
    - !players
      playerSet: creative
      playerComponent: {text: "${player vault_prefix}&f${player name}", icon: "${player skin}", ping: "${player ping}"}
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
      minSize: 9
      maxSize: 9
```

#### Using multiple slots per player

![](images/multiple-columns-config.png)

```yaml
showTo: "all"

priority: 200

type: FIXED_SIZE

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
- '&f&oPowered by BungeeTabListPlus'

footerAnimationUpdateInterval: 0.5

customPlaceholders:
  player_colored_ping0:
    !conditional
    condition: "${player ping} < 50"
    true: "&a${player ping}"
    false: "&e${player ping}"
  player_colored_ping:
    !conditional
    condition: "${player ping} < 150"
    true: ${player_colored_ping0}
    false: "&c${player ping}"

defaultIcon: colors/dark_gray.png
defaultPing: 1000
size: 60
playerSets:
  all_players: all
components:
- {text: "&cName", icon: "default/players.png", ping: 0}
- {text: "&cServer", icon: "default/server.png", ping: 0}
- {text: "&cPing", icon: "default/ping.png", ping: 0}
# Here are the players
- !players
  playerSet: all_players
  playerComponent:
    - {text: "${player name}", icon: "${player skin}", ping: "${player ping}"}
    - {text: "${player server}", icon: "${player skin}", ping: "${player ping}"}
    - {text: "${player_colored_ping}ms", icon: "${player skin}", ping: "${player ping}"}
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
# We want to components below to be at the very bottom of the tab list
- !spacer {}
# Another empty row
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "&cTime: &6${time H:mm:ss}", icon: "default/clock.png", ping: 0}
- {text: "&cPlayers: &6${playerset:all_players size}", icon: "default/players.png", ping: 0}
- {text: "&cMC-Version: &6${viewer client_version}", icon: "colors/gold.png", ping: 0}
```

#### Only display players on the same server

![](images/currentserver.png)

```yaml
showTo: "all"

priority: 10

type: FIXED_SIZE

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
- '&f&oPowered by BungeeTabListPlus'

footerAnimationUpdateInterval: 0.5

customPlaceholders:
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

defaultIcon: colors/dark_gray.png
defaultPing: 1000
size: 60
playerSets:
  all_players: all
  currentserver: ${player server} == ${viewer server}
components:
- {text: "&cServer: &6${viewer server}", icon: "default/server.png", ping: 0}
- {text: "&cRank: &6${viewer vault_primary_group}", icon: "default/rank.png", ping: 0}
- {text: "&cPing: ${viewer_colored_ping}ms", icon: "default/ping.png", ping: 0}
# An empty row
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
# Here are the players
- !players
  playerSet: currentserver
  playerOrder: "vaultGroupInfo,alphabetically"
  playerComponent: {text: "${player vault_prefix}${player name}", icon: "${player skin}", ping: "${player ping}"}
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
# We want to components below to be at the very bottom of the tab list
- !spacer {}
# Another empty row
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
# Nice animations at the bottom
- &animated_line
  !animated
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
- *animated_line
- *animated_line
- {text: "&cTime: &6${time H:mm:ss}", icon: "default/clock.png", ping: 0}
- {text: "&cPlayers: &6${playerset:all_players size}", icon: "default/players.png", ping: 0}
- {text: "&cBalance: &6${viewer vault_balance 1.2}$", icon: "default/balance.png", ping: 0}
```


#### Separate Admins and Regular Players

![](images/separate-admin-list-config.png)

```yaml
showTo: all
priority: 10

showHeaderFooter: false

playerSets:
  all_players: all
  admins: ${player vault_primary_group} == "Admin"
  nonadmins: ${player vault_primary_group} != "Admin"

type: FIXED_SIZE
size: 60

defaultIcon: colors/dark_gray.png
defaultPing: 1000

components:
- {text: "&cServer: &6${viewer server}", icon: "default/server.png", ping: 0}
- {text: "&cRank: &6${viewer vault_primary_group}", icon: "default/rank.png", ping: 0}
- {text: "&cPing: &6${viewer ping}ms", icon: "default/ping.png", ping: 0}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "&e&l━━━━━━━━━━", icon: "colors/dark_gray.png", ping: 1000, alignment: CENTER}
- {text: "&e&lAdmins", icon: "colors/dark_gray.png", ping: 1000, alignment: CENTER}
- {text: "&e&l━━━━━━━━━━", icon: "colors/dark_gray.png", ping: 1000, alignment: CENTER}
- !players
  playerSet: admins
  playerOrder: "alphabetically"
  playerComponent: "${player name}"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
- !table {} # Adding an empty table component will cause the next component to be in the leftmost column
-
-
-
- {text: "&e&l━━━━━━━━━━", icon: "colors/dark_gray.png", ping: 1000, alignment: CENTER}
- {text: "&e&lPlayers", icon: "colors/dark_gray.png", ping: 1000, alignment: CENTER}
- {text: "&e&l━━━━━━━━━━", icon: "colors/dark_gray.png", ping: 1000, alignment: CENTER}
- !players
  playerSet: nonadmins
  playerOrder: "alphabetically"
  playerComponent: "${player name}"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
- !spacer {}
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