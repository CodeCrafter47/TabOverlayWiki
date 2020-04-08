Integrating with PermissionsEx
==============================


Prerequisites
-------------
For BungeeTabListPlus to be able to hook into PermissionsEx you need to meet the
 following requirements:

 1. A __recent__ version of PermissionsEx is required.
 2. You need to install a __recent__ version of Vault on __all__ your Spigot/ Bukkit
    servers.
 3. You need to install BungeeTabListPlus_BukkitBridge on __all__ your Spigot/ Bukkit servers.

After that BungeeTabListPlus should be able to get permission information, group
 information and prefix/ suffix information from PermissionsEx.

You can use the following placeholders to display that information:

Placeholder | Explanation
 :---: | -----------
`${viewer vault_primary_group}`<br />and<br />`${player vault_primary_group}` | The primary group of a player. Read below for more information about how PermissionsEx determines the primary group of a player.
`${viewer vault_prefix}`<br />or<br />`${player vault_prefix}`   | The prefix of a player.
`${viewer vault_suffix}`<br />or<br />`${player vault_suffix}`   | The suffix of a player.


The primary group
-----------------
All the placeholders above depend on PermissionsEx to pick the correct primary
 group. If you only assign one group to a player then you won't have any problems.
 But often it is required to assign multiple groups to a player. In these cases
 it often happens that the plugin doesn't choose the group you want as primary
 group. To fix this it is important to know how PermissionsEx determines the
 primary group of a player.

PermissionsEx chooses the primary group using the following rules:

 1. If you set the weight property of your groups, then groups with lower weight
    will take priority over groups with higher weight. The group with the lowest
    weight will be the primary group.
 2. If the weight property is not set, then the group which has been added first
    will be the primary group.

I strongly recommend you use the weight property to handle group priorities if
 you require to assign multiple groups to a player. Additionally if you want the
 players in the tab list to be sorted by the permission groups from PEX it is
 absolutely required that the weight property is set.


Sorting players in the tab list
-------------------------------
BungeeTabListPlus can sort players in the tab list based on the information from
 PermissionsEx. For this to work it is mandatory that you set the weight
 property for all your groups.

To sort the players BungeeTabListPlus will take the weight of the primary group
 of the player and then make players with lower weight appear above players with
 higher weight.

To enable sorting players using permission information you need to make the following change to your tab list configuration:
```yaml
playerOrder: "vaultGroupInfo"
```

Example Config
--------------

Here's an example og how the default config looks after applying all the information from above:

```yaml
showTo: "true"

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
  global: all
components:
- {text: "&cServer: &6${viewer server}", icon: "default/server.png", ping: 0}
- {text: "&cRank: &6${viewer vault_primary_group}", icon: "default/rank.png", ping: 0}
# Show ping in different colors depending on how good/ bad it is
- {text: "&cPing: ${viewer_colored_ping}ms", icon: "default/ping.png", ping: 0}
- !players_by_server
  playerSet: global
  # SORT PLAYERS:
  playerOrder: "vaultGroupInfo"
  serverHeader:
  - {text: "", icon: "colors/dark_gray.png", ping: 1000}
  - {text: "", icon: "colors/dark_gray.png", ping: 1000}
  - {text: "", icon: "colors/dark_gray.png", ping: 1000}
  - {text: "&e&n${server}&f&o (${server_player_count}):", icon: "colors/yellow.png", ping: 0}
  includeEmptyServers: true
  # ADD PREFIX AND SUFFIX:
  playerComponent: {text: "${player vault_prefix}${player name}${player vault_suffix}${afk_tag}", icon: "${player skin}", ping: "${player ping}"}
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
- {text: "&cPlayers: &6${playerset:global size}", icon: "default/players.png", ping: 0}
- {text: "&cBalance: &6${viewer vault_balance 1.2}", icon: "default/balance.png", ping: 0}

```