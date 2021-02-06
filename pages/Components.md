The following components are available:

### Content
[!]: ToC

1. ### Basic Component/ Single Slot

   ```yaml
   {text: "...", icon: "image.png", ping: 0}
   ```

   The basic component represents the content of one slot in the tab list.
   It offers the following options:
   
   * ##### `icon`
   
        The `icon` option controls the icon on the left of the slot.
        
        Icons in the tab list are a feature which has been added in Minecraft version 1.8.
        You will not see them using older clients.
        They are not available in offline mode either.
        
        The `icon` option can be set to one of the following:
        
        1. The name of a 8x8 pixel `.png` file you saved in the `!!iconFolder` directory, e.g. `colors/blue.png`.
        
        2. A player name or uuid. You can set this to a name which does not belong to player to save bandwidth/ see random alex or steve skins. See <http://www.reddit.com/r/MinecraftHeads/comments/1m1s0g/official_heads_made_by_mojang_marc/> for cool skins/heads.
   
   * ##### `ping`
   
        The `ping` option configures the ping bar on the right of the slot.
        The following table shows the effect of different ping values:
        
        | Value     | Description          | Image                         |
        | --------- | -------------------- | ----------------------------- |
        | < 0       | crossed out ping bar | ![](images/ping_bar_-1.png)   |
        | 0 - 149   | five bars            | ![](images/ping_bar_0.png)    |
        | 150 - 299 | four bars            | ![](images/ping_bar_150.png)  |
        | 300 - 599 | three bars           | ![](images/ping_bar_300.png)  |
        | 600 - 999 | two bars             | ![](images/ping_bar_600.png)  |
        | > 1000    | one bar              | ![](images/ping_bar_1000.png) |
        
   * ##### `left`
   
        The `left` option sets the text displayed in the slot with alignment to the left.
        You can use the `left`, `center` and `right` options simultaneously, to have different pieces of text with different alignment in the same slot.
        You can use legacy formatting codes using the `§` or the `&` sign.
        Have a look at the [Text Format](Text-Format) page to learn about all options for selecting color, formatting and fonts.
        You can display information using placeholders.
        
   * ##### `center`
   
        The `center` option sets the text displayed in the slot with alignment to the middle.
        You can use the `left`, `center` and `right` options simultaneously, to have different pieces of text with different alignment in the same slot.
        You can use legacy formatting codes using the `§` or the `&` sign.
        Have a look at the [Text Format](Text-Format) page to learn about all options for selecting color, formatting and fonts.
        You can display information using placeholders.
        
   * ##### `right`
   
        The `right` option sets the text displayed in the slot with alignment to the right.
        You can use the `left`, `center` and `right` options simultaneously, to have different pieces of text with different alignment in the same slot.
        You can use legacy formatting codes using the `§` or the `&` sign.
        Have a look at the [Text Format](Text-Format) page to learn about all options for selecting color, formatting and fonts.
        You can display information using placeholders.
   
   * ##### `text`
   
        The `text` option controls the text displayed in the slot.
        You can use legacy formatting codes using the `§` or the `&` sign.
        Have a look at the [Text Format](Text-Format) page to learn about all options for selecting color, formatting and fonts.
        You can display information using placeholders.
        
        _Notice:_ Instead of using the `text` and `alignment` options we recommend you use the newer `left`, `center` and `right` options which allow you to have multiple pieces of text with different alignment in the same slot.
        
   * ##### `alignment`
   
       The `alignment` can be used to change the text alignment.
       It can be set to `LEFT`, `CENTER` or `RIGHT`.
       
       _Example:_
       ```yaml
       {text: "Centered text", icon: "image.png", ping: 0, alignment: CENTER}
       ```
       Or to do right bound text:
       ```yaml
       {text: "At the right", icon: "image.png", ping: 0, alignment: RIGHT}
       ```
        
        _Notice:_ Instead of using the `text` and `alignment` options we recommend you use the newer `left`, `center` and `right` options which allow you to have multiple pieces of text with different alignment in the same slot.
        
   * ##### `longText`
   
       The `longText` option allows specifying what happens if the text is too long to fit the slot. It can be set to `DISPLAY_ALL`, `CROP`, `CROP_2DOTS` or `CROP_3DOTS`. The default is `DISPLAY_ALL` which will display the text anyway. The other options cut off part of the text to make it fit an will eventually append 2 or 3 dots depending on which option you chose.
       
        The following table shows the different values you can use for the `longText` option:
        
        | Value         | Result      |
        | ------------- | ----------- |
        | `DISPLAY_ALL` | ![](images/long-text-display.png)
        | `CROP`        | ![](images/long-text-crop.png)
        | `CROP_2DOTS`  | ![](images/long-text-2dots.png)
        | `CROP_3DOTS`  | ![](images/long-text-3dots.png)
       
       _Example:_
       ```yaml
       {text: "${player vault_prefix}${player name}", longText: CROP_2DOTS}
       ```
   
