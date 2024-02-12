### Content
[!]: ToC

### Player bound placeholders

Each player related placeholder comes in two versions: One for the player viewing the tab list on one for a player displayed in the tab list. E.g. to display the players name there is `${viewer name}` and `${player name}`. The first one can be used everywhere, the second one in player slots and filters of player sets.

In addition to the built-in placeholders presented below you can use placeholders provided by PlaceholderAPI.
To learn how to use placeholder from PlaceholderAPI have a look at the [PlaceholderAPI](PlaceholderAPI) page.

[!]: ifBTLP
Please be aware of the following requirements and limitations about placeholders:

- Any placeholder from PlaceholderAPI require the `BungeeTabListPlus_BukkitBridge` plugin to be installed on your Spigot Servers.
- Some inbuilt placeholders require the `BungeeTabListPlus_BukkitBridge` plugin to be installed on your Spigot Servers.
- [Nucleus](#nucleus) placeholders require the `BungeeTabListPlus_SpongeBridge` plugin to be installed on your Sponge Servers.
- Any placeholder requiring a Bridge plugin also requires at least one player to be present on that server to function (BungeeCord limitation).
[!]: endIF

#### Generic player placeholders

| Viewer Variant                             | Player Variant                             | Example Output                         |
| ------------------------------------------ | ------------------------------------------ | -------------------------------------- |
| `${viewer display_name}`                   | `${player display_name}`                   | `§aCodeCrafter§b47`                    |
| `${viewer gamemode}`                       | `${player gamemode}`                       | `0`                                    |
| `${viewer health}`                         | `${player health}`                         | `20.0`                                 |
| `${viewer is_hidden}`                      | `${player is_hidden}`                      | `false`                                |
| `${viewer level}`                          | `${player level}`                          | `1`                                    |
| `${viewer location_x}`                     | `${player location_x}`                     | `0.0`                                  |
| `${viewer location_y}`                     | `${player location_y}`                     | `0.0`                                  |
| `${viewer location_z}`                     | `${player location_z}`                     | `0.0`                                  |
| `${viewer max_health}`                     | `${player max_health}`                     | `20.0`                                 |
| `${viewer name}`                           | `${player name}`                           | `CodeCrafter47`                        |
| `${viewer permission <permission>}`        | `${player permission <permission>}`        | `false`                                |
| `${viewer ping}`                           | `${player ping}`                           | `0`                                    |
| `${viewer tab_name}`                       | `${player tab_name}`                       | `CodeCrafter47`                        |
| `${viewer team}`                           | `${player team}`                           | `team`                                 |
| `${viewer team_color}`                     | `${player team_color}`                     | `§1`                                   |
| `${viewer team_display_name}`              | `${player team_display_name}`              | `§1Team`                               |
| `${viewer team_prefix}`                    | `${player team_prefix}`                    | `§1[Team]`                             |
| `${viewer team_suffix}`                    | `${player team_suffix}`                    | `§1[Team]`                             |
| `${viewer total_xp}`                       | `${player total_xp}`                       | `100`                                  |
| `${viewer uuid}`                           | `${player uuid}`                           | `d9935dff-9702-404b-9d44-8efd35b0928d` |
| `${viewer world}`                          | `${player world}`                          | `world`                                |
| `${viewer xp}`                             | `${player xp}`                             | `100`                                  |
[!]: ifBTLP
| `${viewer bungeecord_display_name}`        | `${player bungeecord_display_name}`        | `§aCodeCrafter47`                      |
| `${viewer bungeecord_primary_group}`       | `${player bungeecord_primary_group}`       | `owner`                                |
| `${viewer client_version}`                 | `${player client_version}`                 | `1.20.4`                               |
| `${viewer client_version_below_1_8}`       | `${player client_version_below_1_8}`       | `false`                                |
| `${viewer client_version_atleast_1_8}`     | `${player client_version_atleast_1_8}`     | `true`                                 |
| `${viewer server}`                         | `${player server}`                         | `lobby-1`                              |
| `${viewer session_duration_hours}`         | `${viewer session_duration_hours}`         | `1`                                    |
| `${viewer session_duration_minutes}`       | `${viewer session_duration_minutes}`       | `59`                                   |
| `${viewer session_duration_seconds}`       | `${viewer session_duration_seconds}`       | `59`                                   |
| `${viewer session_duration_total_seconds}` | `${viewer session_duration_total_seconds}` | `3600`                                 |
[!]: endIF

#### Essentials
[Spigot Page](https://www.spigotmc.org/resources/9089/)

| Viewer Variant             | Player Variant             | Example Output |
| -------------------------- | -------------------------- | -------------- |
| `${viewer essentials_afk}` | `${player essentials_afk}` | `true`         |

#### Factions

| Viewer Variant                          | Player Variant                          | Example Output |
| --------------------------------------- | --------------------------------------- | -------------- |
| `${viewer faction_at_current_location}` | `${player faction_at_current_location}` | `faction`      |
| `${viewer faction_member_count}`        | `${player faction_member_count}`        | `10`           |
| `${viewer faction_name}`                | `${player faction_name}`                | `faction`      |
| `${viewer faction_online_member_count}` | `${player faction_online_member_count}` | `10`           |
| `${viewer faction_player_power}`        | `${player faction_player_power}`        | `1`            |
| `${viewer faction_power}`               | `${player faction_power}`               | `1`            |
| `${viewer faction_rank}`                | `${player faction_rank}`                | `owner`        |

#### Multiverse
[Spigot Page](https://www.spigotmc.org/resources/390)

| Viewer Variant                     | Player Variant                     | Example Output |
| ---------------------------------- | ---------------------------------- | -------------- |
| `${viewer multiverse_world_alias}` | `${player multiverse_world_alias}` | `World`        |

#### PlayerPoints

| Viewer Variant            | Player Variant            | Example Output |
| ------------------------- | ------------------------- | -------------- |
| `${viewer player_points}` | `${player player_points}` | `10`           |

#### SimpleClans

| Viewer Variant                            | Player Variant                            | Example Output |
| ----------------------------------------- | ----------------------------------------- | -------------- |
| `${viewer SimpleClans_ClanName}`          | `${player SimpleClans_ClanName}`          | `clan`         |
| `${viewer SimpleClans_ClanMembers}`       | `${player SimpleClans_ClanMembers}`       | `10`           |
| `${viewer SimpleClans_ClanTag}`           | `${player SimpleClans_ClanTag}`           | `clan`         |
| `${viewer SimpleClans_ClanTagLabel}`      | `${player SimpleClans_ClanTagLabel}`      | `§aclan`       |
| `${viewer SimpleClans_ClanColorTag}`      | `${player SimpleClans_ClanColorTag}`      | `§a`           |
| `${viewer SimpleClans_OnlineClanMembers}` | `${player SimpleClans_OnlineClanMembers}` | `10`           |

#### Vault
[Spigot Page](https://www.spigotmc.org/resources/34315)

| Viewer Variant                         | Player Variant                         | Example Output |
| -------------------------------------- | -------------------------------------- | -------------- |
| `${viewer vault_balance}`              | `${player vault_balance}`              | `100.0`        |
| `${viewer vault_balance2}`             | `${player vault_balance2}`             | `100.0`        |
| `${viewer vault_currency}`             | `${player vault_currency}`             | `dollar`       |
| `${viewer vault_currency_plural}`      | `${player vault_currency_plural}`      | `dollars`      |
| `${viewer vault_primary_group}`        | `${player vault_primary_group}`        | `owner`        |
| `${viewer vault_primary_group_weight}` | `${player vault_primary_group_weight}` | `100`          |
| `${viewer vault_player_prefix}`        | `${player vault_player_prefix}`        | `§a[Player]`   |
| `${viewer vault_prefix}`               | `${player vault_prefix}`               | `§c[Owner]`    |
| `${viewer vault_primary_group_prefix}` | `${player vault_primary_group_prefix}` | `§c[Owner]`    |
| `${viewer vault_suffix}`               | `${player vault_suffix}`               | `§a[Player]`   |

#### ASkyBlock
[Spigot Page](https://www.spigotmc.org/resources/1220)

| Viewer Variant                     | Player Variant                     | Example Output  |
| ---------------------------------- | ---------------------------------- | --------------- |
| `${viewer askyblock_island_level}` | `${player askyblock_island_level}` | `10`            |
| `${viewer askyblock_island_name}`  | `${player askyblock_island_name}`  | `island`        |
| `${viewer askyblock_team_leader}`  | `${player askyblock_team_leader}`  | `CodeCrafter47` |

#### PartyAndFriends Clans

| Viewer Variant                                 | Player Variant                                 | Example Output |
| ---------------------------------------------- | ---------------------------------------------- | -------------- |
| `${viewer paf_clans_clan_name}`                | `${player paf_clans_clan_name}`                | `clan`         |
| `${viewer paf_clans_clan_tag}`                 | `${player paf_clans_clan_tag}`                 | `§aClan`       |
| `${viewer paf_clans_clan_member_count}`        | `${player paf_clans_clan_member_count}`        | `10`           |
| `${viewer paf_clans_clan_online_member_count}` | `${player paf_clans_clan_online_member_count}` | `5`            |
| `${viewer paf_clans_is_leader}`                | `${player paf_clans_is_leader}`                | `true`         |

[!]: ifBTLP
#### LuckPerms
[Spigot Page](https://www.spigotmc.org/resources/28140)

| Viewer Variant                                   | Player Variant                                   | Example Output |
| ------------------------------------------------ | ------------------------------------------------ | -------------- |
| `${viewer luckpermsbungee_prefix}`               | `${player luckpermsbungee_prefix}`               | `§c[Owner]`    |
| `${viewer luckpermsbungee_suffix}`               | `${player luckpermsbungee_suffix}`               | `§a[Player]`   |
| `${viewer luckpermsbungee_primary_group}`        | `${player luckpermsbungee_primary_group}`        | `§c[Owner]`    |
| `${viewer luckpermsbungee_primary_group_weight}` | `${player luckpermsbungee_primary_group_weight}` | `§a[Player]`   |

#### BungeePerms
[Spigot Page](https://www.spigotmc.org/resources/25)

| Viewer Variant                               | Player Variant                               | Example Output    |
| -------------------------------------------- | -------------------------------------------- | ----------------- |
| `${viewer bungeeperms_display}`              | `${player bungeeperms_display}`              | `§aCodeCrafter47` |
| `${viewer bungeeperms_prefix}`               | `${player bungeeperms_prefix}`               | `§c[Owner]`       |
| `${viewer bungeeperms_primary_group}`        | `${player bungeeperms_primary_group}`        | `owner`           |
| `${viewer bungeeperms_primary_group_weight}` | `${player bungeeperms_primary_group_weight}` | `100`             |
| `${viewer bungeeperms_primary_group_rank}`   | `${player bungeeperms_primary_group_rank}`   | `owner`           |
| `${viewer bungeeperms_primary_group_prefix}` | `${player bungeeperms_primary_group_prefix}` | `§c[Owner]`       |
| `${viewer bungeeperms_suffix}`               | `${player bungeeperms_suffix}`               | `§a[Player]`      |
| `${viewer bungeeperms_user_prefix}`          | `${player bungeeperms_user_prefix}`          | `§a[Player]`      |

#### BungeeOnlineTime
[Spigot Page](https://www.spigotmc.org/resources/795)

| Viewer Variant                           | Player Variant                           | Example Output |
| ---------------------------------------- | ---------------------------------------- | -------------- |
| `${viewer bungeeonlinetime_days}`        | `${player bungeeonlinetime_days}`        | `10`           |
| `${viewer bungeeonlinetime_hours_of_24}` | `${player bungeeonlinetime_hours_of_24}` | `10`           |
| `${viewer bungeeonlinetime_hours}`       | `${player bungeeonlinetime_hours}`       | `23`           |
| `${viewer bungeeonlinetime_minutes}`     | `${player bungeeonlinetime_minutes}`     | `59`           |
| `${viewer bungeeonlinetime_seconds}`     | `${player bungeeonlinetime_seconds}`     | `59`           |

#### RedisBungee
[Spigot Page](https://www.spigotmc.org/resources/13494)

| Viewer Variant                    | Player Variant                    | Example Output |
| --------------------------------- | --------------------------------- | -------------- |
| `${viewer redisbungee_server_id}` | `${player redisbungee_server_id}` | `server`       |

#### Nucleus
[Sponge Page](https://ore.spongepowered.org/Nucleus/Nucleus/pages/Home)

| Viewer Variant           | Player Variant           | Example Output  |
| ------------------------ | ------------------------ | --------------- |
| `${viewer nucleus_afk}`  | `${player nucleus_afk}`  | `false`         |
| `${viewer nucleus_nick}` | `${player nucleus_nick}` | `§aCodeCrafter` |


### Server bound placeholders

#### TPS
   
`${server:<server name> tps}` Resolves the placeholder for a specific server. Example: `${server:factions tps}`
   
`${viewer server tps}` Tps of the server the player viewing the tab list is connected to.
Analogue there is `${player server tps}`.

`${server tps}` for use in the `serverHeader` of the _players by server_ component.
 
#### Online state
 
`${server:<server name> online}` checks whether a specific server is online. Player and viewer variants exist too but
I don't think they are very useful. 

The `${server online}` for use in the `serverHeader` of the _players by server_ component is available too.

The placeholder either evaluates to `true` or `false` so directly using it may not be what you want. Instead you probably
want to use it as condition in the _conditional component_.

[!]: endIF

### Special placeholders

 * #### `${time <format>}`
 
   Displays the current time. Example: `${time HH:mm:ss}`. You can find more information about the date format at https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html.
   
   _Examples:_
   
   | Pattern              | Result       |
   | -------------------- | ------------ |
   | `${time HH:mm:ss}`   | `20:51:03`   |
   | `${time h:mm a}`     | `8:51 PM`    |
   | `${time dd.MM.yyyy}` | `11.09.2020` |
 
 * #### `${other_count}`
  
   This placeholder is for use in the `morePlayersComponent` option of all components that add players to the tab list.
 
 * #### `${playerset:<name> size}`
  
   Displays number of players in a player set. See [Player sets](Player-Sets).
 
 * #### `${viewer skin}`
 
   Can be used as the `icon` property of a slot to display the skin of the player looking at the tab list.

[!]: ifBTLP
   
 * #### `${server_player_count}`
 
   For use in the `serverHeader` of the _players by server_ component.

 * #### `${server_count total}`
  
   Displays the total number of servers in the BungeeCord network.
   
 * #### `${server_count online}`
 
   Displays the number of servers which are up and running.

[!]: endIF

#### Text Transformations

These placeholders change arbitrary text to use a specific type set or colors.

| Placeholder             | Image                                      |
| ----------------------- | ------------------------------------------ |
| `${uppercase <text>}`   | ![](images/text-transform-uppercase.png)   |
| `${lowercase <text>}`   | ![](images/text-transform-lowercase.png)   |
| `${small_caps <text>}`  | ![](images/text-transform-smallcaps.png)   |
| `${superscript <text>}` | ![](images/text-transform-superscript.png) |
| `${bubbles <text>}`     | ![](images/text-transform-bubbles.png)     |
| `${rainbow <text>}`     | ![](images/text-transform-rainbow.png)     |

_Example:_ You can display the name of the player looking at the tab list (viewer) in rainbow colors using `${rainbow ${viewer name}}`.
