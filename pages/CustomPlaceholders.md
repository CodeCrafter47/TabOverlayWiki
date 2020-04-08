Custom Placeholders allow implementing complex logic in your tab list.

Custom Placeholders can be configured in config.yml (available for all tab lists) and in each tab list configuration file (only available to the specific tab list).

A Look at The `${afk_tag}` Placeholder
--------------------------------------

Let's start by looking at how the `${afk_tag}` Custom Placeholder from the default configuration works. It is created with the following code:

```yaml
customPlaceholders:
  afk_tag:
    !conditional
    condition: ${player essentials_afk}
    true: "&7|&oaway"
    false: ""
```

The Custom Placeholder definition is made up of different elements.
`afk_tag` is the name of the Custom Placeholder.
`!conditional` is the type of the Custom Placeholder.
Besides `!conditional` there is also the `!switch` type, which we'll learn about later.
Then the three attributes `condition`, `true` and `false` are configured.

The Custom Placeholder works like this:
When you use `${afk_tag}` somewhere in your config, the condition will be evaluated.
In our case the condition is set to `${player essentials_afk}` which is true if the player is afk and false otherwise.
If the condition is true then the placeholder is replaced with the text assigned to the `true` attribute, in our case this is `&7|&oaway`.
Similarly, if the condition is false then the placeholder is replaced with the text assigned to the `false` attribute, nothing in our case.

In the default configuration the `${afk_tag}` placeholder is used like this:
```yaml
- !players
  ...
  playerComponent: "${player name}${afk_tag}"
```

### Changing the Text

Now if we want to display `&7|&oAFK` instead of `&7|&oaway` to identify AFK players we can do that by changing the `true` attribute of the `afk_tag` Custom Placeholder:
```yaml
customPlaceholders:
  afk_tag:
    !conditional
    condition: ${player essentials_afk}
    true: "&7|&oAFK"
    false: ""
```

### Using a Different AFK Plugin

Let's assume you're not using Essentials but CMI to provide the AFK functionality.
Now there's no built-in placeholder for CMI, however we can use the one provided by PlaceholderAPI (assuming it's installed).
However the `cmi_user_afk` placeholder from PlaceholderAPI has one small problem.
It doesn't evaluate to `true` or `false` like the `essentials_afk` placeholder does.
Instead it evaluates to `§6True` if the player is AFK.
As you can see it's uppercase and there's a color code.
This is good if you want to display the placeholder just like that, but it doesn't work well with the Custom Placeholder mechanic.
To _fix_ this issue we can change the condition to check if the output of the `cmi_user_afk` placeholder is `§6True`. This leads to the following code:

```yaml
customPlaceholders:
  afk_tag:
    !conditional
    condition: ${player cmi_user_afk} == "§6True"
    true: "&7|&oaway"
    false: ""
```

Display Whether a Server is Online
----------------------------------

![](images/online-state-1.png)

Now we want to leverage the Custom Placeholder mechanic to display whether a server is online or offline.
For that purpose we use the `${server online}` placeholder as condition.
It will be true if the server is online and false otherwise.

```yaml
customPlaceholders:
  # ...
  online_state:
    !conditional
    condition: ${server online}
    true: "&aOnline"
    false: "&cOffline"
```

We use that placeholder in the `serverHeader` of the `!players_by_server` component:
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

Change the Color of Players on a Different Server
-------------------------------------------------

![](images/dynamic-size-config.png)

The above example uses a Custom Placeholder to make player which are not on the same server as the player looking at the tab list appear in gray.

To this end a custom placeholder is created.
Its condition compares the server ofa player displayed on the tab list with the server of the player looking at the tab list.
If they are the same the condition evaluates to true and the placeholder is replaced with the white color code set as the `true` attribure.
Otherwise the condition evaluated to false and the placeholder is replaced with the content of the `false` attribute, in our case a gray color code.

```yaml
customPlaceholders:
  other_server_prefix:
    !conditional
    condition: '${viewer server} == ${player server}'
    true: '&f'
    false: '&7'
```

The placeholder is then used in the `playerComponent` section before the player's name:
```yaml
playerComponent: "${other_server_prefix}${player name}"
```

You can find the complete configuration file used in this example at <https://github.com/CodeCrafter47/BungeeTabListPlus/wiki/Examples#global-tab-list-dynamic-size>.

Colored Ping
------------

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

### Create a Generalized Version using Parameters

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

Creating Custom Prefixes
------------------------

In this example we'll use the other placeholder type, `!switch`, to create custom prefixes different to the ones from your permission plugin for use in the tab list.

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

To display the custom prefix for each player in the tab list add the Custom Placeholder before the name:
```yaml
playerComponent: "${custom_prefix player}${player name}"
```

Custom Names for Servers
------------------------

Here's a brief explanation how to use the _Custom Placeholder_ mechanism to change the
displayed server names.

### Step 1:

First you need to add the code for the `server_display_name` custom placeholder to your
`config.yml`. The replacements section is the part that you'll want to edit. There the
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

### Step 2:

Now you need to go through your tab list configuration files (files in the `tabLists` folder) and
replace all placeholders that display the server name with placeholders that display the server
alias.

Here'a a table of where in the file to look and which placeholders to replace with which:

| Where                                                | Look for         | Replace with                           |
| ---------------------------------------------------- | ------------------ | -------------------------------------- |
| `header`, `footer`, custom text in `components`      | `${viewer server}` | `${server_display_name viewer server}` |
| `serverHeader` in the `!players_by_server` component | `${server}`        | `${server_display_name server}`        |

*Note:* Don't blindly put the `server_display_name` placeholder everywhere. Don't use the in the 
`showTo`, `playerSets` and `customPlaceholders` sections of the config. While technically you can
use it there, it's probably not what you want.

Server Prefix
-------------

Here's a brief explanation how to use the _Custom Placeholder_ mechanism to create a
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

Calculating Things
------------------

There is a thirds type of custom placeholder: `!compute`.
You can use it to do some basic calculations with placeholders.

Here is an example:
```yaml
customPlaceholders:
  health_percentage:
    !compute
    (${viewer health} / ${viewer max_health}) * 100
```
Then use ${health_percentage} anywhere to display the health.

Animations:
-----------

It is possible to do animations using the `!animated` custom placeholder. The following example creates a `${animated_bars}` placeholder that can be used anywhere on the tab list.

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

Another use case for the `!animated` custom placeholder type is creating a color prefix that changes every second.
The following example creates a `${color_prefix}` which you can put in front of player names, or any other place, to make the text continuously change its color.
```yaml
customPlaceholders:
  color_prefix:
    !animated
    interval: 1.0
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

Creating Aliases:
-----------------

You can use custom placeholders to create simple aliases for commonly used text.
The following example creates a `${bars}` placeholder that will be replaced with `===============` when used somewhere in the tab list.

```yaml
customPlaceholders:
  bars: "&6==============="
```