2. ### `!animated` Component

   This `!animated` component makes it possible to create animated slots.
   To create an animation you need to provide a list of components of which the plugin displays one at a time and moves on to the next after the given time period.
   It has the following options which can be customized:
   
    * ##### `components`
    
        The `components` option is a list of other components.
        Typically, each of those represents the content a single slot.
        The `!animated` component will display one of those at a time.
    
    * ##### `interval`
    
        The `interval` option is the time (in seconds) after which the plugin will move to the next slot.
        
    * ##### `randomize`
    
        The `randomize` option can be set to either `true` or `false`.
        Not setting it has the same effect as setting it to `false`.
        When `randomize` is set to `true` the different components will be displayed in random order, otherwise they will be cycled through from top to bottom.
        
    _Schema:_
    ```yaml
    !animated
    components: <List of Components>
    interval: <Number>
    randomize: <true/false>
    ```
    
    _Example:_
    
    ![](images/animation-2.gif)
    ```yaml
    - !animated
      interval: 1.5
      components:
      - {text: "&cBalance: &6${viewer vault_balance 1.2}", icon: "default/balance.png", ping: 0}
      - {text: "&cRank: &6${viewer vault_primary_group}", icon: "default/rank.png", ping: 0}
      - {text: "&cPing: ${viewer_colored_ping}ms", icon: "default/ping.png", ping: 0}
    ```

3. ### `!conditional` Component

   The `!conditional` component can dynamically change the content of the tab list.
   Depending on whether the given condition is fulfilled it is displays one of two replacements.
   It has the following options:
   
    * ##### `condition`
    
        The `condition` option is a boolean expression deciding which replacement is used.
        You can use placeholders and compare them using operators such as `=`, `<` or `>` to create the condition.
        
    * ##### `true`
    
        The `true` option must be set to a component (or list of components) that is displayed if the condition is fulfilled.
        
    * ##### `false`
        The `false` option must be set to a component (or list of components) that is displayed if the condition evaluated to `false`.  
   
   _Schema:_
   ```yaml
   !conditional
   condition: <Expression>
   true: <Component or List of Components>
   false: <Component or List of Components>
   ```
   
   [!]: ifBTLP
   _Example:_
   The example shows how you can display whether a server is online.
   It also changes the icon of the slot.
   ```yaml
   !conditional
   condition: ${server:survival online} == true
   true: {text: "&bSurvival: &aONLINE", icon: "colors/green.png", ping: 0}
   false: {text: "&bSurvival: &cOFFLINE", icon: "colors/red.png", ping: 0}
   ```
   
   [!]: endIf
   
   _Additional Information:_ [Expression Syntax](Expressions)

