A _player set_ is a named subset of your players. Player sets are used by the 
 plugin to display players and player counts in the tab list.

Player sets are configured in the tab list configuration file. A simple _player
 set_ containing all players can be created like this:
 
```yaml
playerSets:
  all_players: all
```

The above line creates a playerSet called `all_players` that contains all players.

Now you could use the _player set_ to display the number of players on your 
 server in the footer of the tab list:
```yaml
footer:
- '&7Total players:&f ${playerset:all_players size}'
```

As you can see from the example the `${playerset:all_players size}` placeholder
 is used to display the number of players in the _player set_. This works the
 same for all _player sets_: The `${playerset:<name> size}` placeholders
 displays the number of players in a particular _player set_.

### Players on a Specific Server

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

Let's use these to display server player counts in the footer:
```yaml
footer: |-
        &7Total players:&f ${playerset:all_players size}
        Lobby: ${playerset:lobby size} | Survival: ${playerset:survival size}
```

Another common use case is a player set that contains all players on the same server as the person looking at the tab list.
Let's add a player set called `same_server` that does exactly that.

```yaml
playerSets:
  all_players: all
  lobby: ${player server} == "lobby"
  survival: ${player server} == "survival"
  same_server: ${player server} == ${viewer server}
```

Now a word on using [Placeholders](Placeholders) when creating a _player 
 set_. You usually want to use `player` variant of the placeholder when creating
 a condition that a player must fulfill to be part of the player set.

### Selecting Players by Group

Last but not least we create a _player set_ that contains all admins. For this
 example all players in either that `admin` or `owner` permission group are
 considered admins:
 
```yaml
playerSets:
  all_players: all
  lobby: ${player server} == "lobby"
  survival: ${player server} == "survival"
  same_server: ${player server} == ${viewer server}
  admins: ${player vault_primary_group} == "admin" or ${player vault_primary_group} == "owner"
```

To increase readability the complex definitions can be split up over multiple lines:
 
```yaml
playerSets:
  all_players: all
  lobby: ${player server} == "lobby"
  survival: ${player server} == "survival"
  admins: |
      ${player vault_primary_group} == "admin"
      or ${player vault_primary_group} == "owner"
```

You could create a player set that contains all non-admins the same way, by listing all the groups, however a better way is to create a filter that says "everyone except admins" by replacing `==` with `!=` and `or` with `and`.

```yaml
  admins: |
      ${player vault_primary_group} == "admin"
      or ${player vault_primary_group} == "owner"
  non_admins: |
      ${player vault_primary_group} != "admin"
      and ${player vault_primary_group} != "owner"
```

### Further examples

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

--------------------------------------------------------------------------------

Next: [Configuration Basics Part 5 - Dynamic Size Tablist](Configuration-Basics-Part-5---Dynamic-Size-Tablist)
