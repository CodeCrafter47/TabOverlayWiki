[!]: ifBTLP

#### Players Grouped by Server

![](images/default-config.gif)

```yaml
showTo: all
priority: 1

showHeaderFooter: true
header:
- "&cWelcome &f${viewer name}"
- "&eW&celcome &f${viewer name}"
- "&eWe&clcome &f${viewer name}"
- "&eWel&ccome &f${viewer name}"
- "&eWelc&come &f${viewer name}"
- "&eWelco&cme &f${viewer name}"
- "&eWelcom&ce &f${viewer name}"
- "&eWelcome &f${viewer name}"
- "&cW&eelcome &f${viewer name}"
- "&cWe&elcome &f${viewer name}"
- "&cWel&ecome &f${viewer name}"
- "&cWelc&eome &f${viewer name}"
- "&cWelco&eme &f${viewer name}"
- "&cWelcom&ee &f${viewer name}"
- "&cWelcome &f${viewer name}"
headerAnimationUpdateInterval: 0.2
footer:
- |-
  &6Line 1
  &eLine 2
- |-
  &eLine 1
  &6Line 2
footerAnimationUpdateInterval: 0.5

playerSets:
  all_players: all

type: FIXED_SIZE
size: 60

defaultIcon: colors/dark_gray.png
defaultPing: 1000

components:
- {text: "&cServer: &6${viewer server}", icon: "default/server.png", ping: 0}
- {text: "&cRank: &6${viewer vault_primary_group}", icon: "default/rank.png", ping: 0}
- {text: "&cPing: ${viewer_colored_ping}ms", icon: "default/ping.png", ping: 0}
- !players_by_server
  playerSet: all_players
  serverHeader:
  - {text: "", icon: "colors/dark_gray.png", ping: 1000}
  - {text: "", icon: "colors/dark_gray.png", ping: 1000}
  - {text: "", icon: "colors/dark_gray.png", ping: 1000}
  - {text: "&e&n${server}&f&o (${server_player_count}):", icon: "colors/yellow.png", ping: 0}
  showServers: ALL
  playerComponent: "${player name}${afk_tag}"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
- !spacer
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "${animated_bars}", icon: "colors/gold.png", ping: 0}
- {text: "${animated_bars}", icon: "colors/gold.png", ping: 0}
- {text: "${animated_bars}", icon: "colors/gold.png", ping: 0}
- {text: "&cTime: &6${time H:mm:ss}", icon: "default/clock.png", ping: 0}
- {text: "&cPlayers: &6${playerset:all_players size}", icon: "default/players.png", ping: 0}
- {text: "&cBalance: &6${viewer vault_balance 1.2}", icon: "default/balance.png", ping: 0}

customPlaceholders:
  afk_tag:
    !conditional
    condition: ${player essentials_afk}
    true: "&7|&oaway"
    false: ""
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
  animated_bars:
    !animated
    interval: 0.2
    elements:
    - "&6&c=&6=============="
    - "&6=&c=&6============="
    - "&6==&c=&6============"
    - "&6===&c=&6==========="
    - "&6====&c=&6=========="
    - "&6=====&c=&6========="
    - "&6======&c=&6========"
    - "&6=======&c=&6======="
    - "&6========&c=&6======"
    - "&6=========&c=&6====="
    - "&6==========&c=&6===="
    - "&6===========&c=&6==="
    - "&6============&c=&6=="
    - "&6=============&c=&6="
    - "&6==============&c=&6"
```

#### One Column per Server

![](images/one-server-per-column.gif)

