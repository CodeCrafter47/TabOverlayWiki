A custom placeholder is a new placeholder that is created in the config.
Custom placeholders can
 * be simple aliases,
 * add complex logic based on placeholders,
 * create animations or
 * do some basic calculations.

### Content
[!]: ToC

### Creating Custom Placeholders

Custom placeholders can be in the `customPlaceholders` section in `config.yml` as well as in the `customPlaceholders` section of each tab list configuration file.
Custom placeholders created in `config.yml` can be used in all tab list configuration files.
Custom placeholders created in a tab list configuration file can only be used in that file.

Each custom placeholder consists of
 * a name,
 * a type tag and
 * options specific to the custom placeholder.
 
The basic schema of the `customPlaceholders` looks like this:

```yaml
customPlaceholders:
  name:
    !tag
    option: value
    option: value
  name:
    !tag
    option: value
    option: value
  ...
```

_Example:_
```yaml
customPlaceholders:
  afk_tag:
    !conditional
    condition: ${player essentials_afk}
    true: "&7|&oaway"
    false: ""
```
In the example above the name of the custom placeholder is `afk_tag`, the type tag is `!conditional`, and we set the three options `condition`, `true` and `false`.
That creates the `${afk_tag}` placeholder, which will be replaced with `&7|&oaway` if the player is afk.

### Different Types of Custom Placeholders

The following types of custom placeholders are available:

1. #### `!conditional`

    The `!conditional` custom placeholder is replaced with one of two replacements depending on a condition.
    It offers the following options for customization:
    
    * ##### `condition`
    
        The `condition` option is a boolean expression deciding which replacement is used.
        You can use placeholders and compare them using operators such as `=`, `<` or `>` to create the condition.
        
        Additional information on creating expressions is available on the [Expression Syntax](Expressions) page.
        
    * ##### `true`
    
        The `true` option sets the replacement text to be used if the condition is true.
        You can use formatting codes and placeholders.
        
    * ##### `false`
    
        The `false` option sets the replacement text to be used if the condition is false.
        You can use formatting codes and placeholders.
        
    * ##### `parameters`
    
        The optional `parameters` option allows creating a custom placeholder with parameters.
        The `parameters` option must be set to the number of parameters the placeholder accepts.
        You can use `%0`, `%1`, ... in the other options to refer to the first, second, ... parameter.
        When using the custom placeholder you can specify parameters by adding them after the placeholder name, separated by spaces: `${name param1 param2 ...}`.
        
        Note that the first parameter is `%0`.
        If you have e.g. `parameters: 5` the last parameter is `%4`.
        So if you were to use `%5` somewhere it will not be replaced since you have only 5 (not 6) parameters.
        If you use the placeholder with more parameters that its number of parameters, the last parameter will also contain all the additional parameters.
        
        [!]: ifBTLP
        
        _Example:_
        
        Assume you want to create a placeholder that displays `Online` if a server is online and `Offline` if a server is offline.
        Instead of creating a custom placeholder for each server you want to create just one placeholder that has a parameter for the server name.
        The following code creates a custom placeholder called `server_state` doing just that:
        ```yaml
        customPlaceholders:
          # ...
          server_state:
            !conditional
            parameters: 1
            condition: ${server:%0 online}
            true: "&aOnline"
            false: "&cOffline"
        ```
        You can use that placeholder by using `${server_state <server>}` anywhere in your config.
        Just replace `<server>` with an actual server name.
        E.g. if you want to display whether the `minigames` server is online use `${server_state minigames}`.
        
        [!]: endIF
        
    _Schema:_
    ```yaml
    <name>:
      !conditional
      parameters: <Number>
      condition: <Expression>
      true: <Text>
      false: <Text>
    ```
        
