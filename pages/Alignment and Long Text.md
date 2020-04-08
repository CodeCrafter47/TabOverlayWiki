Having read [Configuration Basics Part 6: Fixed Size Tablist - Introduction](Configuration-Basics-Part-6---Fixed-Size-Tablist-Introduction) you know that you can tell the plugin to align text to the left, to the center or to the right. This page explains how it works and also how to automatically cut off too long text (e.g. long player names).

--------------------------------------------------------------------------------

### Text Alignment

The wiki page linked above provides the following example:

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

While the example image looks quite nice, the alignment option doesn't work that well for everyone. To understand why, we must take a look at how it works internally:

When you configure a slot with alignment set to `CENTER` or `RIGHT` then the plugin will add some spaces in front of the text to move it a bit to the right. To correctly calculate the number of spaces required the plugin would need to know the size of a slot on the clients tab list, which depends on the width and height of the player's screen, which unfortunately we do not know. Since the plugin doesn't know the _real_ size of a slot it instead uses the size a slot has when not changing the size of the Minecraft window after start.

Unfortunately this means that the alignments will look out of place for some of your players. While default values work well for a lot of players, they don't fit everyone.

--------------------------------------------------------------------------------

### Cutting Off Long Text

It is possible for long text to be cut off. For this purpose there's the `longText` option. It can be applied in two ways: Either set it globally to apply to every slot, or only for some slots.

The below example cuts of long text for all slots and appends 3 dots if that happened.

![](images/crop_1.png)
```yaml
showTo: "true"
priority: 1

showHeaderFooter: false

playerSets:
  all_players: "all"

# cut off long text and append 3 dots
longText: CROP_3DOTS

type: FIXED_SIZE

size: 80

defaultIcon: colors/black.png
defaultPing: 1000

components:
-
- {text: '&bWelcome', alignment: RIGHT}
- '${viewer vault_prefix}&b${viewer name}'
-
- !players
  playerSet: all_players
  playerComponent: "${player vault_prefix}${player name}"
  morePlayersComponent: '... and ${other_count} others'
```

The alternative is to only apply the `longText` option to a specific slot, in the following example to all player slots.

![](images/crop_2.png)
```yaml
showTo: "true"
priority: 1

showHeaderFooter: false

playerSets:
  all_players: "all"

type: FIXED_SIZE

size: 80

defaultIcon: colors/black.png
defaultPing: 1000

components:
-
- {text: '&bWelcome', alignment: RIGHT}
- '${viewer vault_prefix}&b${viewer name}'
-
- !players
  playerSet: all_players
  # only cut off long text for player names
  playerComponent: {text: "${player vault_prefix}${player name}", longText: CROP_3DOTS}
  morePlayersComponent: '... and ${other_count} others'
```

Now here's a table with the different values you can use for the `longText` option:

| Value         | Result      |
| ------------- | ----------- |
| `DISPLAY_ALL` | ![](images/long-text-display.png)
| `CROP`        | ![](images/long-text-crop.png)
| `CROP_2DOTS`  | ![](images/long-text-2dots.png)
| `CROP_3DOTS`  | ![](images/long-text-3dots.png)

The default (if you don't set the option) is `DISPLAY_ALL`.

In the future other options (like scrolling) might be added. Feel free to create an issue here on GitHub if you're interested and/or have any ideas of your own.

Note that when cutting of long texts you might face similar problems as when using the alignment option described above. Since the plugin doesn't know the _real_ size of a slot (because it depends on the width and height of the client window) it assumes some default values which will look fine for most player, but for some the text may still run over the end of the slot and for some it'll look like the text  is cut of even though there still is plenty of space available. 