4. ### `!players` Component

   The `!players` component provides a simple way of adding players to the tab list.
   The following options can be used to customize the `!players` component.
   
   * ##### `playerSet`
   
       The `playerSet` option selects which players to display on the tab list.
       
       If you want to change which players the tab list displays, e.g. so it only displays players in a specific group, do the following:
       1.  Create a player set containing the players you want to display.
           Check out the [Player Sets](Player-Sets) wiki page for more information.
       2.  Set `playerSet` to the name of the player set you created in step i.

    * ##### `playerOrder`
    
        The `playerOrder` option specifies the order in which players are displayed on the tab list.
        Have a look at the [Player Order](Player-Order) wiki page for more information.
   
   * ##### `playerComponent`
       
       The `playerComponent` option controls the text displayed in player slots.
       You can use placeholders to display nicknames, prefixes and suffixes and otherwise change the appearance of the player name.
       
       Note that when using placeholders you should use the `player` variant of the placeholder.
   
   * ##### `morePlayersComponent`
   
       The `morePlayersComponent` option is a custom slot that is displayed if there
        is not enough space on the tab list to display all of the players:
        
        ![](images/more-players-component-2.png)
       
   * ##### `fillSlotsVertical`
   
       The `fillSlotsVertical` option can be used to change the order in which slots are filled.
       The following screenshot illustrates the effect:
        
       | `fillSlotsVertical: false`            | `fillSlotsVertical: true`             |
       | ------------------------------------- | ------------------------------------- |
       | ![](images/vertical-slot-order-1.png) | ![](images/vertical-slot-order-2.png) |
        
       Not using the `fillSlotsVertical` option has the same effect as setting it to false.
       If it is not present in your config file and you want to use it
       all you have to do is to add the `fillSlotsVertical: true` line to the options of the `!players` component.
   
   * ##### `minSize`
   
       The `minSize` option specifies the minimum number of slots to be used by the `!players` component.
       If there are less players than the number specified by `minSize`, the plugin will add some empty slots after the players, such that the `!players` component uses `minSize` slots.
   
   * ##### `maxSize`
   
       The `maxSize` option specifies the maximum number of slots to be used by the `!players` component.
       If there are more players than can be displayed in `maxSize` slots, the plugin will not display all of them, make use of the `morePlayersComponent` to indicate that there are more players and use exactly `maxSize` slots.
        
       Setting `minSize` and `maxSize` to the same value guarantees that the `!players` component always uses the same number of slots.
       It will not change its size depending on the number of players.
       That way the component after the `!players` component always appears at the same location.
       This can be useful for some layouts, especially in conjunction with the `!table` component.
   
   _Schema:_
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
   
   _Example:_
   ```yaml
   !players
   playerSet: all_players
   playerOrder: "vault_primary_group_weight asc, name asc"
   playerComponent: "${player name}"
   morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
   ```
   
