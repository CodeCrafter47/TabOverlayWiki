### Content
[!]: ToC

### Player bound placeholders

Each player related placeholder comes in two versions: One for the player viewing the tab list on one for a player displayed in the tab list. E.g. to display the players name there is `${viewer name}` and `${player name}`. The first one can be used everywhere, the second one in player slots and filters of player sets.

In addition to the built-in placeholders presented below you can use placeholders provided by PlaceholderAPI.
To learn how to use placeholder from PlaceholderAPI have a look at the [PlaceholderAPI](PlaceholderAPI) page.

[!]: ifBTLP
Note that some of the placeholders below may need the BungeeTabListPlus_BukkitBridge plugin to be installed on your Spigot Servers.  
Those placeholders also may only be able to provide values while a player is online on that specific server.
[!]: endIF

#### Generic player placeholders
| Viewer Variant                             | Player Variant                             |
| ------------------------------------------ | ------------------------------------------ |
| `${viewer display_name}`                   | `${player display_name}`                   |
| `${viewer gamemode}`                       | `${player gamemode}`                       |
| `${viewer health}`                         | `${player health}`                         |
| `${viewer is_hidden}`                      | `${player is_hidden}`                      |
| `${viewer level}`                          | `${player level}`                          |
| `${viewer location_x}`                     | `${player location_x}`                     |
| `${viewer location_y}`                     | `${player location_y}`                     |
| `${viewer location_z}`                     | `${player location_z}`                     |
| `${viewer max_health}`                     | `${player max_health}`                     |
| `${viewer name}`                           | `${player name}`                           |
| `${viewer permission <permission>}`        | `${player permission <permission>}`        |
| `${viewer ping}`                           | `${player ping}`                           |
| `${viewer tab_name}`                       | `${player tab_name}`                       |
| `${viewer team}`                           | `${player team}`                           |
| `${viewer total_xp}`                       | `${player total_xp}`                       |
| `${viewer uuid}`                           | `${player uuid}`                           |
| `${viewer world}`                          | `${player world}`                          |
| `${viewer xp}`                             | `${player xp}`                             |
[!]: ifBTLP
| `${viewer bungeecord_display_name}`        | `${player bungeecord_display_name}`        |
| `${viewer bungeecord_primary_group}`       | `${player bungeecord_primary_group}`       |
| `${viewer client_version}`                 | `${player client_version}`                 |
| `${viewer client_version_below_1_8}`       | `${player client_version_below_1_8}`       |
| `${viewer client_version_atleast_1_8}`     | `${player client_version_atleast_1_8}`     |
| `${viewer server}`                         | `${player server}`                         |
| `${viewer session_duration_hours}`         | `${viewer session_duration_hours}`         |
| `${viewer session_duration_minutes}`       | `${viewer session_duration_minutes}`       |
| `${viewer session_duration_seconds}`       | `${viewer session_duration_seconds}`       |
| `${viewer session_duration_total_seconds}` | `${viewer session_duration_total_seconds}` |
[!]: endIF

#### Essentials
| Viewer Variant             | Player Variant             |
| -------------------------- | -------------------------- |
| `${viewer essentials_afk}` | `${player essentials_afk}` |

#### Factions
| Viewer Variant                          | Player Variant                          |
| --------------------------------------- | --------------------------------------- |
| `${viewer faction_at_current_location}` | `${player faction_at_current_location}` |
| `${viewer faction_member_count}`        | `${player faction_member_count}`        |
| `${viewer faction_name}`                | `${player faction_name}`                |
| `${viewer faction_online_member_count}` | `${player faction_online_member_count}` |
| `${viewer faction_player_power}`        | `${player faction_player_power}`        |
| `${viewer faction_power}`               | `${player faction_power}`               |
| `${viewer faction_rank}`                | `${player faction_rank}`                |

#### Multiverse
| Viewer Variant                     | Player Variant                     |
| ---------------------------------- | ---------------------------------- |
| `${viewer multiverse_world_alias}` | `${player multiverse_world_alias}` |

#### PlayerPoints
| Viewer Variant            | Player Variant            |
| ------------------------- | ------------------------- |
| `${viewer player_points}` | `${player player_points}` |

#### SimpleClans
| Viewer Variant                            | Player Variant                            |
| ----------------------------------------- | ----------------------------------------- |
| `${viewer SimpleClans_ClanName}`          | `${player SimpleClans_ClanName}`          |
| `${viewer SimpleClans_ClanMembers}`       | `${player SimpleClans_ClanMembers}`       |
| `${viewer SimpleClans_ClanTag}`           | `${player SimpleClans_ClanTag}`           |
| `${viewer SimpleClans_ClanTagLabel}`      | `${player SimpleClans_ClanTagLabel}`      |
| `${viewer SimpleClans_ClanColorTag}`      | `${player SimpleClans_ClanColorTag}`      |
| `${viewer SimpleClans_OnlineClanMembers}` | `${player SimpleClans_OnlineClanMembers}` |

