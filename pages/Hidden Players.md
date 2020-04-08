It is possible to configure whether vanished players will show up on the tab list and who will be able to see them. You can also modify the appearance of hidden players on the tab list so they can be identified as such.

**Note:** You _need_ to install BungeeTabListPlus_BukkitBridge on _all_ Bukkit/ Spigot servers for this to work.

Supported Vanish Plugins
------------------------

For this to work you must be using one of the following vanish plugins:

* Essentials
* SuperVanish/ PremiumVanish
* CMI
* VanishNoPacket
* ProxySuite
* ProtocolVanish

Configure who can see Vanished Players
--------------------------------------

You can use the `hiddenPlayers` option in the tab list configuration file (default.yml) to
change who can see hidden players. The following options are available:

| Value       | Description                                   |
| ----------- | --------------------------------------------- |
| `VISIBLE`   | Hidden players are shown on the tab list.     |
| `VISIBLE_TO_ADMINS` | Players with the `bungeetablistplus.seevanished` permission can see hidden players. This is the default. |
| `INVISIBLE` | Hidden players do not appear on the tab list. |

Have a look at the example at the bottom, then it should be clear how this works.

Change the Appearance of Hidden Players
---------------------------------------

As an example we'll use the custom placeholder mechanism to add a `/vanish` suffix to hidden players:

```yaml
customPlaceholders:
  vanish_suffix: !conditional
    condition: ${player is_hidden}
    true: "&b/vanish"
    false: ""
```

The above code allows us to use the `${vanish_suffix}` placeholder in `playerComponent`.
Now this only makes sense if we set `hiddenPlayers` to `VISIBLE` or `VISIBLE_TO_ADMINS`, so we'll use `VISIBLE_TO_ADMINS` for the following example:

| admin perspective        | player perspective       |
| ------------------------ | ------------------------ |
| ![](images/vanish-1.png) | ![](images/vanish-2.png) |

Complete code:
```yaml
showTo: all
priority: 1

hiddenPlayers: VISIBLE_TO_ADMINS

playerSets:
  all_players: all

customPlaceholders:
  vanish_suffix: !conditional
    condition: ${player is_hidden}
    true: "&b/vanish"
    false: ""

type: DYNAMIC_SIZE

playerSet: all_players
playerOrder: vault_primary_group_weight asc, name
playerComponent: "${player vault_prefix}&f${player name}${vanish_suffix}"
```

Change Visibility of Hidden Player per Player Set
-------------------------------------------------

It is possible to select for each player set whether hidden player should be included.
Just have a look at the following example:

```yaml
playerSets:
  # The global player set contains all players (hidden players are only visible to admins)
  global:
    filter: all
    hiddenPlayers: VISIBLE_TO_ADMINS
  # All players, except for hidden players
  global_without_hidden:
    filter: all
    hiddenPlayers: INVISIBLE
  # All players, always contains hidden players.
  global_with_hidden:
    filter: all
    hiddenPlayers: VISIBLE
```