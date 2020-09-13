Using [PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/) you can get access to a huge amount of additional placeholders.

[!]: ifBTLP

### Requirements
1. You need to install [PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/) on your spigot servers.
2. You need to install BungeeTabListPlus_BukkitBridge on your spigot servers.

[!]: endIF

### Usage
Here is how to use a placeholder from PlaceholderAPI:

1. Pick a Placeholder from <https://github.com/PlaceholderAPI/PlaceholderAPI/wiki/Placeholders>. We use `%statistic_kill_entity_CREEPER%` as an example.
2. Download the required PlaceholderAPI Expansion using the `/papi ecloud download` command. You might skip this step if the required expansion is already installed. For our example we need the Statistic expansion: `/papi ecloud download Statistic`. After downloading an expansion type `/papi reload` to activate it.
3. Test whether PlaceholderAPI is working correctly using the `/papi parse ...` command. In our example we type `/papi parse me %statistic_kill_entity_CREEPER%`. If it doesn't replace the placeholder correctly return to step 2.
4. Use the Placeholder in your tab list configuration file: The `%statistic_kill_entity_CREEPER%` will not work in the config. Instead, you have to use `${viewer statistic_kill_entity_CREEPER}` to resolve the placeholder for the player looking at the tab list or `${player statistic_kill_entity_CREEPER}` to resolve the placeholder for a player listed in the tab list.

   _Example:_
   ```yaml
   components:
   - {text: "&6Creepers killed: &c${viewer statistic_kill_entity_CREEPER}", icon: "colors/gold.png", ping: 0}
   ```