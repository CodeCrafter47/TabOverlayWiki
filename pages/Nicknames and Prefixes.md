This page explains how to configure your tab list such that nicknames and prefixes show up.
There are several options to choose from:
* Use the `display_name` or `tab_name` to display the name is likely make nicknames and prefixes appear with the least effort. However, it largely depends on the configuration of your other Bukkit plugins.
* Use a plugin specific placeholder to display the nickname, such as `essentials_nickname`.
* Display the prefix from your permission plugin using the `vault_prefix` placeholder or a placeholder specific to your permission plugin.
* Create a set of custom prefixes specific to the tab list.

The `playerComponent` option controls the appearance of player names on the tab list.
You can find that option in the `DYNAMIC_SIZE` tab list as well as in all the components used to display players when using the `FIXED_SIZE` tab list.

The following is a very basic way to set the `playerComponent` option:
```yaml
playerComponent: "${player name}"
```

### Using `display_name` or `tab_name`

This is a simple as replacing `${player name}` with `${player display_name}` or `${player tab_name}`.
The `display_name` corresponds to Bukkits `getDisplayName()` and `tab_name` corresponds to `getPlayerListName()`.
These are often set by other plugins.

The `${player display_name}` is what is used in the chat.
You should give that a try first.
However, it sometimes includes long prefixes which are not suitable for the tab list.
In that case you can try `${player tab_name}`.

If `${player tab_name}` does not show the nickname, check the configuration of your nickname plugin.
E.g. Essentials has an option `change-playerlist` which needs to be enabled.

[!]: ifBTLP
There is also `${player bungeecord_display_name}` which can be set by BungeeCord plugins.
However, there are few plugins using this, so unless you have a nickname plugin installed on BungeeCord, chances are this will not work.
[!]: endIF

### Using a Plugin Specific Nickname Placeholder

You can use a plugin specific placeholder such as `${player essentials_nickname}` to display the nick name.

However, the problem with `${player essentials_nickname}` (and most other plugin specific nickname placeholders) is that it will display nothing if a player does not have a nickname.
That means it is not suitable as a direct replacement for the `${player name}` placeholder.
We can fix that issue by creating a custom placeholder that displays the nickname if it exists and the normal player name otherwise:
```yaml
customPlaceholders:
  # ...
  player_name_or_nickname:
    !conditional
    condition: ${player essentials_nickname} != ""
    true: ${player essentials_nickname}
    false: ${player name}
```
Then we can replace `${player name}` with `${player_name_or_nickname}`.

[!]: ifATO
**Note:** The `${player essentials_nickname}` placeholder used in this example is a PlaceholderAPI placeholder.
That means you need to install PlaceholderAPI and the Essentials expansion for it to work.

[!]: endIF
[!]: ifBTLP
**Note:** The `${player essentials_nickname}` placeholder used in this example is a PlaceholderAPI placeholder.
That means you need to install BungeeTabListPlus_BukkitBridge, PlaceholderAPI and the Essentials expansion on your Bukkit/ Spigot servers for it to work.

[!]: endIF

_Additional Information:_
* [Custom Placeholders](Custom-Placeholders)
* [Using PlaceholderAPI Placeholders](PlaceholderAPI)

### Displaying the Prefix from a Permission Plugin

To display the prefix from your permission plugin add the `${player vault_prefix}` placeholder before the `${player name}` in the `playerComponent` option.
You will end up with something similar to the following:
```yaml
playerComponent: "${player vault_prefix}${player name}"
```

[!]: ifATO
**Note:** 
You need to install Vault for the `${player vault_prefix}` placeholder to work.

[!]: endIF
[!]: ifBTLP
**Note:**
You need to install BungeeTabListPlus_BukkitBridge and Vault on your Bukkit/ Spigot servers for the `${player vault_prefix}` placeholder to work.

[!]: endIF

As an alternative to `${player vault_prefix}` you can use a prefix placeholder specific to your permission plugin such as `${player luckperms_prefix}`.
However, we recommend using the Vault placeholder unless you have specific reasons for using a different one.

### Creating Custom Prefixes for the Tab List

To create custom prefixes we use a custom placeholder.

```yaml
customPlaceholders:
  # ...
  custom_prefix:
    !switch
    parameters: 1
    expression: ${%0 vault_primary_group}
    replacements:
      "admin": "&c[A]&f"
      "mod": "&b[M]&f"
      "vip": "&b[V]&f"
    defaultReplacement: "&7"
```

You can edit everything after `replacements:` to suit your needs.
The lines immediately following after `replacements:` map a prefix to each group.
On the left you write the group name, on the right the prefix.
The `defaultReplacement` option is used to configure the prefix of players which do not have a prefix assigned using the `replacements` option.

To display the prefix add the `${custom_prefix player}` placeholder before the `${player name}` in the `playerComponent` option.
You will end up with something similar to the following:
```yaml
playerComponent: "${custom_prefix player}${player name}"
```

As a bonus this also create a `${custom_prefix viewer}` placeholder that can be used anywhere in the tab list to display the prefix of the player looking at the tab list.

[!]: ifATO
**Note:** 
We used the `vault_primary_group` placeholder which requires Vault.

[!]: endIF
[!]: ifBTLP
**Note:**
We used the `vault_primary_group` placeholder which requires BungeeTabListPlus_BukkitBridge and Vault to be installed on all Bukkit/ Spigot servers.

[!]: endIF

As an alternative to `vault_primary_group` you can use a placeholder specific to your permission plugin such as `luckperms_primary_group`.
However, we recommend using the Vault placeholder unless you have specific reasons for using a different one.

_Additional Information:_
* [Custom Placeholders](Custom-Placeholders)