2. #### `!switch`

    The `!switch` custom placeholder maps the results of an expression, typically a placeholder, to an arbitrary replacement text.
    It is often used to create custom prefixes specific to the tab list.
    The `!switch` custom placeholder offers the following options for customization:
    
    * ##### `expression`
    
        The `expression` option is an expression which is evaluated to select the replacement.
        The result of evaluating the expression is text.
        In many cases the expression consists just of a single placeholder.
        However, that is not required.
        You can also concatenate multiple placeholders using the `.` operator.
        
        Additional information on creating expressions is available on the [Expression Syntax](Expressions) page.
    
    * ##### `replacements`
    
        The `replacements` options defines a map of different replacements for the `!switch` custom placeholder.
        The replacement for the `!switch` custom placeholder is selected by
        1. evaluating the expression and
        2. looking up a replacement for its value in the `replacements` map.
    
        _Example:_
        
        Assuming you set up the `expression` to return the players group, you can have the placeholder return small tags suitable as prefixes using the following code:
        ```yaml
        replacements:
          "admin": "&c[A]&f"
          "mod": "&b[M]&f"
          "vip": "&b[V]&f"
        ```
    
    * ##### `defaultReplacement`
    
        The `defaultReplacement` option defines the replacement text to be used when there is no suitable replacement in the `replacements` map.
        
    * ##### `parameters`
    
        The optional `parameters` option allows creating a custom placeholder with parameters.
        Refer to the `!conditional` custom placeholder type for more information.
        
    _Schema:_
    ```yaml
    <name>:
      !switch
      parameters: <Number>
      expression: <Expression>
      replacements:
        <value>: <Text>
        <value>: <Text>
        ...
      defaultReplacement: <Text>
    ```

3. #### `!animated`

    The `!animated` custom placeholder allows creating animations in a simple way.
    It has the following options:
    
    * ##### `elements`
    
        The `elements` is a list of replacement texts for the `!animated` custom placeholder.
        The replacements will be used one at a time and cycled through at a configurable interval.
    
    * ##### `interval`
    
        The `interval` options controls the interval (in seconds) after which the plugin will switch to the next replacement.
        
    * ##### `randomize`
    
        The optinal `randomize` option can be set to either `true` or `false`.
        Not setting it has the same effect as setting it to `false`.
        When `randomize` is set to `true` the different replacements will be displayed in random order, otherwise they will be cycled through from top to bottom.
        
    * ##### `parameters`
    
        The optional `parameters` option allows creating a custom placeholder with parameters.
        Refer to the `!conditional` custom placeholder type for more information.
        
    _Schema:_
    ```yaml
    <name>:
      !animated
      parameters: <Number>
      elements:
        - <Text>
        - <Text>
        ...
      interval: <Number>
      randomize: <true/false>
    ```
   
4. #### `!compute`

    The `!compute` custom placeholder can be used to perform some simple calculations.
    It is simpler to use than the other types of custom placeholders as it does not have any options.
    You just need to provide a name and the expression to be computed.
    In the expression you can use placeholders and basic math operators such as `+`, `-`, `*` and `/`.
    
    Additional information on creating expressions is available on the [Expression Syntax](Expressions) page.
    
    _Schema:_
    ```yaml
    <name>:
      !compute
      <Expression>
    ```
   
    _Example:_
    
    The following example creates the ${health_percentage} placeholder, which can be used to display the health as a percentage value.
    ```yaml
    health_percentage:
      !compute
      (${viewer health} / ${viewer max_health}) * 100
    ```
   
5. #### Alias

    The alias custom placeholder type is event more simple.
    It does not even have a tag.
    You just need to specify the name and the text that should replace the custom placeholder.
    
    _Schema:_
    ```yaml
    <name>: <Text>
    ```

