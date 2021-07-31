### Content
[!]: ToC

### The icons next to the player name in the tab list are not showing up

Your server needs to meet the following requirements for the icons to show up:
 * You need to run Minecraft 1.8 or above.
 * Your server cannot run in offline mode (see [#269](https://github.com/CodeCrafter47/BungeeTabListPlus/issues/269)).

### Players in spectator mode cannot see the custom tab list

This is intentional.
You can use the `disableCustomTabListForSpectators` option in `config.yml` to change that.
However, displaying the custom tab list to players in spectator mode causes some issues, such as fake players used for custom slots showing up in the teleport menu and other spectators being rendered differently.

[!]: ifBTLP

### I get `Size 80 defined in default.yml is not supported by client.`

For 1.7.x clients (and older) the size of the tab list configured in tab list configuration (`default.yml`) must match the size of the tab list configured in BungeeCord's `config.yml`.

### How to create a separate tab list configuration for 1.7.x players

The following steps allow you to create a separate tab list configuration for players with 1.7.x or even older clients.

1. Create a new file in the `tabLists` folder. A copy of the `default.yml` or one of the examples from the wiki make a good starting point. While the name doesn't really matter, let's assume you called the file `1.7.yml`.

2. Change the `showTo` option of the `1.7.yml` to
   ```yaml
   showTo: |-
     ${viewer client_version_below_1_8}
   ```
   Note that a 1.7.x client identifies as either 1.7.5 or 1.7.10, so it is sufficient to check for those two versions.

3. Change the `priority` option in the `1.7.yml` to a number higher than the one in `default.yml`.

4. Edit the remaining options in `1.7.yml` to change the layout to fit your needs. Pay attention to the following details specific to 1.7 clients:
   * The `size` must match the tab list size configured in BungeeCord's `config.yml`.
   * There is no header or footer. You can ignore or remove those config options.
   * There are no icons :(

### How to set, that only players on a local server can be seen?

1. Create a player set containing only those players:
    ```yaml
    playerSets:
      same_server: ${player server} = ${viewer server}
    ```
   
2. Change the `playerSet` option such that the plugin uses the `same_server` player set when displaying players
    ```yaml
    playerSet: same_server
    ```

### Can I use this plugin on Bukkit, i.e. without BungeeCord?

Have a look at AdvancedTabOverlay for a Bukkit port of the plugin.
* <https://www.spigotmc.org/resources/advancedtaboverlay.78905/>

[!]: endIF

### Random player icons show up in the bottom right/top left of the tab list

This bug only appears when specific conditions are met:

* Your Tab list doesn't use all 80 available slots.
* You don't use a playerSet that displays all players from at least the viewer's server.

This is a limitation of MC and the only fix for it is to either use a `FIXED_SIZE` tab list with `size: 80` or a playerSet that displays all the players from the same server as the viewer.

[!]: ifBTLP

See [this question](#how-to-set-that-only-players-on-a-local-server-can-be-seen) for how to make such a playerSet.

[!]: endIF
