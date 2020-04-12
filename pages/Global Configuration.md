[!]: ifATO

These don't exist yet.

[!]: endIF
[!]: ifBTLP

Some global options can be configured in config.yml. Here's a list of all options with detailed description:
  
* ##### `checkForUpdates: true`

  If enabled BungeeTabListPlus will automatically check whether an update is available. You can see whether an update is available by typing `/btlp`. You have to download and install the update yourself.
  
* ##### `notifyAdminsIfUpdateAvailable: true`

  If this is enabled and the above is enabled, admins will get chat messages telling them that a new version of BungeeTabListPlus is available for download.

* ##### `pingDelay: -1`
  This is only relevant for the {onlineState} variable which shows whether a server of your network is currently online or offline. To know whether a server is online or offline the plugin needs to periodically ping all your servers. You can choose the interval (in seconds) it does so here. To disable the feature set `pingDelay` to -1.
  
* ##### `disableCustomTabListForSpectators: true`

   Disables the custom tab list for players in spectators mode.
   As a result those players will see the vanilla tab list of the server.
   If you do not use this option players in spectator mode will see the fake players created by BungeeTabListPlus in the teleport menu.

* ##### `fakePlayers`
  
  ```
  fakePlayers:
  - Herobrine
  - Notch
  ```
  In this part of the config you can define a list of "fake" players. They will randomly appear on the tab list. Per default this is an empty list and you should't change it.

  To disable fake players set it to the following(default):
  ```
    fakePlayers: []
    ```

* ##### `excludeServers`
  
  ```
  excludeServers:
  - server2
  - server7
  ```
  You can list some servers here which you want to use their own (the Bukkit side) tablist. I recommend not to list any of your servers here if you don't know what you are doing. All players which are on one of the servers listed here will not see the tab list provided by this plugin and will instead see the local tablist of the server they are on.

* ##### `hiddenServers`
  
  ```
  hiddenServers:
  - server3
  - server9
  ```
  Servers which you wish to hide from the global tab list.

  Note that this is different from excludeServers above. This hides all players on the hidden servers from appearing on the tablist, whereas excluded servers' players are still on the BungeeTabListPlus tablist, but they do not see the global tab list

* ##### `hiddenPlayers`
  
  ```
  hiddenPlayers:
  - CodeCrafter47
  - d9935dff-9702-404b-9d44-8efd35b0928d
  ```
  Players which you which to be permanently hidden from the tab list. You can also use uuids here. Note that players with the `bungeetablistplus.seevanished` permission will still see these hidden players in their tab list.

* ##### `time-zone: Europe/Berlin`
  This is the time zone to use for the {time} variable. It can be full name like `America/Los_Angeles` or a custom id like `GMT+8`.

* ##### `customPlaceholders`
  
  ```yaml
  customPlaceholders:
    ...
  ```
  See [Custom Placeholders](CustomPlaceholders).
  
[!]: endIF