6. #### `!color_animation`

    The `!color_animation` custom placeholder allows creating color gradients and rainbow-like animations in a simple way.
    It has the following options:
    
    * ##### `colors`
    
        The `colors` is a list of colors used in the animation. A color can be a legacy color code such as `&a` or an rgb color such as `#012345`.
    
    * ##### `distance`
    
        The distance between two colors. If this is not set, the distance is calculated such that the first color is applied to the first letter of the text and the last color is applied to the last letter of the text.
        
    * ##### `speed`
    
        Determines how fast the colors move through the text. Can be negative to inverse the direction.
        
    _Schema:_
    ```yaml
    <name>:
      !color_animation
      colors: [<color>, <color>, ..., <color>]
      distance: <Number>
      speed: <Number>
    ```
   
   _Example:_
   The following example creates the `${my_rainbow <text>}` placeholder which applies a slowly shifting rainbow effect to the text. It can be used e.g. using `${my_rainbow This is some lovely rainbow text}`.
   
   ```yaml
   customPlaceholders:
     my_rainbow:
       !color_animation
       colors: ['#FF0000', '#FFA500', '#FFFF00', '#32CD32', '#00BFFF', '#8A2BE2', '#EE82EE']
   ```

7. #### `!progress_bar`

    The `!progress_bar` custom placeholder creates a progress bar.
    
    _Example:_
       The following example creates the `${health_bar}` placeholder which display the health of the player looking at the tab list.
       
    ```yaml
    customPlaceholders:
      health_bar:
        !progress_bar
        value: ${viewer health}
        maxValue: ${viewer max_health}
        style: hearts
    ```
       
    ##### Basic options
    The following options you will typically use when creating a progress bar:
    
    * ##### `value`
    
        Expression for the number the progress bar will be based on.
        
    * ##### `minValue`
    
        Expression for the number corresponding to 0%.
        If not set the default is 0.
    
    * ##### `maxValue`
    
        Expression for the number corresponding to 100%.
    
    * ##### `style`
    
        Style preset. This options allows you use one of the pre-made styles.
        Using one of the pre-made style sets of the `symbolX`, `borderX`, `colorX` and `length` options.
        You can set any of those options yourself, which will take precedence over the pre-definded value, to further customize the appearance of the progress bar.
        
        The following style presets are available:
        
        | style | preview |
        | ----- | ------- |
        | `default` | ![](images/progress_bar_default.png) |
        | `largediv` | ![](images/progress_bar_largediv.png) |
        | `tricolor` | ![](images/progress_bar_tricolor.png) |
        | `default_shaded` | ![](images/progress_bar_default_shaded.png) |
        | `largediv_shaded` | ![](images/progress_bar_largediv_shaded.png) |
        | `tricolor_shaded` | ![](images/progress_bar_tricolor_shaded.png) |
        | `hearts` | ![](images/progress_bar_hearts.png) |
        
        Shaded variants only work for Minecraft 1.16 or later.
    
    * ##### `length`
    
        Length of the progress bar (number of symbols the progress bar is made up of).
    
    * ##### `textCenter`
    
        Text to be displayed on the center of the progress bar. This is optional. If specified
        it will replace some of the symbols at the middle of the progress bar. You can use it
        e.g. to display the progress percentage or to display the underlying value of the progress
        bar. The special placeholders `${progress_percentage}`, `${progress_value}`,
        `${progress_min}` and `${progress_max}` can be used to access the percentage
        and value of the progress as well as the minimum and maximum value.
        This should not contain color codes. The text is colored with colors provided by the
        colorCompleted, colorRemaining and other color options.
        
        _Example:_
        ![](images/progress_bar_centertext.png)
    
    * ##### `colorCompleted`
    
        Color to use for completed progress.
    
    * ##### `colorRemaining`
    
        Color to use for remaining progress.
    
    ##### Advanced options
    These options allow you to completely customize the appearance of a progress bar.
    
    * ##### `symbolCompleted`
    
        Symbol (or text) to be used for completed progress. This should not contain color codes.
        Color codes should be added using the colorCompleted option (or related options).
    
    * ##### `symbolRemaining`
    
        Symbol (or text) to be used for remaining progress. This should not contain color codes.
        Color codes should be added using the colorRemaining option (or related options).
    
    * ##### `symbolCurrent`
    
        Symbol (or text) to be used for current progress (head of the progress bar). This should not contain color codes.
        Color codes should be added using the colorCurrent option (or related options).
    
    * ##### `symbolCurrentSteps`
    
        List of symbols (or text) to be used for current progress. By providing multiple symbols
        the progress can be divided in smaller steps. E.g. providing a half filled heart and a
        filled heart will display the half filled heart as an in between step to displaying the
        filled heart.
        This should not contain color codes. Color codes should be added using the
        colorCurrent option (or related options).
        This option is mutually exclusive with symbolCurrent.
        
        _Example:_
        ```yaml
        symbolCurrentSteps: ["\u25CC", "\u25D0"]
        ```
    
    * ##### `borderLeft`
    
        Left border of the progress bar. Does not count towards length.
    
    * ##### `borderRight`
    
        Right border of the progress bar. Does not count towards length.
    
    * ##### `textCenterEmpty`
    
        Text to be displayed on the center of the progress bar when it is empty, i.e. the
        progress is 0.
    
    * ##### `textCenterFull`
    
        Text to be displayed on the center of the progress bar when it is full, i.e. the
        progress is 100.
    
    * ##### `colorCompletedSteps`
    
        Specifies the color to use for completed progress. Divides the progress bar into multiple
        segments with different color. The number is the percentage where the color is first used.
        E.g. if there are two entries `i: c1` and `j: c2` then the color c1 ist used in the
        interval from i to j - 1.
        This option is mutually exclusive with colorCompleted.
        
        _Example:_
        ```yaml
        colorCompletedSteps:
          0: "&a"
          60: "&e"
          80: "&c"
        ```
    
    * ##### `colorCompletedInterpolateSteps`
    
        If enabled the color for completed progress is interpolated between individual progress points specified by colorCompletedSteps.
        This can only be used in conjunction with colorCompletedSteps and thus is mutually
        exclusive to colorCompleted.
        This option only works on Minecraft 1.16+.
    
    * ##### `colorCurrent`
    
        Color to use for current progress, i.e. the symbol that is the head of the progress bar.
        This is optional. If not set it defaults to the value of colorCompleted.
    
    * ##### `colorCurrentInterpolate`
    
        If enable the color to use for current progress, i.e. the symbol that is the head of the
        progress bar, is interpolated between the color used for remaining progress and the color
        used for completed progress.
        This option is mutually exclusive to colorCurrent.
        This option only works on Minecraft 1.16+.
    
    * ##### `colorRemainingSteps`
    
        Specifies the color to use for remaining progress. Divides the progress bar into multiple
        segments with different color. The number is the percentage where the color is first used.
        E.g. if there are two entries `i: c1` and `j: c2` then the color c1 ist used in the
        interval from i + 1 to j.
        To specify the color for remaining progress there are
        three options with are mutually exclusive:
        - `colorRemaining`
        - `colorRemainingSteps` and `colorRemainingInterpolateSteps`
        - `colorRemainingFromColorCompleted`
    
    * ##### `colorRemainingInterpolateSteps`
    
        If enabled the color for remaining progress is interpolated between individual progress points specified by colorRemainingSteps.
        This can only be used in conjunction with colorRemainingSteps and thus is mutually
        exclusive to colorRemaining.
        This option only works on Minecraft 1.16+.
    
    * ##### `colorRemainingFromColorCompleted`
    
        If enabled the color for remaining progress is computed as a dark version of the color for completed progress.
        This option only works on Minecraft 1.16+.
    
    * ##### `colorEmptyBar`
    
        Color to use for the bar when it is empty, i.e. the progress is 0. This is optional.
        If not set it defaults to the color used for remaining progress.
    
    * ##### `colorFullBar`
    
        Color to use for the bar when it is full, i.e. the progress is 100. This is optional.
        If not set it defaults to the color used for completed progress.
    
    * ##### `emptyBarShowSymbols`
    
        Whether the progress symbols are shown if the bar is empty. If this is set to false the
        symbols will be replaced with spaces.
    
    * ##### `fullBarShowSymbols`
    
        Whether the progress symbols are shown if the bar is full. If this is set to false the
        symbols will be replaced with spaces.
    
    * ##### `emptyBar`
    
        Text to replace the entire progress bar with, if it is empty i.e. the progress is 0.
        This is optional. If used this text will be shown instead of the entire bar
        (including the border) when the progress is 0.
    
    * ##### `fullBar`
    
        Text to replace the entire progress bar with, if it is full i.e. the progress is 100.
        This is optional. If used this text will be shown instead of the entire bar
        (including the border) when the progress is 100.
   