[!]: ifBTLP
5. ### `!players_by_server` Component

    The `!players_by_server` component adds players to the tab list grouping them by server as seen in the default config.
    You can customize its appearance using the following options:
    
    * ##### `playerSet`
    
        The `playerSet` option selects which players to display on the tab list.
        
        If you want to change which players the tab list displays, e.g. so it only displays players in a specific group, do the following:
        1.  Create a player set containing the players you want to display.
            Check out the [Player Sets](Player-Sets) wiki page for more information.
        2.  Set `playerSet` to the name of the player set you created in step i.

    * ##### `playerOrder`
    
        The `playerOrder` option specifies the order in which players are displayed on the tab list.
        Have a look at the [Player Order](Player-Order) wiki page for more information.
        
    * ##### `serverOrder`
    
        Determines the order of the servers.
        Possible values for `serverOrder` are `alphabetically`, `playercount`, `online` and `custom`.
        Multiple orderings can be chained by separating the with a comma, just the way it works with `playerOrder`.
    
    * ##### `customServerOrder`
    
        Specifies the server order if you used `custom` in the `serverOrder` option.
        
        Example using `serverOrder: custom`:
        ```yaml
        !players_by_server
        playerSet: all_players
        serverOrder: custom
        customServerOrder: [spawn, survival, creative]
        # ...
        ```
    
    * ##### `serverHeader`
    
        The `serverHeader` option specifies a list of custom slots displayed
         for each server above the players on that server. Here two special placeholders
         `${server}` and `${server_player_count}` can be used to display the name of the
         server and the number of players on it.
    
    * ##### `serverFooter`
    
        The `serverFooter` specifies a list of custom slots displayed
         for each server below the players on that server. Here two special placeholders
         `${server}` and `${server_player_count}` can be used to display the name of the
         server and the number of players on it.
    
    * ##### `serverSeparator`
    
        The `serverSeparator` specifies a list of custom slots displayed
         between each pair of two servers.
    
    * ##### `showServers`
    
        The `showServers` controls which servers should appear on the tablist:
        
        | Option      | Description                          |
        | ----------- | ------------------------------------ |
        | `ALL`       | All servers are displayed            |
        | `ONLINE`    | Only running servers are displayed   |
        | `NON_EMPTY` | Only non empty servers are displayed |
        
        Example:
        
        | ALL | NON_EMPTY |
        | ---- | ----- |
        | ![](images/players-by-server-2.png) | ![](images/players-by-server-3.png) |
    
    * ##### `mergeServers`
    
        The `mergeServers` option makes two or more servers appear as a single server.
        This is useful e.g. if you have multiple lobby servers.
        
        _Schema:_
        ```yaml
        mergeServers:
          <group name>: [<server name>, <servername>, ...]
          <group name>: [<server name>, <servername>, ...]
          ...
        ```
        
        Example on using the `mergeServers` option:
        
        |  Before | ![](images/mergeservers-before.png)  |
        | ---- | ----- |
        | **After** | ![](images/mergeservers-after.png) |
        
        ```yaml
        !players_by_server
        playerSet: all_players
        serverHeader: "> &b${server}"
        mergeServers:
          lobby: [lobby0, lobby1]  
        # ...
        ```
        
    * ##### `prioritizeViewerServer`
    
        Setting the `prioritizeViewerServer` option to `true` tells the plugin to use more space for displaying the viewer's server.
        Instead of using an equal amount of slots for each server, the viewer's server will be given more space if required to fit all its players.
        The `prioritizeViewerServer` is enabled by default.
        
    * ##### `hiddenServers`
    
        The `hiddenServers` option specifies a list of servers which will not be displayed.
        
        Example on using the `hiddenServers` option:
        ```yaml
        !players_by_server
        playerSet: all_players
        showServers: ALL
        hiddenServers: [hub, private]
        # ...
        ```
    
    * ##### `playerComponent`
        
        The `playerComponent` option controls the text displayed in player slots.
        You can use placeholders to display nicknames, prefixes and suffixes and otherwise change the appearance of the player name.
        
        Note that when using placeholders you should use the `player` variant of the placeholder.
    
    * ##### `morePlayersComponent`
    
        The `morePlayersComponent` option is a custom slot that is displayed if there
         is not enough space on the tab list to display all of the players:
        ![](images/more-players-component.png)

   * ##### `fillSlotsVertical`
   
       The `fillSlotsVertical` option can be used to change the order in which slots are filled.
       The following screenshot illustrates the effect:
        
        | `fillSlotsVertical: false`            | `fillSlotsVertical: true`             |
        | ------------------------------------- | ------------------------------------- |
        | ![](images/vertical-slot-order-4.png) | ![](images/vertical-slot-order-3.png) |
        
        Not using the `fillSlotsVertical` option has the same effect as setting it to false.
        If it is not present in your config file and you want to use it
        all you have to do is to add the `fillSlotsVertical: true` line to the options of the `!players_by_server` component.
   
   * ##### `minSizePerServer`
   
        The `minSizePerServer` option specifies the minimum number of slots to be used for each server. This includes the `serverHeader`, the players, the `morePlayersComponent` and the `serverFooter`.
   
   * ##### `maxSizePerServer`
   
        The `maxSizePerServer` option specifies the maximum number of slots to be used for a single server. This includes the `serverHeader`, the players, the `morePlayersComponent` and the `serverFooter`.
   
   * ##### `minSize`
   
        The `minSize` option specifies the minimum number of slots to be used by the `!players_by_server` component.
        If there are less players than the number specified by `minSize`, the plugin will add some empty slots after the players, such that the `!players_by_server` component uses `minSize` slots.
   
   * ##### `maxSize`
   
        The `maxSize` option specifies the maximum number of slots to be used by the `!players_by_server` component.
        If there are more players than can be displayed in `maxSize` slots, the plugin will not display all of them, make use of the `morePlayersComponent` to indicate that there are more players and use exactly `maxSize` slots.
        
        Setting `minSize` and `maxSize` to the same value guarantees that the `!players_by_server` component always uses the same number of slots.
        It will not change its size depending on the number of players.
        That way the component after the `!players_by_server` component always appears at the same location.
        This can be useful for some layouts, especially in conjunction with the `!table` component.
        
   _Schema:_
   ```yaml
   !players_by_server
   playerSet: <String>
   playerOrder: <String>
   serverOrder: <String>
   customServerOrder: <List of servers>
   serverHeader: <List of Components>
   serverFooter: <List of Components>
   serverSeparator: <List of Components>
   showServers: <ALL, ONLINE, NON_EMPTY>
   mergeServers:
     <group name>: [<server name>, <servername>, ...]
   prioritizeViewerServer: <true/false>
   hiddenServers: <List of servers>
   playerComponent: <Component or list of components>
   morePlayersComponent: <Component or list of components>
   fillSlotsVertical: <true/false>
   minSizePerServer: <Number>
   maxSizePerServer: <Number>
   minSize: <Number>
   maxSize: <Number>
   ```
   
   _Example:_
   
   ```yaml
   !players_by_server
   playerSet: global
   playerOrder: "vault_primary_group_weight asc, name asc"
   serverOrder: "playercount,alphabetically"
   serverHeader:
   - {text: "&e&n${server}&f&o (${server_player_count}):", icon: "colors/yellow.png", ping: 0}
   showServers: NON_EMPTY
   playerComponent: "${player name}"
   morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
   ```

