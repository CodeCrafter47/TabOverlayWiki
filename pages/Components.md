The following components are available:

1. **Basic Component**

   ```yaml
   {text: "...", icon: "image.png", ping: 0}
   ```

   The basic component represents the content of one slot in the tab list. The `icon` option can be set to either a 
    player name, a player uuid or the name of an image file located in the `BungeeTabListPlus/heads` folder.
   
   The basic component also has an option for text alignment which can be set to `LEFT`, `CENTER` or `RIGHT`:

   ```yaml
   {text: "Centered text", icon: "image.png", ping: 0, alignment: CENTER}
   ```
   
   Or to do right bound text:
   
   ```yaml
   {text: "At the right", icon: "image.png", ping: 0, alignment: RIGHT}
   ```
   
   Another option is the `longText` option. It allows specifying what happens if the text is too long to fit the slot. It can be set to `DISPLAY_ALL`, `CROP`, `CROP_2DOTS` or `CROP_3DOTS`. The default is `DISPLAY_ALL` which will display the text anyway. The other options cut off part of the text to make it fit an will eventually append 2 or 3 dots depending on which option you chose. Here's an example:
   ```yaml
   {text: "${player vault_prefix}${player name}", longText: CROP_2DOTS}
   ```
   
2. **Animated Component**

   ```yaml
   !animated
   components: <List of Compopnents>
   interval: <Number>
   ```
   Example:
   ```yaml
   !animated
   components:
     - {text: "&7Hello &a${player name}", icon: "${player skin}", ping: 0}
     - {text: "&7Hello &b${player name}", icon: "${player skin}", ping: 0}
     - {text: "&7Hello &c${player name}", icon: "${player skin}", ping: 0}
     - {text: "&7Hello &d${player name}", icon: "${player skin}", ping: 0}
   interval: 0.4
   ```
   
   This component makes it possible to create animated slots.

   | Option | Description |
   | ------ | ----------- |
   | `components` | These components will be cycled through. |
   | `interval` | Interval in seconds at which to switch the active Component. |

3. **Conditional Component**

   ```yaml
   !conditional
   condition: <Expression>
   true: <Replacement if the condition evaluates to true>
   false: <Replacement if the condition evaluates to false>
   ```
   
   Example:
   
   ```yaml
   !conditional
   condition: |-
     ${server:survival online} == true
   true: {text: "&bSurvival: &aONLINE", icon: "colors/green.png", ping: 0}
   false: {text: "&bSurvival: &cOFFLINE", icon: "colors/red.png", ping: 0}
   ```
   
   This component can dynamically change the content of the tab list. The example shows how this could replace the {onlineState} variable.

   | Option | Description |
   | ------ | ----------- |
   | `condition` | The expression to be evaluated. |
   | `true` | Replacement if the condition evaluates to true. |
   | `false` | Replacement if the condition evaluates to false. |
   
   Additional info: [Expression Syntax](Expressions)

4. **Players Component**

   ```yaml
   !players
   playerSet: <String>
   playerOrder: <String>
   playerComponent: <Component or list of components>
   morePlayersComponent: <Component or list of components>
   fillSlotsVertical: <true/false>
   minSize: <Number>
   maxSize: <Number>
   ```
   
   Example:
   
   ```yaml
   !players
   playerSet: global
   playerOrder: "vaultGroupInfo,alphabetically"
   playerComponent: {text: "${player name}", icon: "${player skin}", ping: "${player ping}"}
   morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
   minSize: 0
   maxSize: 6
   ```
   
   This component provides a simple way of adding players to the tab list.

   | Option | Description |
   | ------ | ----------- |
   | `playerSet` | Selects which players will be added to the tab list. |
   | `playerOrder` | Determines the order of the players in the tab list. [More info](PlayerOrder)
   | `playerComponent` | Determines how a player will be presented in the tab list. Usually you will want to set this to `{text: "${player name}", icon: "${player skin}", ping: "${player ping}"}`, eventually adding a prefix. This can be set to a list of basic components to use more than one slot per player. |
   | `morePlayersComponent` | This will be shown if there are more players than there is space in the tab list (or more players than `max-size`) |
   | `fillSlotsVertical` | Optional: If set to true the tab list slots are filled top-to-bottom first instead of left-to-right. |
   | `minSize` | Optional: Minimum slots this component should use |
   | `maxSize` | Optional: Maximum slots this component should use |