### Useful Custom Placeholders

In the following you will find several useful custom placeholders which you can add to your own configuration.

#### The `${afk_tag}` Placeholder

The `${afk_tag}` custom placeholder created by the following code can be used to display whether a player is afk.

```yaml
customPlaceholders:
  # ...
  afk_tag:
    !conditional
    condition: ${player essentials_afk}
    true: "&7|&oaway"
    false: ""
```

The `${afk_tag}` custom placeholder works as follows:
1. The condition is evaluated to determine whether the player is afk.
2. The custom placeholder is replaced with the text specified by either the `true` or the `false` option, depending on whether condition is fulfilled.

After adding the code of the `afk_tag` placeholder to the `customPlaceholders` section of your config, you can use it by adding `${afk_tag}` to the `playerComponent` option, in the following example shown for displaying players using the `!players` component:
```yaml
- !players
  # ...
  playerComponent: "${player name}${afk_tag}"
```

##### Changing the Text

Now if we want to display `&7|&oAFK` instead of `&7|&oaway` to identify AFK players we can do that by changing the `true` option of the `afk_tag` custom placeholder:
```yaml
customPlaceholders:
  # ...
  afk_tag:
    !conditional
    condition: ${player essentials_afk}
    true: "&7|&oAFK"
    false: ""
```

