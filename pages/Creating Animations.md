When creating animation you have two choices:
Use the `!animated` custom placeholder or the `!animated` component.
While the custom placeholder can only create animated text, using the `!animated` component allows you to change the icon and ping at the same time.

### Content
[!]: ToC

### The `!color_animation` Custom Placeholder

The `!color_animation` Custom Placeholder offers an easy way to create a set a predefined effects. It is easier to show than tell, so here is a sample of the different effects that can be created.

![](images/color_animation_example.gif)

The following config has been used to create those effects.
You can use it as a starting point for your own, customizing colors and such.

```yaml
customPlaceholders:
  demo_random:
    !color_animation
    effect: "random"
    colors: ['&8', '&7', '&7']
  demo_wave:
    !color_animation
    effect: wave
    baseColor: "&c"
    effectColor: "&e"
    speed: 4
  demo_wave_backwards:
    !color_animation
    effect: wave
    baseColor: "&c"
    effectColor: "&e"
    speed: -4
  demo_wave_center:
    !color_animation
    effect: waveCenter
    baseColor: "&5"
    effectColor: "&d"
  demo_glitter:
    !color_animation
    effect: glitter
    baseColor: "&6"
    effectColor: "&f"
components:
- ${demo_wave Amazing}
- ${demo_wave_backwards Colorful}
- ${demo_wave_center Beautiful}
- ${demo_glitter Glamorous}
- ${demo_random Nothing to see}
```

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