```yaml
showTo: all
priority: 1  

showHeaderFooter: true
header:
- "&cWelcome &f${viewer name}"
- "&eW&celcome &f${viewer name}"
- "&eWe&clcome &f${viewer name}"
- "&eWel&ccome &f${viewer name}"
- "&eWelc&come &f${viewer name}"
- "&eWelco&cme &f${viewer name}"
- "&eWelcom&ce &f${viewer name}"
- "&eWelcome &f${viewer name}"
- "&cW&eelcome &f${viewer name}"
- "&cWe&elcome &f${viewer name}"
- "&cWel&ecome &f${viewer name}"
- "&cWelc&eome &f${viewer name}"
- "&cWelco&eme &f${viewer name}"
- "&cWelcom&ee &f${viewer name}"
- "&cWelcome &f${viewer name}"
headerAnimationUpdateInterval: 0.2
footer:
- |-
  &6Line 1
  &eLine 2
- |-
  &eLine 1
  &6Line 2
footerAnimationUpdateInterval: 0.5

playerSets:
  all_players: all
  lobby: ${player server} == "lobby"
  survival: ${player server} == "survival"
  creative: ${player server} == "creative"

type: FIXED_SIZE
size: 60

defaultIcon: colors/dark_gray.png
defaultPing: 1000

components:
- !table
  columns:
    0:
      - {text: "&2&lLobby", icon: "colors/dark_green.png", ping: 0}
      - !players
        playerSet: lobby
        playerComponent: "${player name}${afk_tag}"
        morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/dark_green.png", ping: 0}
    1:
      - {text: "&3&lSurvival", icon: "colors/dark_aqua.png", ping: 0}
      - !players
        playerSet: survival
        playerComponent: "${player name}${afk_tag}"
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
        playerComponent: "${player name}${afk_tag}"
        morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/dark_red.png", ping: 0}

customPlaceholders:
  afk_tag:
    !conditional
    condition: ${player essentials_afk}
    true: "&7|&oaway"
    false: ""
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
```

#### Global Tab List, Dynamic Size

![](images/dynamic-size-config.png)

```yaml
showTo: all
priority: 1

showHeaderFooter: true
header:
- "&cWelcome &f${viewer name}"
- "&eW&celcome &f${viewer name}"
- "&eWe&clcome &f${viewer name}"
- "&eWel&ccome &f${viewer name}"
- "&eWelc&come &f${viewer name}"
- "&eWelco&cme &f${viewer name}"
- "&eWelcom&ce &f${viewer name}"
- "&eWelcome &f${viewer name}"
- "&cW&eelcome &f${viewer name}"
- "&cWe&elcome &f${viewer name}"
- "&cWel&ecome &f${viewer name}"
- "&cWelc&eome &f${viewer name}"
- "&cWelco&eme &f${viewer name}"
- "&cWelcom&ee &f${viewer name}"
- "&cWelcome &f${viewer name}"
headerAnimationUpdateInterval: 0.2
footer: "&f&oPowered by BungeeTabListPlus"

type: DYNAMIC_SIZE

customPlaceholders:
  other_server_prefix: # makes players on other servers gray
    !conditional
    condition: "${viewer server} == ${player server}"
    true: "&f"
    false: "&7"

# Hidden players show up on the tab list, avoids glitches
hiddenPlayers: VISIBLE

playerSets:
  all_players: all

playerSet: all_players

playerOrder: "server viewer-first, server asc, name asc"

playerComponent: "${other_server_prefix}${player name}"
```

#### Info Column, Two Columns for One Server, Two Servers in One Column

![](images/table-demo-config.png)

```yaml
showTo: all
priority: 1

showHeaderFooter: false

playerSets:
  all_players: all
  lobby: ${player server} == "spawn"
  survival: ${player server} == "survival"
  creative: ${player server} == "creative"

type: FIXED_SIZE
size: 80

defaultIcon: "colors/dark_gray.png"
defaultPing: 1000

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
      playerComponent: "${player vault_prefix}${player name}"
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
    3:
    - {text: "&b&lSurvival", icon: "colors/aqua.png", ping: 0}
    - !players
      playerSet: survival
      playerComponent: "${player vault_prefix}${player name}"
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
      minSize: 9
      maxSize: 9
    - {text: "&c&lCreative", icon: "colors/red.png", ping: 0}
    - !players
      playerSet: creative
      playerComponent: "${player vault_prefix}&f${player name}"
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
      minSize: 9
      maxSize: 9
```