[!]: endIF
[!]: ifATO
5. ### `!players_by_world` Component

    The `!players_by_world` component adds players to the tab list grouping them by world.
    You can customize its appearance using the following options:
    
    * ##### `playerSet`
    
        The `playerSet` option selects which players to display on the tab list.
        
        If you want to change which players the tab list displays, e.g. so it only displays players in a specific group, do the following:
        1.  Create a player set containing the players you want to display.
            Check out the [Player Sets](Player-Sets) wiki page for more information.
        2.  Set `playerSet` to the name of the player set you created in step i.

    * ##### `playerOrder`
    
        The `playerOrder` option specifies the order in which players are displayed on the tab list.
        Have a look at the [Player Order](Player-Order) wiki page for more information.
    
    * ##### `worldHeader`
    
        The `worldHeader` option specifies a list of custom slots displayed
         for each world above the players on that world. Here two special placeholders
         `${world name}` and `${world player_count}` can be used to display the name of the
         world and the number of players on it.
    
    * ##### `worldFooter`
    
        The `worldFooter` specifies a list of custom slots displayed
         for each world below the players on that world. Here two special placeholders
         `${world name}` and `${world player_count}` can be used to display the name of the
         world and the number of players on it.
    
    * ##### `worldSeparator`
    
        The `worldFooter` specifies a list of custom slots displayed
         between each pair of two worlds.
    
    * ##### `playerComponent`
        
        The `playerComponent` option controls the text displayed in player slots.
        You can use placeholders to display nicknames, prefixes and suffixes and otherwise change the appearance of the player name.
        
        Note that when using placeholders you should use the `player` variant of the placeholder.
    
    * ##### `morePlayersComponent`
    
        The `morePlayersComponent` option is a custom slot that is displayed if there
         is not enough space on the tab list to display all of the players:
        ![](images/more-players-component.png)

   * ##### `fillSlotsVertical`
   
       The `fillSlotsVertical` option can be used to change the order in which slots are filled.
       The following screenshot illustrates the effect:
        
        | `fillSlotsVertical: false`            | `fillSlotsVertical: true`             |
        | ------------------------------------- | ------------------------------------- |
        | ![](images/vertical-slot-order-4.png) | ![](images/vertical-slot-order-3.png) |
        
        Not using the `fillSlotsVertical` option has the same effect as setting it to false.
        If it is not present in your config file and you want to use it
        all you have to do is to add the `fillSlotsVertical: true` line to the options of the `!players_by_world` component.
   
   * ##### `minSizePerWorld`
   
        The `minSizePerWorld` option specifies the minimum number of slots to be used for each world. This includes the `worldHeader`, the players, the `morePlayersComponent` and the `worldFooter`.
   
   * ##### `maxSizePerWorld`
   
        The `maxSizePerWorld` option specifies the maximum number of slots to be used for a single world. This includes the `worldHeader`, the players, the `morePlayersComponent` and the `worldFooter`.
   
   * ##### `minSize`
   
        The `minSize` option specifies the minimum number of slots to be used by the `!players_by_world` component.
        If there are less players than the number specified by `minSize`, the plugin will add some empty slots after the players, such that the `!players_by_world` component uses `minSize` slots.
   
   * ##### `maxSize`
   
        The `maxSize` option specifies the maximum number of slots to be used by the `!players_by_world` component.
        If there are more players than can be displayed in `maxSize` slots, the plugin will not display all of them, make use of the `morePlayersComponent` to indicate that there are more players and use exactly `maxSize` slots.
        
        Setting `minSize` and `maxSize` to the same value guarantees that the `!players_by_world` component always uses the same number of slots.
        It will not change its size depending on the number of players.
        That way the component after the `!players_by_world` component always appears at the same location.
        This can be useful for some layouts, especially in conjunction with the `!table` component.
   
   _Schema:_
   ```yaml
   !players_by_world
   playerSet: <String>
   playerOrder: <String>
   worldHeader: <List of Components>
   worldFooter: <List of Components>
   worldSeparator: <List of Components>
   playerComponent: <Component or list of components>
   morePlayersComponent: <Component or list of components>
   fillSlotsVertical: <true/false>
   minSizePerWorld: <Number>
   maxSizePerWorld: <Number>
   minSize: <Number>
   maxSize: <Number>
   ```
   