##### Using a Different AFK Plugin

Let's assume you're not using Essentials but CMI to provide the AFK functionality.
Now there's no built-in placeholder for CMI, however we can use the one provided by PlaceholderAPI (assuming it's installed).
However the `cmi_user_afk` placeholder from PlaceholderAPI has one small problem.
It doesn't evaluate to `true` or `false` like the `essentials_afk` placeholder does.
Instead, it evaluates to `§6True` if the player is AFK.
As you can see it's uppercase and there's a color code.
This is good if you want to display the placeholder just like that, but it doesn't work well with the Custom Placeholder mechanic.
To _fix_ this issue we can change the condition to check if the output of the `cmi_user_afk` placeholder is `§6True`. This leads to the following code:

```yaml
customPlaceholders:
  # ...
  afk_tag:
    !conditional
    condition: ${player cmi_user_afk} == "§6True"
    true: "&7|&oaway"
    false: ""
```

#### Adding a `${vanish_suffix}` Placeholder

The `${vanish_suffix}` custom placeholder works similar to the `${afk_tag}` custom placeholder and can be used to add a suffix to all vanished players, such that staff who can see other vanished players can tell who is vanished.

```yaml
customPlaceholders:
  vanish_suffix:
    !conditional
    condition: ${player is_hidden}
    true: "&b|v"
    false: ""
```

Using the `${player is_hidden}` placeholder in the condition makes this custom placeholder work with all vanish plugins supported by !!name.
Have a look at the [Hidden Players](Hidden-Players) page for more information on vanish support.

[!]: ifBTLP
#### Creating the `${server_state}` Placeholder to Display Whether a Server is Online

Now we want to leverage the Custom Placeholder mechanic to display whether a server is online or offline.
For that purpose we use the `${server online}` placeholder as condition.
It will be true if the server is online and false otherwise.

```yaml
customPlaceholders:
  # ...
  server_state:
    !conditional
    parameters: 1
    condition: ${server:%0 online}
    true: "&aOnline"
    false: "&cOffline"
```

We use the `server_state` placeholder created by the above code to display whether a specific server is online by using `${server_state <server>}` somewhere in the config, where `<server>` needs to be replaced with an actual server name.
E.g. if you want to show whether the `survival` server is online use `${server_state survival}`.

