When creating animation you have two choices:
Use the `!animated` custom placeholder or the `!animated` component.
While the custom placeholder can only create animated text, using the `!animated` component allows you to change the icon and ping at the same time.

### The `!animated` Custom Placeholder

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

### The `!animated` Component

While the custom placeholder is great for creating fast paced text animations, the `!animated` component comes with the advantage of being able to not only animate text but also change the icon and ping of a slot.
However, we recommend against changing the icon in fast animations, as the client always requires some time to update the icon.

In the following example we use the `!animated` component to cycle through displaying different stats:

![](images/animation-2.gif)
```yaml
- !animated
  interval: 1.5
  components:
  - {text: "&cBalance: &6${viewer vault_balance 1.2}", icon: "default/balance.png", ping: 0}
  - {text: "&cRank: &6${viewer vault_primary_group}", icon: "default/rank.png", ping: 0}
  - {text: "&cPing: ${viewer_colored_ping}ms", icon: "default/ping.png", ping: 0}
```