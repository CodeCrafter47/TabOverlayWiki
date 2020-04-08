
The `!animated` Custom Placeholder
----------------------------------

It is possible to do animations using the `!animated` custom placeholder. The following example creates a `${animated_bars}` placeholder that can be used anywhere on the tab list.

![](images/animation-1.gif)
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

The `!animated` Component
-------------------------

Another way to create animations is using the `!animated` component. It allows to specify an interval and a list of components to cycle through. Here's a simple example:

![](images/animation-1.gif)
```yaml
!animated
interval: 0.2
components:
- {text: "&6&c=&6==============", icon: "colors/gold.png", ping: 0}
- {text: "&6=&c=&6=============", icon: "colors/gold.png", ping: 0}
- {text: "&6==&c=&6============", icon: "colors/gold.png", ping: 0}
- {text: "&6===&c=&6===========", icon: "colors/gold.png", ping: 0}
- {text: "&6====&c=&6==========", icon: "colors/gold.png", ping: 0}
- {text: "&6=====&c=&6=========", icon: "colors/gold.png", ping: 0}
- {text: "&6======&c=&6========", icon: "colors/gold.png", ping: 0}
- {text: "&6=======&c=&6=======", icon: "colors/gold.png", ping: 0}
- {text: "&6========&c=&6======", icon: "colors/gold.png", ping: 0}
- {text: "&6=========&c=&6=====", icon: "colors/gold.png", ping: 0}
- {text: "&6==========&c=&6====", icon: "colors/gold.png", ping: 0}
- {text: "&6===========&c=&6===", icon: "colors/gold.png", ping: 0}
- {text: "&6============&c=&6==", icon: "colors/gold.png", ping: 0}
- {text: "&6=============&c=&6=", icon: "colors/gold.png", ping: 0}
- {text: "&6==============&c=&6", icon: "colors/gold.png", ping: 0}
```

Now here's a complete config so you see how it fits in:

```yaml
showTo: "true"
priority: 1

showHeaderFooter: false

playerSets:
  all_players: "all"

type: FIXED_SIZE

size: 20

defaultIcon: colors/black.png
defaultPing: 1000

components:
- !players
  playerSet: all_players
  playerComponent: "${player name}"
  morePlayersComponent: '... and ${other_count} others'
- !spacer {}
- !animated
  interval: 0.2
  components:
  - {text: "&6&c=&6==============", icon: "colors/gold.png", ping: 0}
  - {text: "&6=&c=&6=============", icon: "colors/gold.png", ping: 0}
  - {text: "&6==&c=&6============", icon: "colors/gold.png", ping: 0}
  - {text: "&6===&c=&6===========", icon: "colors/gold.png", ping: 0}
  - {text: "&6====&c=&6==========", icon: "colors/gold.png", ping: 0}
  - {text: "&6=====&c=&6=========", icon: "colors/gold.png", ping: 0}
  - {text: "&6======&c=&6========", icon: "colors/gold.png", ping: 0}
  - {text: "&6=======&c=&6=======", icon: "colors/gold.png", ping: 0}
  - {text: "&6========&c=&6======", icon: "colors/gold.png", ping: 0}
  - {text: "&6=========&c=&6=====", icon: "colors/gold.png", ping: 0}
  - {text: "&6==========&c=&6====", icon: "colors/gold.png", ping: 0}
  - {text: "&6===========&c=&6===", icon: "colors/gold.png", ping: 0}
  - {text: "&6============&c=&6==", icon: "colors/gold.png", ping: 0}
  - {text: "&6=============&c=&6=", icon: "colors/gold.png", ping: 0}
  - {text: "&6==============&c=&6", icon: "colors/gold.png", ping: 0}
```

Note that you can also change the icon and ping in the animation. However changing the icon is not recommended for fast animations, as the client always requires some time to update the icon.