##### Alternative Definition of the `${server_state}` Placeholder

There are several ways to create a custom placeholder to display whether a server is online.
In the following we have a look at an alternative that can also be used in the `serverHeader` of the `!players_by_server` component.
To make that possible the parameter is used slightly differently:

```yaml
customPlaceholders:
  # ...
  server_state:
    !conditional
    parameters: 1
    condition: ${%0 online}
    true: "&aOnline"
    false: "&cOffline"
```

If we want to display whether a specific server is online using that definition we need to use `${server_state server:<server>}`.
E.g. when displaying whether the `survival` server is online we need to use `${server_state server:survival}`.
As you can see we need to add the `server:` prefix when using the `server_state` placeholder since it is no longer part of the changed custom placeholder definition.

The advantage of this change is that we can now use the `server_state` placeholder in the `serverHeader` option of the `!players_by_server` component using `${server_state server}`.
The following example shows how that works.

![](images/online-state-1.png)
```yaml
components:
- !players_by_server
  playerSet: all_players
  serverHeader:
  - {text: "&e&n${server}", icon: "colors/yellow.png", ping: 0}
  - {text: "${online_state}", icon: "colors/yellow.png", ping: 0}
  - {text: "&e${server_player_count} Players", icon: "colors/yellow.png", ping: 0}
  showServers: ALL
  playerComponent: "${player name}"
  morePlayersComponent: {text: "&7... and &e${other_count} &7others", icon: "colors/gray.png", ping: 0}
```

#### Change the Color of Players on a Different Server - `${other_server_prefix}`

![](images/dynamic-size-config.png)

The above example uses a Custom Placeholder to make player which are not on the same server as the player looking at the tab list appear in gray.

To achieve this we create a custom placeholder.
Its condition compares the server of a player displayed on the tab list with the server of the player looking at the tab list.
If they are the same the condition evaluates to true, and the placeholder is replaced with the white color code set as the `true` option.
Otherwise the condition evaluated to false, and the placeholder is replaced with the content of the `false` option, in our case a gray color code.

```yaml
customPlaceholders:
  other_server_prefix:
    !conditional
    condition: ${viewer server} == ${player server}
    true: "&f"
    false: "&7"
```

Then we add the `${other_server_prefix}` placeholder in the `playerComponent` option as a prefix to the player's name.
```yaml
playerComponent: "${other_server_prefix}${player name}"
```

You can find the complete configuration file used in this example at <https://github.com/CodeCrafter47/BungeeTabListPlus/wiki/Examples#global-tab-list-dynamic-size>.

[!]: endIF

#### The `${viewer_colored_ping}` Placeholder

In this example we look at how we can add a color code to the ping depending on how good it is.
The following table shows the desired color scheme:

| Ping | Color |
| ---- | ----- |
| 0 to 49 | Green |
| 50 to 149 | Yellow |
| 150 and above | Red |

Now we have three cases, but using a single conditional placeholder we can only distinguish two cases.
We solve this problem by using two conditional placeholders.

The first placeholder `viewer_colored_ping0` will check whether the ping is less than 50 and then color it either green or yellow:
```yaml
customPlaceholders:
  viewer_colored_ping0:
    !conditional
    condition: ${viewer ping} < 50
    true: "&a${viewer ping}"
    false: "&e${viewer ping}"
```

The second placeholder `viewer_colored_ping` will check if the ping is less than 150. If so it'll let the first placeholder do its job, otherwise it'll color the ping in red.
```yaml
  viewer_colored_ping:
    !conditional
    condition: ${viewer ping} < 150
    true: ${viewer_colored_ping0}
    false: "&c${viewer ping}"
```

Now the second placeholder can be used in the config to display the ping in different colors:
```yaml
- "&cPing: ${viewer_colored_ping}ms"
```

##### Create a Generalized Version using Parameters

![](images/example_ping.png)