[!]: endIF

6. ### `!table` Component

    The `!table` component makes it possible to configure the columns of the tab list individually.
    It has two options:
    
   * ##### `columns`
        
        The `columns` option is a map.
        It maps each column number to a list of components that will be displayed in that column.
        The columns numbers start from `0` (left most column).
        You use two columns to display single component by joining the column number with a `-`,  e.g. using `1-2` as key.
        
   * ##### `size`
   
        The `size` option specifies the number of slots used by the `!table` component.
        This option is optional, and should not be required by most users.
        When used this must be a multiple of the number of columns.
   
    _Schema:_
   ```yaml
   !table
   size: <Number>
   columns:
     <Column number(s)>: <List of Components>
   ```
   
   _Example:_
   
   ```yaml
   !table
   columns:
     0:
       - "Content of the first column"
       - "..."
     1-2:
       - "This"
       - "goes"
       - "to"
       - "the"
       - "second"
       - "and"
       - "third"
       - "column"
     3:
       - "Content of the fourth column"
       - "..."
   ```

7. ### `!spacer` component
   
   The `!spacer` component can be used to fill part of the tab list with empty slots.
   Those slots will use the icon defined by the `defaultIcon` option and the ping set by the `defaultPing` option.
   The `!spacer` component does not have any configurable options.
   
   _Schema:_
   ```yaml
   !spacer
   ```
   
   _Example showing the use of the `!spacer` component with some context:_
   
   ```yaml
   size: 20
   components:
   - {text: "Top-most slot", icon: "colors/gold.png", ping: 0}
   - !spacer
   - {text: "Slot at the very bottom", icon: "colors/gold.png", ping: 0}
   ```

8. ### `!container` component

    The `!container` component acts as a wrapper for the other components it contains.
    It allows changing the order in which those components fill the slots of the tab list as well setting a minimum/ maximum for the number of slots used by those components.
    
    The `!container` component has the following options:
    
    * ##### `fillSlotsVertical`
    
        The `fillSlotsVertical` option can be used to change the order in which slots are filled.
        Not using the `fillSlotsVertical` option has the same effect as setting it to false.
        
    * ##### `minSize`
    
         The `minSize` option specifies the minimum number of slots to be used.
         If the components inside the `!container` component use less slots than specified by `minSize`, the plugin will add empty slots.
    
    * ##### `maxSize`
    
         The `maxSize` option specifies the maximum number of slots that can be used by the  components inside the `!container` component.
    
    * ##### `components`
    
        The `components` option specifies the components inside the `!container` component.

    _Schema:_
   ```yaml
   !container
   fillSlotsVertical: <true/false>
   minSize: <Number>
   maxSize: <Number>
   components: <List of Components>
   ```
   
   _Example showing the use of the `!container` component with some context:_

   ```yaml
   components:
   - !container
     fillSlotsVertical: true
     components:
     - "Admins:"
     - !players
       playerSet: admins
       playerComponent: "${player vault_prefix}${player name}${afk_tag}"
       morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
     -
     - !players
       playerSet: non_admins
       playerComponent: "${player vault_prefix}${player name}${afk_tag}"
       morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
   ```
   
--------------------------------------------------------------------------------

Next: [Player Order](Player-Order)
