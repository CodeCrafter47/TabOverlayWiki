The `DYNAMIC_SIZE_FIXED_COLUMNS` tab list type is very similar to the `FIXED_SIZE` tab list type. As such it provides almost the same type specific options. The difference between the two is that while using the `FIXED_SIZE` tab list type you specify the number of slots the tab list should have, when using the `DYNAMIC_SIZE_FIXED_COLUMNS` tab list type you specify the number of columns the tab list should have and BungeeTabListPlus dynamically adjust the number of rows, to fit the content.

This is how it looks in action:

![](images/fixed-columns-1.png)
![](images/fixed-columns-2.png)

Here's the config file. Note how it looks very similar to the `FIXED_SIZE` config type.

```yaml
showTo: all
priority: 10

showHeaderFooter: false

hiddenPlayers: VISIBLE

playerSets:
  global: all

type: DYNAMIC_SIZE_FIXED_COLUMNS

# The number of columns can be configured here
# Can be between 1 and 4
columns: 1

defaultIcon: colors/dark_gray.png
defaultPing: 1000

components:
- {text: "&6===============", icon: "colors/gold.png", ping: 0}
- {text: "&cServer: &6${viewer server}&e", icon: "default/server.png", ping: 0}
- {text: "&cRank: &6${viewer vault_primary_group}", icon: "default/rank.png", ping: 0}
- {text: "&cPing: &6${viewer ping}ms", icon: "default/ping.png", ping: 0}
- {text: "&6===============", icon: "colors/gold.png", ping: 0}
- !players
  playerSet: global
  playerOrder: connectedFirst
  playerComponent: "${player vault_prefix}${player name}"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
- !spacer {}
- {text: "&6===============", icon: "colors/gold.png", ping: 0}
```

When using 2 columns:

![](images/fixed-columns-3.png)

Note that the range in which the number of rows can be is limited. When using 2 columns the number or rows must be between 11 and 20.

Here's the config when using two columns:

```yaml
showTo: all
priority: 10

showHeaderFooter: false

hiddenPlayers: VISIBLE

playerSets:
  global: all

type: DYNAMIC_SIZE_FIXED_COLUMNS

# The number of columns can be configured here
# Can be between 1 and 4
columns: 2

defaultIcon: colors/dark_gray.png
defaultPing: 1000

components:
- {text: "&6===============", icon: "colors/gold.png", ping: 0}
- {text: "&6===============", icon: "colors/gold.png", ping: 0}
- {text: "&cServer: &6${viewer server}&e", icon: "default/server.png", ping: 0}
- {text: "&cRank: &6${viewer vault_primary_group}", icon: "default/rank.png", ping: 0}
- {text: "&cPing: &6${viewer ping}ms", icon: "default/ping.png", ping: 0}
- {text: "&cTPS: &6${viewer server tps}", icon: "default/ping.png", ping: 0}
- {text: "&6===============", icon: "colors/gold.png", ping: 0}
- {text: "&6===============", icon: "colors/gold.png", ping: 0}
- !players
  playerSet: global
  playerOrder: connectedFirst
  playerComponent: "${player vault_prefix}${player name}"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
- !spacer {}
- {text: "&6===============", icon: "colors/gold.png", ping: 0}
- {text: "&6===============", icon: "colors/gold.png", ping: 0}
```