5. **Players by Server Component**

   ```yaml
   !players_by_server
   playerSet: <String>
   playerOrder: <String>
   serverOrder: <String>
   customServerOrder: <List of servers>
   serverHeader: <List of Components>
   serverFooter: <List of Components>
   serverSeparator: <List of Components>
   includeEmptyServers: <Boolean>
   showServers: <ALL, ONLINE, NON_EMPTY>
   hiddenServers: <List of servers>
   playerComponent: <Component or list of components>
   morePlayersComponent: <Component or list of components>
   fillSlotsVertical: <true/false>
   minSizePerServer: <Number>
   maxSizePerServer: <Number>
   minSize: <Number>
   maxSize: <Number>
   ```
   
   Example:
   
   ```yaml
   !players_by_server
   playerSet: global
   playerOrder: "vaultGroupInfo,alphabetically"
   serverOrder: "playercount,alphabetically"
   serverHeader:
   - {text: "&e&n${server}&f&o (${server_player_count}):", icon: "colors/yellow.png", ping: 0}
   showServers: NON_EMPTY
   playerComponent: {text: "${player name}", icon: "${player skin}", ping: "${player ping}"}
   morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
   ```
   
   This component adds players to the tab list grouping them by server as seen in the default config.

   | Option | Description |
   | ------ | ----------- |
   | `playerSet` | Selects which players will be added to the tab list. |
   | `playerOrder` | Determines the order of the players in the tab list. [More info](PlayerOrder)
   | `serverOrder` | Determines the order of the servers. Available options are `alphabetically`, `playercount`, `online` and `custom`. These can be chained by separating the with a comma, just the way it works with _playerOrder_.
   | `customServerOrder` | Specifies the server order if you used custom for the `serverOrder` option. An example code snippet is given below. |
   | `serverHeader` | The server header will appear once for each server above the players playing on that server. |
   | `serverFooter` | Optional: The server footer will appear once for each server below the players playing on that server. |
   | `serverSeparator` | Optional: The server separator will appear between each two servers. |
   | `includeEmptyServers` | Whether empty servers will show up too. **This option has been superseeded by `showServers`** |
   | `showServers` | Which servers to display on the tab list. Can be one of `ALL`, `ONLINE` and `NON_EMPTY`. |
   | `hiddenServers` | Specifies servers not to display. See example below. |
   | `playerComponent` | Determines how a player will be presented in the tab list. Usually you will want to set this to `{text: "${player name}", icon: "${player skin}", ping: "${player ping}"}`, eventually adding a prefix. This can be set to a list of basic components to use more than one slot per player. |
   | `morePlayersComponent` | This will be shown if there are more players than there is space in the tab list (or more players than `max-size`) |
   | `fillSlotsVertical` | Optional: If set to true the tab list slots are filled top-to-bottom first instead of left-to-right. |
   | `minSizePerServer` | Optional: Minimum slots to use for a single server |
   | `maxSizePerServer` | Optional: Maximum slots to use for a single server |
   | `minSize` | Optional: Minimum slots this component should use |
   | `maxSize` | Optional: Maximum slots this component should use |
   
   Example on using `serverOrder: custom`:
   ```yaml
   !players_by_server
   playerSet: global
   serverOrder: custom
   customServerOrder: [spawn, survival, creative]
   # ...
   ```
   
   Example on using the `hiddenServers` option:
   ```yaml
   !players_by_server
   playerSet: global
   showServers: ALL
   hiddenServers: [hub, private]
   # ...
   ```

6. **Table**

   ```yaml
   !table
   columns:
   <Column number(s)>: <List of Components>
   ```
   
   Example:
   
   ```yaml
   !table
   columns:
     0-1:
       - {text: "Survival"}
       - {text: ""}
       - !players
         playerSet: survival
         playerComponent: {text: "${player name}", icon: "${player skin}", ping: "${player ping}"}
         morePlayersComponent: {text: "... and ${other_count} others", skin: "default/players.png", ping: 0}
     2:
       - {text: "Stats:"}
       - {text: "Playtime:"}
       - {text: "  Total: ${viewer bungeeonlinetime}"} # just an example, these placeholders don't exist (yet)
       - {text: "  Session: ${viewer onlinetime}"}
       - {text: ""}
       - {text: "Balance: ${viewer vault_balance}"}
       - {text: ""}
       - {text: "Faction: ${viewer faction}"}
   ```
   
   Allows setting the content for the columns independently. This makes layouts possible where one column is used per server.

7. **Spacer**
   
   ```yaml
   !spacer {}
   ```
   
   Example:
   
   ```yaml
   size: 20
   components:
   - {text: "Top-most slot", icon: "colors/gold.png", ping: 0}
   - !spacer {}
   - {text: "Slot at the very bottom", icon: "colors/gold.png", ping: 0}
   ```

8. **Container**

   ```yaml
   !container
   fillSlotsVertical: <true/false>
   minSize: <Number>
   maxSize: <Number>
   components: <List of Components>
   ```
   
   Example:

   ```yaml
   components:
   - !container
     fillSlotsVertical: true
     components:
     - "Admins:"
     - !players
       playerSet: admin
       playerComponent: "${player vault_prefix}${player name}${afk_tag}"
       morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
     -
     - !players_by_server
       playerSet: global
       serverOrder: "playercount,online,alphabetically"
       serverHeader:
       - {text: "&e&n${server}&f&o (${server_player_count}):", icon: "colors/yellow.png", ping: 0}
       serverSeparator:
       -
       playerComponent: "${player vault_prefix}${player name}${afk_tag}"
       morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
   ```

   | Option | Description |
   | ------ | ----------- |
   | `fillSlotsVertical` | Optional: If set to true the tab list slots are filled top-to-bottom first instead of left-to-right. |
   | `minSize` | Optional: Minimum slots this component should use |
   | `maxSize` | Optional: Maximum slots this component should use |
   | `components` | These components will be displayed in the tablist space of the container component. |