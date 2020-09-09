A _player set_ is a named subset of your players.
The plugin uses player sets to display players and player counts in the tab list.
Whenever you want to display a player count, or display players on the tab list the first step is to create a player set containing these players.
In the following we will have a look at how to create player sets, and you will see various examples for useful player sets.

### Content
[!]: ToC

### Creating Player Sets
You can create a player set by editing the `playerSets` section in the tab list configuration file.
A simple player set containing all players can be created like this:
 
```yaml
playerSets:
  all_players: all
```

The above line creates a playerSet called `all_players` that contains all players.

Now you could use that player set to display the number of players on your 
 server in the footer of the tab list:
```yaml
footer: "&7Total players:&f ${playerset:all_players size}"
```

As you can see from the example the `${playerset:all_players size}` placeholder
 is used to display the number of players in the player set. This works the
 same for all player sets: The `${playerset:<name> size}` placeholders
 displays the number of players in a particular player set.

[!]: ifATO

#### Player on a Specific World
Let's create a player set that only contains players on a specific world. For
 this example it is assumed that there is a world called `lobby`.
 
```yaml
playerSets:
  all_players: all
  lobby: ${player world} == "lobby"
```

Now that isn't too difficult. Let's create a player set for a `survival`
 world, that also contains players on the `survival_nether` and `survival_the_end` worlds:
 
```yaml
playerSets:
  all_players: all
  lobby: ${player world} == "lobby"
  survival: ${player world} == "survival" or ${player world} == "survival_nether" or ${player world} == "survival_the_end"
```

That long line does not look very nice, we can split it across three lines to increase readability:

```yaml
playerSets:
  all_players: all
  lobby: ${player world} == "lobby"
  survival: |
    ${player world} == "survival" or 
    ${player world} == "survival_nether" or 
    ${player world} == "survival_the_end"
```
[!]: endIF

[!]: ifBTLP
#### Players on a Specific Server

Let's create a _player set_ that only contains players on a specific server. For
 this example it is assumed that there is a server called `lobby`.
 
```yaml
playerSets:
  all_players: all
  lobby: ${player server} == "lobby"
```

Now that isn't too difficult. Let's create a _player set_ for a `survival`
 server too:
 
```yaml
playerSets:
  all_players: all
  lobby: ${player server} == "lobby"
  survival: ${player server} == "survival"
```

#### Players on the Same Server

Another common use case is a player set that contains all players on the same server as the person looking at the tab list.
Let's add a player set called `same_server` that does exactly that.

```yaml
playerSets:
  all_players: all
  lobby: ${player server} == "lobby"
  survival: ${player server} == "survival"
  same_server: ${player server} == ${viewer server}
```

[!]: endIF

Now a word on using [Placeholders](Placeholders) when creating a player 
 set. You usually want to use `player` variant of the placeholder when creating
 a condition that a player must fulfill to be part of the player set.

#### Selecting Players by Group

Last but not least we create a player set that contains all admins. For this
 example all players in either that `admin` or `owner` permission group are
 considered admins:
 
```yaml
playerSets:
  # ...
  admins: ${player vault_primary_group} == "admin" or ${player vault_primary_group} == "owner"
```

To increase readability the complex definitions can be split up over multiple lines:
 
```yaml
playerSets:
  # ...
  admins: |
      ${player vault_primary_group} == "admin"
      or ${player vault_primary_group} == "owner"
```

You could create a player set that contains all non-admins the same way, by listing all the groups, however a better way is to create a filter that says "everyone except admins" by replacing `==` with `!=` and `or` with `and`.

```yaml
playerSets:
  # ...
  admins: |
      ${player vault_primary_group} == "admin"
      or ${player vault_primary_group} == "owner"
  non_admins: |
      ${player vault_primary_group} != "admin"
      and ${player vault_primary_group} != "owner"
```

#### Selecting Players by Permission

An alternative to identifying admins by their group is to give them a specific permission.
For the purpose of this example we assume that all staff member have the `tablist.staff` permission.
Then we can create a player set containing all staff members, and a player set containing all player which are not staff by querying that permission:
```yaml
playerSets:
  # ...
  staff: ${player permission tablist.staff} = true
  non_staff: ${player permission tablist.staff} = false
```

[!]: ifBTLP
#### Miscellaneous Examples

Here are some more examples for player sets:

```yaml
playerSets:
  # Player set containing all players on a specific server and world:
  survival_nether: |
      ${player server} == "survival"
      and ${player world} == "world_nether"
  # This player set contains players on three different servers
  minigames: |
      ${player server} == "kitpvp"
      or ${player server} == "bedwars"
      or ${player server} == "survivalgames"
  same_server: ${player server} == ${viewer server}
  other_server: ${player server} != ${viewer server}
```
[!]: endIF

--------------------------------------------------------------------------------

Next: [Header and Footer](Header-and-Footer)
