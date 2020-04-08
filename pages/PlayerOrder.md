All components which insert players to the tab list allow for setting a `playerOrder` option. This can be used to
 specify the order of the players in the tab list.

**Example 1:** Sorts players alphabetically
```yaml
!players
playerSet: all_players
playerOrder: "name asc"
...
```

The `playerOrder` option is set to the comparison rule to use.

**Example 2:** Sorts players by permission rank and players of the same rank alphabetically
```yaml
!players
playerSet: all_players
playerOrder: "vault_primary_group_weight asc, name asc"
...
```

The `,` operator can be used to chain as many different comparison rules as you like.

In theory you can use any placeholder to sort players by simply putting down its id followed by `asc` or `desc`, but to make your life easier here's a list of some useful ones.

| Rule                     | Description                                                                                |
| ------------------------ |------------------------------------------------------------------------------------------- |
| `name` or `name asc`         | will fill in the players in an alphabetic order. The `asc` is optional.                                            |
| `name viewer-first`               | will fill in the player that views the tablist first                                       |
| `vault_primary_group_weight asc`         | Sorts players by the weight of their primary group. For most plugins low weight equals a high rank, so this is the one you'll want to use. **Note:** You need to install _BungeeTabListPlus_BukkitBridge.jar_ on your Spigot servers for this to work. |
| `vault_primary_group_weight desc` | Sorts players by the weight of their primary group, but starting with the highest weight going to the lowest.  **Note:** You need to install _BungeeTabListPlus_BukkitBridge.jar_ on your Spigot servers for this to work. |
| `vault_prefix`            | Sorts players by their prefix, alphabetically. You can use this if setting up weights is too complicated for you. **Note:** You need to install _BungeeTabListPlus_BukkitBridge.jar_ on your Spigot servers for this to work. |
| `luckpermsbungee_primary_group_weight desc` | Sorts players by the weight of their primary group - for those of you using LuckPerms installed on BungeeCord. |
| `faction_name viewer-first`           | players which are in the same faction as the player who sees the tablist appear at the top |
| `faction_name asc`               | players by faction alphabetically                                                          |
| `server`              | players by the name of the server they are playing on alphabetically                        |
| `server viewer-first`       | players which are in the same server as the player who sees the tab list appear at the top   |