#### Using Multiple Slots per Player

![](images/multiple-columns-config.png)

```yaml
showTo: all
priority: 1

showHeaderFooter: true
header:
- "&cWelcome &f${viewer name}"
- "&eW&celcome &f${viewer name}"
- "&eWe&clcome &f${viewer name}"
- "&eWel&ccome &f${viewer name}"
- "&eWelc&come &f${viewer name}"
- "&eWelco&cme &f${viewer name}"
- "&eWelcom&ce &f${viewer name}"
- "&eWelcome &f${viewer name}"
- "&cW&eelcome &f${viewer name}"
- "&cWe&elcome &f${viewer name}"
- "&cWel&ecome &f${viewer name}"
- "&cWelc&eome &f${viewer name}"
- "&cWelco&eme &f${viewer name}"
- "&cWelcom&ee &f${viewer name}"
- "&cWelcome &f${viewer name}"
headerAnimationUpdateInterval: 0.2
footer: "&f&oPowered by BungeeTabListPlus"

playerSets:
  all_players: all

type: FIXED_SIZE
size: 60

defaultIcon: colors/dark_gray.png
defaultPing: 1000

components:
- {text: "&cName", icon: "default/players.png", ping: 0}
- {text: "&cServer", icon: "default/server.png", ping: 0}
- {text: "&cPing", icon: "default/ping.png", ping: 0}
# Here are the players
- !players
  playerSet: all_players
  playerComponent:
    - "${player name}"
    - "${player server}"
    - "${player_colored_ping}ms"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
- !spacer
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "&cTime: &6${time H:mm:ss}", icon: "default/clock.png", ping: 0}
- {text: "&cPlayers: &6${playerset:all_players size}", icon: "default/players.png", ping: 0}
- {text: "&cMC-Version: &6${viewer client_version}", icon: "colors/gold.png", ping: 0}

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
```

#### Only Display Players on the Same Server

![](images/currentserver.png)

```yaml
showTo: all
priority: 1

showHeaderFooter: true
header:
- "&cWelcome &f${viewer name}"
- "&eW&celcome &f${viewer name}"
- "&eWe&clcome &f${viewer name}"
- "&eWel&ccome &f${viewer name}"
- "&eWelc&come &f${viewer name}"
- "&eWelco&cme &f${viewer name}"
- "&eWelcom&ce &f${viewer name}"
- "&eWelcome &f${viewer name}"
- "&cW&eelcome &f${viewer name}"
- "&cWe&elcome &f${viewer name}"
- "&cWel&ecome &f${viewer name}"
- "&cWelc&eome &f${viewer name}"
- "&cWelco&eme &f${viewer name}"
- "&cWelcom&ee &f${viewer name}"
- "&cWelcome &f${viewer name}"
headerAnimationUpdateInterval: 0.2
footer: "&f&oPowered by BungeeTabListPlus"

playerSets:
  all_players: all
  currentserver: ${player server} == ${viewer server}

type: FIXED_SIZE
size: 60

defaultIcon: colors/dark_gray.png
defaultPing: 1000

components:
- {text: "&cServer: &6${viewer server}", icon: "default/server.png", ping: 0}
- {text: "&cRank: &6${viewer vault_primary_group}", icon: "default/rank.png", ping: 0}
- {text: "&cPing: ${viewer_colored_ping}ms", icon: "default/ping.png", ping: 0}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- !players
  playerSet: currentserver
  playerOrder: "name asc"
  playerComponent: "${player vault_prefix}${player name}"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
- !spacer
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "", icon: "colors/dark_gray.png", ping: 1000}
- {text: "${animated_bars}", icon: "colors/gold.png", ping: 0}
- {text: "${animated_bars}", icon: "colors/gold.png", ping: 0}
- {text: "${animated_bars}", icon: "colors/gold.png", ping: 0}
- {text: "&cTime: &6${time H:mm:ss}", icon: "default/clock.png", ping: 0}
- {text: "&cPlayers: &6${playerset:all_players size}", icon: "default/players.png", ping: 0}
- {text: "&cBalance: &6${viewer vault_balance 1.2}$", icon: "default/balance.png", ping: 0}

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
  animated_bars:
    !animated
    interval: 0.2
    elements:
    - "&6&c=&6=============="
    - "&6=&c=&6============="
    - "&6==&c=&6============"
    - "&6===&c=&6==========="
    - "&6====&c=&6=========="
    - "&6=====&c=&6========="
    - "&6======&c=&6========"
    - "&6=======&c=&6======="
    - "&6========&c=&6======"
    - "&6=========&c=&6====="
    - "&6==========&c=&6===="
    - "&6===========&c=&6==="
    - "&6============&c=&6=="
    - "&6=============&c=&6="
    - "&6==============&c=&6"
```

