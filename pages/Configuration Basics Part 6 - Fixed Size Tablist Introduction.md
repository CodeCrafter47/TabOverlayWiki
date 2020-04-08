This page discusses the fixed size tab list. To create a fixed size tab list the
 `type` option in the tab list configuration file must be set to `FIXED_SIZE`.
 
--------------------------------------------------------------------------------

### Simple example

![](images/fixed-size-1.png)

```yaml
showTo: all
priority: 1

showHeaderFooter: false

playerSets: {} # none yet

type: FIXED_SIZE

size: 80

defaultIcon: colors/black.png
defaultPing: 1000

components:
- 'Slot 1'
- 'Slot 2'
- 'Slot 3'
- 'Slot 4'
- 'Slot 5'
- 'Slot 6'
- 'Slot 7'
- 'Slot 8'
- 'Slot 9'
- 'Slot 10'
```

The size options controls the size of the tab list. Here are some common values:

| Size | Columns | Rows |
| ---- | ------- | ---- |
| 20   | 1       | 20   |
| 30   | 2       | 15   |
| 40   | 2       | 20   |
| 60   | 3       | 20   |
| 80   | 4       | 20   |

Note a size greater than 80 won't work on Minecraft 1.8 and later. For Minecraft
 1.7 and before the size in the tab list configuration file must match the
 size configured in BungeeCord's config.yml.

The `defaultIcon` and `defaultPing` option are used to configure the icon and
 ping to use for empty slots, and custom slots for which no different icon is
 specified. More on icons and ping will be explained later.

You can try adding more custom slots or changing the size of the tab list by
 yourself now.
 
--------------------------------------------------------------------------------

### Using colors and placeholders in custom slots

You can use [Formatting codes](http://minecraft.gamepedia.com/Formatting_codes) 
 using the `§` or the `&` sign. For all player bound [Placeholders](Placeholders) you must
 use the `viewer` variant of the placeholder.

Example:

![](images/fixed-size-2.png)

```yaml
showTo: all
priority: 1

showHeaderFooter: false

playerSets:
  all_players: all

type: FIXED_SIZE

size: 80

defaultIcon: colors/black.png
defaultPing: 1000

components:
- '&aGreen'
- '&bBlue'
- '&cRed'
- '&eYellow'
- 'Players: ${playerset:all_players size}'
- 'Ping: ${viewer ping}'
- 'Server: ${viewer server}'
```

In this example the use of color codes has been demonstrated, a player set was
 used to display a player count in a custom slot, and placeholders were used to
 display ping and server of the player.
 
--------------------------------------------------------------------------------

### Changing ping and icon of a custom slot

In the previous example we used
```yaml
- '&aGreen'
```
to create a custom slot. The above is actually a short form for
```yaml
- {text: '&aGreen'}
```
The long form has the advantage that it allows to change the icon and ping
 of the slot too: 
```yaml
- {text: '&aGreen', icon: 'colors/green.png', ping: 100}
```

Now let's have a look at how we can improve the above example using that
 knowledge:

![](images/fixed-size-3.png)

```yaml
showTo: all
priority: 1

showHeaderFooter: false

playerSets:
  all_players: all

type: FIXED_SIZE

size: 80

defaultIcon: colors/black.png
defaultPing: 1000

components:
- {text: '&aGreen', icon: 'colors/green.png'}
- {text: '&bBlue', icon: 'colors/aqua.png'}
- {text: '&cRed', icon: 'colors/red.png'}
- {text: '&eYellow', icon: 'colors/yellow.png'}
- 'Players: ${playerset:all_players size}'
- {text: 'Ping: ${viewer ping}', ping: '${viewer ping}'}
- {text: 'Server: ${viewer server}', icon: 'default/server.png', ping: 0}
```

You can set the icon property to one of the following:

1. The name of a 8x8 pixel .png file you saved in the heads folder, e.g. `colors/blue.png`

2. A player name or uuid. You can use a name which doesn't belong to player to save bandwidth/ see random skins. See <http://www.reddit.com/r/MinecraftHeads/comments/1m1s0g/official_heads_made_by_mojang_marc/> for cool skins/heads.

The ping value represents the ping in milliseconds. Here's a table of all
 values:
 
| Value     | Description          | Image                         |
| --------- | -------------------- | ----------------------------- |
| < 0       | crossed out ping bar | ![](images/ping_bar_-1.png)   |
| 0 - 149   | five bars            | ![](images/ping_bar_0.png)    |
| 150 - 299 | four bars            | ![](images/ping_bar_150.png)  |
| 300 - 599 | three bars           | ![](images/ping_bar_300.png)  |
| 600 - 999 | two bars             | ![](images/ping_bar_600.png)  |
| > 1000    | one bar              | ![](images/ping_bar_1000.png) |
 
--------------------------------------------------------------------------------

### Text alignment

Besides _text_, _icon_ and _ping_ there's a fourth property we can customize
 for a custom slot: The _alignment_ property. Here's a small example showing
 what it does:

![](images/fixed-size-4.png)

```yaml
showTo: all
priority: 1

showHeaderFooter: false

playerSets:
  all_players: all

type: FIXED_SIZE

size: 80

defaultIcon: colors/black.png
defaultPing: 1000

components:
- {text: 'Slot 1', alignment: LEFT}
- {text: 'Slot 2', alignment: CENTER}
- {text: 'Slot 3', alignment: CENTER}
- {text: 'Slot 4', alignment: RIGHT}
```

--------------------------------------------------------------------------------

Next: [Configuration Basics Part 7 - Fixed Size Tablist - Adding Players](Configuration-Basics-Part-7---Fixed-Size-Tablist---Adding-Players)