The `${viewer_colored_ping}` we just created always displays the ping of the player looking at the tab list.
Here we'll look at how we can generalize it so we can also use it do display the ping of players displayed on the tab list.
For the purpose we add a parameter to our custom placeholder.
This can be done by just telling the plugin that this placeholder has one parameter.

```yaml
customPlaceholders:
  colored_ping0:
    !conditional
    parameters: 1
    condition: ${%0 ping} < 50
    true: "&a${%0 ping}"
    false: "&e${%0 ping}"
  colored_ping:
    !conditional
    parameters: 1
    condition: ${%0 ping} < 150
    true: ${colored_ping0 %0}
    false: "&c${%0 ping}"
```

If we use that placeholder we have to specify a parameter.
So if we use it as `${colored_ping viewer}` then `viewer` is the parameter and the plugin will replace all the `%0` in the placeholder definition with `viewer`.
Thus we can see that `${colored_ping viewer}` is exactly the same as the `${viewer_colored_ping}` placeholder from the previous section.

In the above example `${colored_ping viewer}` to display the ping in the header:
```yaml
header:
- "&cWelcome &f${viewer name} &6| &fPing: ${colored_ping viewer}"
```

To display the ping of the players on the tab list we use `player` as parameter:
```yaml
playerComponent: "${player name} ${colored_ping player}"
```

#### Creating Custom Prefixes - `${custom_prefix}`

In this example we use the `!switch` custom placeholder type, to create custom prefixes different to the ones from your permission plugin for use in the tab list.

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

Then you can use the following placeholders:

| Placeholder                     | Description                                                           |
| ------------------------------- | --------------------------------------------------------------------- |
| `${custom_prefix viewer}` | Prefix of the player viewing the tab list.                                  |
| `${custom_prefix player}` | Prefix of a player listed in the tab list. For use in the `playerComponent` |

To display the custom prefix for each player in the tab list add the `${custom_prefix player}` custom placeholder before the name:
```yaml
playerComponent: "${custom_prefix player}${player name}"
```

[!]: ifBTLP

#### Custom Names for Servers - `${server_display_name}`

Here is a brief explanation how to use the _Custom Placeholder_ mechanism to change the
displayed server names.

##### Step 1:

First you need to add the code for the `server_display_name` custom placeholder to your
`config.yml`. The replacements section is the part that you want to edit. There the
custom display names for your servers are defined.

```yaml
customPlaceholders:
  server_display_name:
    !switch
    parameters: 1
    expression: "${%0}"
    replacements:
      "creative": "Creative"
      "survival": "Survival"
      "factions": "Factions"
      "sg0": "Minigames"
      "sg1": "Minigames"
      "hidenseek": "Minigames"
      "lobby0": "Lobby"
      "lobby1": "Lobby"
    defaultReplacement: "${%0}"
```

The above code makes the following new placeholders available for use in your config file:

| Placeholder                     | Description                                 |
| ------------------------------- | ------------------------------------------- |
| `${server_display_name viewer server}` | Display name of the server of the player viewing the tab list. |
| `${server_display_name player server}` | Display name of the server of a player listed in the tab list. For use in the `playerComponent` |
| `${server_display_name server}`        | Display name of the server for use in the `serverHeader` of the _Players by Server_ component. |
| `${server_display_name server:lobby}`  | Display name of a specific server.               |

*Note:* If you place the custom placeholder code in `config.yml` then it is available to all tab 
lists. You can alternatively place it in the config file of a specific tab list. Then it is only
available to that one.

##### Step 2:

Now you need to go through your tab list configuration files (files in the `tabLists` folder) and
replace all placeholders that display the server name with placeholders that display the server
alias.

Here'a a table of where in the file to look and which placeholders to replace with which:

| Where                                                | Look for         | Replace with                           |
| ---------------------------------------------------- | ------------------ | -------------------------------------- |
| `header`, `footer`, custom text in `components`      | `${viewer server}` | `${server_display_name viewer server}` |
| `serverHeader` in the `!players_by_server` component | `${server}`        | `${server_display_name server}`        |