#### Separate Admins and Regular Players

![](images/separate-admin-list-config.png)

```yaml
showTo: all
priority: 1

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
- 
- 
- 
- {text: "&e&l━━━━━━━━━━", icon: "colors/dark_gray.png", ping: 1000, alignment: CENTER}
- {text: "&e&lAdmins", icon: "colors/dark_gray.png", ping: 1000, alignment: CENTER}
- {text: "&e&l━━━━━━━━━━", icon: "colors/dark_gray.png", ping: 1000, alignment: CENTER}
- !players
  playerSet: admins
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

#### Separate Tab List for a Factions Server

![](images/factions-config.gif)
```yaml
# tabLists/Factions.yml

# This tab list should be shown to players on the factions server.
showTo: ${viewer server} == "factions"
# Priority should be higher than the one of the default tab list.
priority: 25

# No header/ footer because space in the wiki is limited ;)
# You can add a header/ footer yourself if you like.
showHeaderFooter: false

type: FIXED_SIZE
size: 60

defaultIcon: "colors/dark_gray.png"
defaultPing: 1000

playerSets:
  global: all
  faction: ${player faction_name} == ${viewer faction_name}

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
    - {text: "&6${playerset:global size}", icon: "default/players.png", ping: 0}
    - {text: "", icon: "colors/gold.png", ping: 0}
    - {text: "&cBalance:", icon: "default/balance.png", ping: 0}
    - {text: "&6${viewer vault_balance}", icon: "default/balance.png", ping: 0}
    - {text: "", icon: "colors/gold.png", ping: 0}
    - {text: "&cTime:", icon: "default/clock.png", ping: 0}
    - {text: "&6${time HH:mm:ss}", icon: "default/clock.png", ping: 0}
    1:
    - {text: "&a&lPlayers", icon: "colors/green.png", ping: 0}
    - !players
      playerSet: global
      playerComponent: "${player vault_prefix}&f${player name}"
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
    2:
     # In the third column there is different content depending on whether the player is member of a faction or not.
    - !conditional
      condition: ${viewer faction_name} == ""
      true: # Not in a faction
      - {text: "&6Faction list", icon: "colors/gold.png", alignment: CENTER}
      -
      -
      -
      -
      -
      -
      -
      -
      - {text: "Not in a Faction", alignment: CENTER}
      - {text: "Join one!", alignment: CENTER}
      false: # Member of a faction
      - {text: "&6Faction &f${viewer faction_name}", icon: "colors/gold.png", alignment: CENTER}
      - {text: "&f${playerset:faction size} of ${viewer faction_member_count} &6Online", icon: "colors/gold.png", alignment: CENTER}
      - 
      - !players 
        playerSet: faction
        playerComponent: "${player name}"
        morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
```

[!]: endIF
[!]: ifATO

There are no examples yet :(

[!]: endIF