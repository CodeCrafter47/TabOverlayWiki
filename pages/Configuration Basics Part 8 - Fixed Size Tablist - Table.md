This page shows how to use the _table_ component to customize the layout of
 your tab list.

--------------------------------------------------------------------------------

### Splitting the tab list into columns

![](images/fixed-size-table-1.png)

```yaml
showTo: 'true'
priority: 1

showHeaderFooter: false

# Three player sets, one for each server
playerSets:
  lobby: ${player server} == "spawn"
  survival: ${player server} == "survival"
  creative: ${player server} == "creative"

type: FIXED_SIZE
size: 60

defaultIcon: "colors/dark_gray.png"
defaultPing: 1000

components:
- !table
  columns:
    0: # 1st column
    - {text: "&a&lLobby", icon: "colors/green.png", ping: 0}
    - !players
      playerSet: lobby
      playerComponent: "${player name}"
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
    1: # 2nd column
    - {text: "&b&lSurvival", icon: "colors/aqua.png", ping: 0}
    - !players
      playerSet: survival
      playerComponent: "${player name}"
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
    2: # 3rd column
    - {text: "&c&lCreative", icon: "colors/red.png", ping: 0}
    - !players
      playerSet: creative
      playerComponent: "${player name}"
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
```

Here the `!table` marker tells the plugin that we want to use a _table_
 component. Then we use the `columns` option to specify the content of each
 column. The content of each column is again a list of components. In our case
 we have a custom slot we use to display the server name and below a _players_
 component to display the players on that server.

Actually it isn't necessary to put the custom slots with the server names inside
 the _table_ component. We could also place them before the _table_ component in
 the configuration file. The following example shows how the `components` part
 of the config file would look after that change. Note that is still results in
 the same tab list as the example shown above.

```yaml
components:
- {text: "&a&lLobby", icon: "colors/green.png", ping: 0}
- {text: "&b&lSurvival", icon: "colors/aqua.png", ping: 0}
- {text: "&c&lCreative", icon: "colors/red.png", ping: 0}
- !table
  columns:
    0: # 1st column
    - !players
      playerSet: lobby
      playerComponent: "${player name}"
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
    1: # 2nd column
    - !players
      playerSet: survival
      playerComponent: "${player name}"
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
    2: # 3rd column
    - !players
      playerSet: creative
      playerComponent: "${player name}"
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
```

--------------------------------------------------------------------------------

### Using one column only for custom slots

Now we change the left-most column to display some custom slots instead of the
 players on the lobby server:

![](images/fixed-size-table-2.png)

```yaml
showTo: 'true'
priority: 1

showHeaderFooter: false

# Three player sets, one for each server
playerSets:
  all_players: all
  lobby: ${player server} == "spawn"
  survival: ${player server} == "survival"
  creative: ${player server} == "creative"

type: FIXED_SIZE
size: 60

defaultIcon: "colors/dark_gray.png"
defaultPing: 1000

components:
- !table
  columns:
    0: # Display some info on the first column
    - {text: "&lInfo", icon: "colors/gold.png", ping: 0} # 1st row
    - {text: "", icon: "colors/gold.png", ping: 0} # 2nd row
    - {text: "", icon: "colors/gold.png", ping: 0} # 3rd row
    - {text: "&cServer:", icon: "default/server.png", ping: 0} # 4th row
    - {text: "&6${viewer server}", icon: "default/server.png", ping: 0} # 5th row
    - {text: "", icon: "colors/gold.png", ping: 0} # 6th row
    - {text: "&cRank:", icon: "default/rank.png", ping: 0} # 7th row
    - {text: "&6${viewer vault_primary_group}", icon: "default/rank.png", ping: 0} # 8th row
    - {text: "", icon: "colors/gold.png", ping: 0} # 9th row
    - {text: "&cPing:", icon: "default/ping.png", ping: 0} # 10th row
    - {text: "&6${viewer ping}ms", icon: "default/ping.png", ping: 0} # 11th row
    - {text: "", icon: "colors/gold.png", ping: 0} # 12th row
    - {text: "&cPlayers:", icon: "default/players.png", ping: 0} # 13th row
    - {text: "&6${playerset:all_players size}", icon: "default/players.png", ping: 0} # 14th row
    - {text: "", icon: "colors/gold.png", ping: 0} # 15th row
    - {text: "&cBalance:", icon: "default/balance.png", ping: 0} # 16th row
    - {text: "&6${viewer vault_balance}", icon: "default/balance.png", ping: 0} # 17th row
    - {text: "", icon: "colors/gold.png", ping: 0} # 18th row
    - {text: "&cTime:", icon: "default/clock.png", ping: 0} # 19th row
    - {text: "&6${time HH:mm:ss}", icon: "default/clock.png", ping: 0} # 20th row
    1: # 2nd column
    - {text: "&b&lSurvival", icon: "colors/aqua.png", ping: 0}
    - !players
      playerSet: survival
      playerComponent: "${player name}"
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
    2: # 3rd column
    - {text: "&c&lCreative", icon: "colors/red.png", ping: 0}
    - !players
      playerSet: creative
      playerComponent: "${player name}"
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
```

