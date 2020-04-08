The header and footer are configured in the tab list configuration file. 
 Remember these are the `.yml` files in the `tabLists` directory. By default you
 only have the `tabLists/default.yml` file.

The part of the file controlling the header and footer looks like this:
```yaml
showHeaderFooter: true
header:
- '&cWelcome &f${viewer name}'
- '&eW&celcome &f${viewer name}'
- '&eWe&clcome &f${viewer name}'
- '&eWel&ccome &f${viewer name}'
- '&eWelc&come &f${viewer name}'
- '&eWelco&cme &f${viewer name}'
- '&eWelcom&ce &f${viewer name}'
- '&eWelcome &f${viewer name}'
- '&cW&eelcome &f${viewer name}'
- '&cWe&elcome &f${viewer name}'
- '&cWel&ecome &f${viewer name}'
- '&cWelc&eome &f${viewer name}'
- '&cWelco&eme &f${viewer name}'
- '&cWelcom&ee &f${viewer name}'
- '&cWelcome &f${viewer name}'
headerAnimationUpdateInterval: 0.2
footer:
- |-
  &6Line 1
  &eLine 2
- |-
  &eLine 1
  &6Line 2
footerAnimationUpdateInterval: 0.5
```

The `showHeaderFooter` is used to enable or disable the header and footer. You
 may want to disable it if you are using a bukkit plugin to provide the header
 and footer.

The `header` and `footer` options contain the actual text to use for the header
 and footer. You can use [Formatting codes](http://minecraft.gamepedia.com/Formatting_codes) 
 using the `§` or the `&` sign. For all [Placeholders](Placeholders) you must
 use the `viewer` variant of the placeholder.

The `headerAnimationUpdateInterval` and `footerAnimationUpdateInterval` control
 the interval at which the plugin switches through the list of texts if you
 provide multiple texts for the header or the footer. This can be used to create
 an animation.

### Simple not animated header and footer

Here's how to create a simple not animated header and footer.

```yaml
showHeaderFooter: true
header:
- '&cWelcome &f${viewer name}' # The header text
headerAnimationUpdateInterval: 0.2 # Ignore this, there's no animation
footer:
- '&f&nPowered by BungeeTabListPlus' # The footer text
footerAnimationUpdateInterval: 0.5 # Ignore this, there's no animation
```

### Multiline header and footer

You can create a multiline header and footer like that:

```yaml
showHeaderFooter: true
header: # The header text:
- |-
  &cWelcome &f${viewer name}
  &bto yourserver.example.com
headerAnimationUpdateInterval: 0.2 # Ignore this, there's no animation
footer: # The footer text:
- |-
  &6Line 1
  &eLine 2
footerAnimationUpdateInterval: 0.5 # Ignore this, there's no animation
```

### Animated header and footer

And here's how it looks with an animation:

```yaml
showHeaderFooter: true
header:
- '&cWelcome &f${viewer name}'
- '&eW&celcome &f${viewer name}'
- '&eWe&clcome &f${viewer name}'
- '&eWel&ccome &f${viewer name}'
- '&eWelc&come &f${viewer name}'
- '&eWelco&cme &f${viewer name}'
- '&eWelcom&ce &f${viewer name}'
- '&eWelcome &f${viewer name}'
- '&cW&eelcome &f${viewer name}'
- '&cWe&elcome &f${viewer name}'
- '&cWel&ecome &f${viewer name}'
- '&cWelc&eome &f${viewer name}'
- '&cWelco&eme &f${viewer name}'
- '&cWelcom&ee &f${viewer name}'
- '&cWelcome &f${viewer name}'
headerAnimationUpdateInterval: 0.2
footer:
- |-
  &6Line 1
  &eLine 2
- |-
  &eLine 1
  &6Line 2
footerAnimationUpdateInterval: 0.5
```

The `headerAnimationUpdateInterval` controls after how many seconds (here 0.2)
 the next text is displayed. Some goes for the footer.

--------------------------------------------------------------------------------

Next: [Configuration Basics Part 4 - Player sets](Configuration-Basics-Part-4---Player-sets)