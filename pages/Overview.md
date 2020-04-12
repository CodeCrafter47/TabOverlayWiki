This page provides an overview of the available configuration files and
 directories. It explains what is configured in which file.

### Directory Structure

On the first startup the plugin creates the default configuration.
It consists of a config file (`config.yml`) as well as the `tabLists/` and `!!iconFolder` directories.

* #### `config.yml`:
  
  Global configuration file containing different useful settings that can be used within the different tab lists.
  Please check the [Global Configuration ](GlobalConfiguration) page for more information.

* #### `tabLists/`
  
  Here are the files for configuring the actual look of the tab list. By default
  there is only one file called `default.yml`. You can however create more files
  to provide different tab lists to players depending on several conditions 
  (e.g. the players server or permission group).
  
  If you have more than one `.yml` file in the `tabLists` directory the plugin will use the `showTo` and `priority` options inside the `.yml` files to decide which tab list a player sees.

* #### `!!iconFolder`
  
  This is the location of image files which can be used as icons in the tab list.
  You can add custom icons if you like. The files must be in the png format and
  have a size of 8x8 pixel.
  
  This folder contains custom textures that can be used as icons in the tab list.
  You can create new sub-folders add as many images as you like, but keep the following things in mind:
  
    *  New textures need a few minutes to load before being usable.
    *  The image needs to be a `.png` file and with the size of 8x8 pixels.

--------------------------------------------------------------------------------

### Tab List Configuration

A _tab list configuration file_ is a `.yml` file in the `tabLists/` directory.
It is used to configure the layout and content of the tab list.
On a fresh installation the `tabLists/` directory contains one file called `default.yml`.

It is possible to create multiple tab list layouts by creating multiple tab list configuration files in the `tabLists` directory.
This allows you to e.g. display a different tab list to admins or to players on a particular server.


Each _tab list configuration file_ can be of one of two different types: `FIXED_SIZE` or `DYNAMIC_SIZE`.

When using the `FIXED_SIZE` type, the number of slots must be specified in advance.
The `DYNAMIC_SIZE` tab list type adapts the number of slots to the amount of players online.
The big advantage of the `FIXED_SIZE` tab list type is that it allows for custom text slots.

The following image illustrates the difference.

[!]: todo

| `FIXED_SIZE`                   | `DYNAMIC_SIZE`                      |
| ------------------------------ | ----------------------------------- |
| ![](images/default-config.gif) | ![](images/dynamic-size-config.png) |

As a result of having two different tab list types, some config options are available independent of the tab list type, whereas other options are only available when using one of the tab list types.

#### Type independent options

* ##### `showTo` and `priority`

   These options decide which tab list each player should see if you have more than one tab list configuration file.
   
   The `showTo` option is a predicate used to decide whether a player can see the tab list.
     You can use placeholders and compare them using e.g. `=`, `<` or `>` to create the predicate.
     
     If no tab list configuration file can be shown to a player according to the `showTo` predicate, then he will see the vanilla tab list.
     
     If there are multiple tab lists which can be shown to a player according to the `showTo` predicate, the plugin selects the tab list with the larger `priority`.
     So if you create a tab list visible only on a specific server, you should give a higher `priority` (larger number) than the default tab list (`default.yml`) which is typically visible to all players.
     
     ###### Examples:
     
     The `default.yml` sets these options to the following values:
     ```yaml
     showTo: all
     priority: 0
     ```
     
     [!]: ifBTLP
     A tab list that is visible only to players on the `survival` server might use the following values:
     ```yaml
     showTo: ${viewer server} = "survival"
     priority: 10
     ```
  
     A tab list that is visible only on some servers, e.g. the `survival`, `plotworld` and `creative` servers:
     ```yaml
     showTo: |
       ${viewer server} = "survival"
       or ${viewer server} = "plotworld"
       or ${viewer server} = "creative"
     priority: 10
     ```
     
     [!]: endIF
     
     [!]: ifATO
     A tab list that is visible only to players on a specific world, e.g. `hub`, might use the following values:
     ```yaml
     showTo: ${viewer world} = "hub"
     priority: 10
     ```
  
     A tab list that is visible only on some worlds, e.g. the `survival`, `survival_nether` and `survival_the_end` servers:
     ```yaml
     showTo: |
       ${viewer world} = "survival"
       or ${viewer world} = "survival_nether"
       or ${viewer world} = "survival_the_end"
     priority: 10
     ```
     
     [!]: endIF
     
     You want a different tab list for staff.
     This can be achieved by giving all staff members a specific permission. e.g. `tablist.staff` and checking that permission in the `showTo` predicate:
     ```yaml
     showTo: ${viewer permission tablist.staff}
     priority: 10
     ```

* ##### `showHeaderFooter`, `header`, `footer`, `headerAnimationUpdateInterval` and `footerAnimationUpdateInterval`

    These are used to configure the header and footer of the tab list.
    
    The `showHeaderFooter` can be used to enable/ disable the header and footer provided by !!name.
    E.g. if you want to use a different plugin for the header and footer you can disable that functionality in !!name by setting `showHeaderFooter` to `false`.
    
    How to configure the header and footer is explained on the [Header and Footer](Header and Footer) page.
    
* ##### `hiddenPlayers`

    The `hiddenPlayers` changes who can see hidden players. The following options are available:
    
    | Value       | Description                                   |
    | ----------- | --------------------------------------------- |
    | `VISIBLE`   | Hidden players are shown on the tab list.     |
    | `VISIBLE_TO_ADMINS` | Players with the `!!seevanishedperm` permission can see hidden players. This is the default. |
    | `INVISIBLE` | Hidden players do not appear on the tab list. |
    
    If this option is not present in your tab list configuration file, just add the following line:
    ```yaml
    hiddenPlayers: VISIBLE_TO_ADMINS
    ```
  
    Checkout the [Hidden Players](Hidden Players) wiki page for more information.
    
* ##### `customPlaceholders`

    The custom placeholders feature allows you to create your own placeholders.
    It can be used to create custom prefixes, animations and much more.
    Check out the [Custom Placeholders](Custom Placeholders) wiki page.
    
* ##### `playerSets`

    A _player set_ is a named subset of your players.
    The plugin uses player sets to display players and player counts in the tab list.
    How to create and use player sets is discussed on the [Player Sets](Player Sets) wiki page.
    
* ##### `longText`

    The `longText` option decides what happens to text that is too long to fit a slot of the tab list.
    The following table shows the different values you can use for the `longText` option:
    
    | Value         | Result      |
    | ------------- | ----------- |
    | `DISPLAY_ALL` | ![](images/long-text-display.png)
    | `CROP`        | ![](images/long-text-crop.png)
    | `CROP_2DOTS`  | ![](images/long-text-2dots.png)
    | `CROP_3DOTS`  | ![](images/long-text-3dots.png)
    
    If the `longText` option is not present in your tab list configuration file, you can add it yourself.
    E.g. by aadding the following line:
    ```yaml
    longText: CROP_2DOTS
    ```

* ##### `type`

    The `type` option decides on the tab list type.
    It can be set to `FIXED_SIZE` or `DYNAMIC_SIZE`. Depending on
 which one you choose different type specific config options will be available.

#### Type Specific Options

The type specific options are discussed on the [Dynamic Size Tab List](Dynamic Size Tab List) and [Fixed Size Tab List](Fixed Size Tab List) wiki pages.

--------------------------------------------------------------------------------

Next: [Configuration Basics Part 3 - Header and Footer](Configuration-Basics-Part-3---Header-and-Footer)