
#### The icons next to the player name in the tab list are not showing up

Your server needs to meet the following requirements for the icons to show up:
 * You need to run Minecraft 1.8 or above.
 * Your server cannot run in offline mode (see [#269](https://github.com/CodeCrafter47/BungeeTabListPlus/issues/269)).

[!]: ifBTLP

#### How to set, that only players on a local server can be seen?

1. Create a player set containing only those players:
    ```yaml
    playerSets:
      same_server: ${player server} = ${viewer server}
    ```
   
2. Change the `playerSet` option such that the plugin uses the `same_server` player set when displaying players
    ```yaml
    playerSet: same_server
    ```
   
[!]: endIF