--------------------------------------------------------------------------------

### Displaying two servers in one column

Now we want to add back the lobby server and display it in the third column
 below the creative server. To do that we make the following changes to the
 config file:

```yaml
components:
- !table
  columns:
    0: # Display some info on the first column
    - {text: "&lInfo", icon: "colors/gold.png", ping: 0} # 1st row
    - # ... none of this is changed
    1: # neither is anything in the 2nd column changed
    - {text: "&b&lSurvival", icon: "colors/aqua.png", ping: 0}
    - !players
      playerSet: survival
      playerComponent: "${player name}"
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
    2: # 3rd column
    - {text: "&c&lCreative", icon: "colors/red.png", ping: 0}
    - !players
      playerSet: creative
      playerComponent: "${player name}"
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
      # For the first players component we set the minSize and maxSize options
      # to 9 so it will always take up 9 slots
      minSize: 9
      maxSize: 9
    # Now we add the lobby server
    - {text: "&a&lLobby", icon: "colors/green.png", ping: 0}
    - !players
      playerSet: lobby
      playerComponent: "${player name}"
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
```

Now this looks as follows:

![](images/fixed-size-table-3.png)

--------------------------------------------------------------------------------

### Using multiple columns for a server

Now we want to use two columns for the survival server:

![](images/fixed-size-table-4.png)

Here's how it is done:

```yaml
showTo: 'true'
priority: 1

showHeaderFooter: false

playerSets:
  all_players: all
  lobby: ${player server} == "spawn"
  survival: ${player server} == "survival"
  creative: ${player server} == "creative"

type: FIXED_SIZE
size: 80 # The size of the tab list is increased to 80

defaultIcon: "colors/dark_gray.png"
defaultPing: 1000

components:
- !table
  columns:
    0:
    - {text: "&lInfo", icon: "colors/gold.png", ping: 0}
    - {text: "", icon: "colors/gold.png", ping: 0}
    - {text: "", icon: "colors/gold.png", ping: 0}
    - {text: "&cServer:", icon: "default/server.png", ping: 0}
    - {text: "&6${viewer server}", icon: "default/server.png", ping: 0}
    - {text: "", icon: "colors/gold.png", ping: 0}
    - {text: "&cRank:", icon: "default/rank.png", ping: 0}
    - {text: "&6${viewer vault_primary_group}", icon: "default/rank.png", ping: 0}
    - {text: "", icon: "colors/gold.png", ping: 0}
    - {text: "&cPing:", icon: "default/ping.png", ping: 0}
    - {text: "&6${viewer ping}ms", icon: "default/ping.png", ping: 0}
    - {text: "", icon: "colors/gold.png", ping: 0}
    - {text: "&cPlayers:", icon: "default/players.png", ping: 0}
    - {text: "&6${playerset:all_players size}", icon: "default/players.png", ping: 0}
    - {text: "", icon: "colors/gold.png", ping: 0}
    - {text: "&cBalance:", icon: "default/balance.png", ping: 0}
    - {text: "&6${viewer vault_balance}", icon: "default/balance.png", ping: 0}
    - {text: "", icon: "colors/gold.png", ping: 0}
    - {text: "&cTime:", icon: "default/clock.png", ping: 0}
    - {text: "&6${time HH:mm:ss}", icon: "default/clock.png", ping: 0}
    1-2: # Here we want the 2nd and 3rd column
    - {text: "&b&lSurvival", icon: "colors/aqua.png", ping: 0}
    # We need two custom slots displaying the server name
    - {text: "&b&lSurvival", icon: "colors/aqua.png", ping: 0}
    - !players
      playerSet: survival
      playerComponent: "${player name}"
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
    3: # This is now at the 4th column
    - {text: "&c&lCreative", icon: "colors/red.png", ping: 0}
    - !players
      playerSet: creative
      playerComponent: "${player name}"
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
      minSize: 9
      maxSize: 9
    - {text: "&a&lLobby", icon: "colors/green.png", ping: 0}
    - !players
      playerSet: lobby
      playerComponent: "${player name}"
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
```