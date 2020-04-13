
The following options in the tab list configuration file control the appearance of the header and footer of the tab list:

* ##### `showHeaderFooter`

    The `showHeaderFooter` is used to enable or disable the header and footer. You
     may want to disable it if you are using a Bukkit plugin to provide the header
     and footer.
     
* ##### `header` and `headerAnimationUpdateInterval`

    The `header` and `headerAnimationUpdateInterval` options control the appearance of the header.
    The `header` option controls the text that is displayed.
    The `headerAnimationUpdateInterval` option selects the interval (in seconds) at which the header animation switches to the next line.
    If you do not have an animation in the header you can remove the `headerAnimationUpdateInterval` option  from your tab list configuration file.
    
    You can use [Formatting codes](http://minecraft.gamepedia.com/Formatting_codes) using the `§` or the `&` sign.
    You can display information using placeholders.
    When using a player-bound placeholder you must use the `viewer` variant of  that placeholder.
    
    The following examples show how those two options can be used to configure the header:
    
    ###### Single Line, Non Animated Header
    ```yaml
    header: "&cWelcome &f${viewer name}"
    ```
    
    ###### Multi Line, Non Animated Header
    ```yaml
    header: |-
      &cWelcome &f${viewer name}
      &7Total players:&f ${playerset:all_players size}
      &f&nPowered by !!name
    ```
    
    ###### Single Line, Animated Header
    ```yaml
    header:
    - "&cWelcome &f${viewer name}"
    - "&eW&celcome &f${viewer name}"
    - "&eWe&clcome &f${viewer name}"
    - "&eWel&ccome &f${viewer name}"
    - "&eWelc&come &f${viewer name}"
    - "&eWelco&cme &f${viewer name}"
    - "&eWelcom&ce &f${viewer name}"
    - "&eWelcome &f${viewer name}"
    - "&cW&eelcome &f${viewer name}"
    - "&cWe&elcome &f${viewer name}"
    - "&cWel&ecome &f${viewer name}"
    - "&cWelc&eome &f${viewer name}"
    - "&cWelco&eme &f${viewer name}"
    - "&cWelcom&ee &f${viewer name}"
    - "&cWelcome &f${viewer name}"
    headerAnimationUpdateInterval: 0.2
    ```
    
    ###### Multi Line, Animated Header
    ```yaml
    header:
    - |-
      &6Line 1
      &eLine 2
    - |-
      &eLine 1
      &6Line 2
    headerAnimationUpdateInterval: 0.5
    ```

* ##### `footer` and `footerAnimationUpdateInterval`

    The `footer` and `footerAnimationUpdateInterval` options control the appearance of the footer.
    Those two options work the same way for configuring the footer as the `header` and `headerAnimationUpdateInterval` options work for configuring the header.

--------------------------------------------------------------------------------

Next: [Dynamic Size Tab List](Dynamic-Size-Tab-List)