#### Vault
| Viewer Variant                         | Player Variant                         |
| -------------------------------------- | -------------------------------------- |
| `${viewer vault_balance}`              | `${player vault_balance}`              |
| `${viewer vault_balance2}`             | `${player vault_balance2}`             |
| `${viewer vault_currency}`             | `${player vault_currency}`             |
| `${viewer vault_currency_plural}`      | `${player vault_currency_plural}`      |
| `${viewer vault_primary_group}`        | `${player vault_primary_group}`        |
| `${viewer vault_primary_group_weight}` | `${player vault_primary_group_weight}` |
| `${viewer vault_player_prefix}`        | `${player vault_player_prefix}`        |
| `${viewer vault_prefix}`               | `${player vault_prefix}`               |
| `${viewer vault_primary_group_prefix}` | `${player vault_primary_group_prefix}` |
| `${viewer vault_suffix}`               | `${player vault_suffix}`               |

#### ASkyBlock
| Viewer Variant                     | Player Variant                     |
| ---------------------------------- | ---------------------------------- |
| `${viewer askyblock_island_level}` | `${player askyblock_island_level}` |
| `${viewer askyblock_island_name}`  | `${player askyblock_island_name}`  |
| `${viewer askyblock_team_leader}`  | `${player askyblock_team_leader}`  |

#### PartyAndFriends Clans
| Viewer Variant                                 | Player Variant                                 |
| ---------------------------------------------- | ---------------------------------------------- |
| `${viewer paf_clans_clan_name}`                | `${player paf_clans_clan_name}`                |
| `${viewer paf_clans_clan_tag}`                 | `${player paf_clans_clan_tag}`                 |
| `${viewer paf_clans_clan_member_count}`        | `${player paf_clans_clan_member_count}`        |
| `${viewer paf_clans_clan_online_member_count}` | `${player paf_clans_clan_online_member_count}` |
| `${viewer paf_clans_is_leader}`                | `${player paf_clans_is_leader}`                |

[!]: ifBTLP
#### LuckPerms
| Viewer Variant                                   | Player Variant                                   |
| ------------------------------------------------ | ------------------------------------------------ |
| `${viewer luckpermsbungee_prefix}`               | `${player luckpermsbungee_prefix}`               |
| `${viewer luckpermsbungee_suffix}`               | `${player luckpermsbungee_suffix}`               |
| `${viewer luckpermsbungee_primary_group}`        | `${player luckpermsbungee_primary_group}`        |
| `${viewer luckpermsbungee_primary_group_weight}` | `${player luckpermsbungee_primary_group_weight}` |

#### BungeePerms
| Viewer Variant                               | Player Variant                               |
| -------------------------------------------- | --------------------                         |
| `${viewer bungeeperms_display}`              | `${player bungeeperms_display}`              |
| `${viewer bungeeperms_prefix}`               | `${player bungeeperms_prefix}`               |
| `${viewer bungeeperms_primary_group}`        | `${player bungeeperms_primary_group}`        |
| `${viewer bungeeperms_primary_group_weight}` | `${player bungeeperms_primary_group_weight}` |
| `${viewer bungeeperms_primary_group_rank}`   | `${player bungeeperms_primary_group_rank}`   |
| `${viewer bungeeperms_primary_group_prefix}` | `${player bungeeperms_primary_group_prefix}` |
| `${viewer bungeeperms_suffix}`               | `${player bungeeperms_suffix}`               |
| `${viewer bungeeperms_user_prefix}`          | `${player bungeeperms_user_prefix}`          |

#### BungeeOnlineTime
| Viewer Variant | Player Variant
| ---------------------------------------- | ---------------------------------------- |
| `${viewer bungeeonlinetime_days}`        | `${player bungeeonlinetime_days}`        |
| `${viewer bungeeonlinetime_hours_of_24}` | `${player bungeeonlinetime_hours_of_24}` |
| `${viewer bungeeonlinetime_hours}`       | `${player bungeeonlinetime_hours}`       |
| `${viewer bungeeonlinetime_minutes}`     | `${player bungeeonlinetime_minutes}`     |
| `${viewer bungeeonlinetime_seconds}`     | `${player bungeeonlinetime_seconds}`     |

#### RedisBungee
| Viewer Variant                    | Player Variant                    |
| --------------------------------- | --------------------------------- |
| `${viewer redisbungee_server_id}` | `${player redisbungee_server_id}` |

#### Nucleus
| Viewer Variant           | Player Variant           |
| ------------------------ | ------------------------ |
| `${viewer nucleus_afk}`  | `${player nucleus_afk}`  |
| `${viewer nucleus_nick}` | `${player nucleus_nick}` |


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
 
   Displays the current time. Example: `${time HH:mm:ss}`. You can find more information about the date format at <https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html>.
   
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
