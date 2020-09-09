Specifying the order of players on the tab list is done using the `playerOrder` option.
This option is available in the `DYNAMIC_SIZE` tab list type.
When using the `FIXED_SIZE` tab list type all components which insert players to the tab list allow for setting the `playerOrder` option.

### Content
[!]: ToC

### Examples
We start by looking at some examples:

**Example 1:** Order players alphabetically
```yaml
- !players
  playerSet: all_players
  playerOrder: "name asc"
  # ...
```

The `playerOrder` option is set to the comparison rule to use.

**Example 2:** Order players by permission rank and players of the same rank alphabetically
```yaml
- !players
  playerSet: all_players
  playerOrder: "vault_primary_group_weight asc, name asc"
  # ...
```

The `,` operator can be used to chain as many different comparison rules as you like.

### Construction of Comparison Rules

In the previous example we have seen that the value of the `playerOrder` option is either a comparison rule or a sequence comparison rules separated by a comma.
A comparison rule is a _placeholder name_ followed by an optional _type_ and an optional _direction_.
It looks like this: `placeholder_name [as type] [direction]`. The square brackets indicate optional parts.

The _placeholder name_ is just the placeholder without the dollar sign, curly brackets, percent signs or the player/ viewer prefix.
You can use any built-in player-bound placeholder, placeholders provided by PlaceholderAPI and player-bound placeholder registered through the API.

The _type_ can be either `text` or `number`.
You specify it by adding `as text` or `as number` after the _placeholder name_.
For the built-in placeholders the plugin will automatically use the correct type, however when using placeholder from PlaceholderAPI it might be necessary to specify the type.
By default placeholders from PlaceholderAPI are interpreted as `text`, in which case `2` would be larger than `10`.
So if you use placeholders from PlaceholderAPI which you know to be numbers, you should add the `as number`, so that the plugin sorts the players correctly.

The _direction_ can be one of three values:
 * `asc`, which is short for ascending. This leads to the order `a, b, c, ...` or `1, 2, 10, ...`. This is the default direction if you do not specify any.
 * `desc`, which is short for descending. This leads to the order `z, y, x, ... a` or `50, 20, 15, ...`.
 * `viewer-first`. This special "direction" causes players for whom the placeholder has the same value as for the viewer (player looking at the tab list) to appear before players for whom the placeholder has a different value.
 * `custom`, which allows you to specify a custom order. The way to use it is to write the values of the placeholder separated by a space after the `custom` keyword, in the order you want them to appear in.
 
    E.g. assume you want to order players by their group. You use the `vault_primary_group` placeholder. You have three groups: `Admin`, `Moderator` and `Default` which you want to appear in that order. The resulting comparison rule is `vault_primary_group custom Admin Moderator Default`.

### Useful Values for `playerOrder`

In theory you can use any placeholder to sort players by simply putting down its name followed by `asc` or `desc`, but to make your life easier here's a list of some useful ones.

[!]: ifBTLP
| Comparison Rule                     | Description                                                                                |
| ------------------------ |------------------------------------------------------------------------------------------- |
| `name` or `name asc`         | will fill in the players in an alphabetic order. The `asc` is optional.                                            |
| `name viewer-first`               | will fill in the player that views the tablist first                                       |
| `vault_primary_group_weight asc`         | Sorts players by the weight of their primary group. For most plugins low weight equals a high rank, so this is the one you'll want to use. **Note:** You need to install _BungeeTabListPlus_BukkitBridge.jar_ on your Spigot servers for this to work. |
| `vault_primary_group_weight desc` | Sorts players by the weight of their primary group, but starting with the highest weight going to the lowest.  **Note:** You need to install _BungeeTabListPlus_BukkitBridge.jar_ on your Spigot servers for this to work. |
| `vault_prefix`            | Sorts players by their prefix, alphabetically. You can use this if setting up weights is too complicated for you. **Note:** You need to install _BungeeTabListPlus_BukkitBridge.jar_ on your Spigot servers for this to work. |
| `luckpermsbungee_primary_group_weight desc` | Sorts players by the weight of their primary group - for those of you using LuckPerms installed on BungeeCord. |
| `faction_name viewer-first`           | players which are in the same faction as the player who sees the tablist appear at the top |
| `faction_name asc`               | players by faction alphabetically                                                          |
| `server`              | players by the name of the server they are playing on alphabetically                        |
| `server viewer-first`       | players which are in the same server as the player who sees the tab list appear at the top   |
[!]: endIF

[!]: ifATO
| Rule                     | Description                                                                                |
| ------------------------ |------------------------------------------------------------------------------------------- |
| `name` or `name asc`         | will fill in the players in an alphabetic order. The `asc` is optional.                                            |
| `name viewer-first`               | will fill in the player that views the tablist first                                       |
| `vault_primary_group_weight asc`         | Sorts players by the weight of their primary group. For most plugins low weight equals a high rank, so this is the one you'll want to use. |
| `vault_primary_group_weight desc` | Sorts players by the weight of their primary group, but starting with the highest weight going to the lowest. You need this e.g. for LuckPerms. |
| `vault_prefix`            | Sorts players by their prefix, alphabetically. You can use this is setting up weights is too complicated for you. |
| `faction_name viewer-first`           | players which are in the same faction as the player who sees the tablist appear at the top |
| `faction_name asc`               | players by faction alphabetically                                                          |
| `world`              | players by the name of the world they are playing on alphabetically                        |
| `world viewer-first`       | players which are in the same world as the player who sees the tablist appear at the top   |
[!]: endIF

--------------------------------------------------------------------------------

Next: [Custom Placeholders](Custom-Placeholders)