*Note:* Do not blindly put the `server_display_name` placeholder everywhere. Do not use the in the 
`showTo`, `playerSets` and `customPlaceholders` sections of the config. While technically you can
use it there, it is probably not what you want.

#### Creating Server Specific Prefixes - `${server_prefix}`

Here is a brief explanation how to use the _Custom Placeholder_ mechanism to create a
server prefix placeholder:

To do so make the following changes to `config.yml`:

```yaml
customPlaceholders:
  server_prefix:
    !switch
    parameters: 1
    expression: "${%0}"
    replacements:
      "creative": "[C]"
      "survival": "[S]"
      "factions": "[F]"
    defaultReplacement: ""
```

**Note:** If you place the custom placeholder code in config.yml then it is available to all tab lists. You can also place it in the config file of a specific tab list. Then it is only available to that one.

Then you can use the following placeholders:

| Placeholder                     | Description                                 |
| ------------------------------- | ------------------------------------------- |
| `${server_prefix viewer server}` | Prefix of the server of the player viewing the tab list. |
| `${server_prefix player server}` | Prefix of the server of a player listed in the tab list. For use in the `playerComponent` |
| `${server_prefix server}`        | Prefix of the server for use in the `serverHeader` of the _Players by Server_ component. |
| `${server_prefix server:lobby}`  | Prefix of a specific server.               |

#### `${animated_bars}`

The following example creates a `${animated_bars}` placeholder that can be used anywhere on the tab list.

```yaml
customPlaceholders:
  animated_bars:
    !animated
    interval: 0.2
    elements:
    - "&6&c=&6=============="
    - "&6=&c=&6============="
    - "&6==&c=&6============"
    - "&6===&c=&6==========="
    - "&6====&c=&6=========="
    - "&6=====&c=&6========="
    - "&6======&c=&6========"
    - "&6=======&c=&6======="
    - "&6========&c=&6======"
    - "&6=========&c=&6====="
    - "&6==========&c=&6===="
    - "&6===========&c=&6==="
    - "&6============&c=&6=="
    - "&6=============&c=&6="
    - "&6==============&c=&6"
```

#### `${animated_color_prefix}`

Another use case for the `!animated` custom placeholder type is creating a color prefix that changes every second.
The following example creates a `${animated_color_prefix}` which you can put in front of player names, or any other place, to make the text continuously change its color.
```yaml
customPlaceholders:
  animated_color_prefix:
    !animated
    interval: 1.0
    randomize: true
    elements:
    - "&9"
    - "&b"
    - "&a"
    - "&e"
    - "&6"
    - "&c"
    - "&d"
    - "&5"
```

#### Rainbow Animation

The `!color_animation` custom placeholder type can be used to create animated rainbow-like effects.
In the following example we create the `my_rainbow` placeholder.
The custom placeholder specifies the colors to use.
The text is specified when using the placeholder.
That way we can apply the effect at multiple places once we've defined the custom placeholder.
```yaml
customPlaceholders:
  my_rainbow:
    !color_animation
    colors: ['#FF0000', '#FFA500', '#FFFF00', '#32CD32', '#00BFFF', '#8A2BE2', '#EE82EE']
```

The above code creates the `${my_rainbow <text>}` placeholder.
When using that placeholder we have to replace `<text>` with the text we want to apply the effect to.
E.g. `${my_rainbow Animated Rainbow Text}` will result in ![](images/color_animation_rainbow.png).

#### Static Color Gradients

We can also use the `!color_animation` custom placeholder type to create static color gradients.
The following example creates the `gradient_blue_white` placeholder which applies a simple color gradient.
We set the `speed` option to `0` to create a static effect.
```yaml
customPlaceholders:
  gradient_blue_white:
    !color_animation
    colors: ['#00FFFF', '#FFFFFF']
    speed: 0
```

The above code creates the `${gradient_blue_white <text>}` placeholder.
When using that placeholder we have to replace `<text>` with the text we want to apply the effect to.
E.g. `${gradient_blue_white static gradient}` will result in ![](images/color_animation_static.png).