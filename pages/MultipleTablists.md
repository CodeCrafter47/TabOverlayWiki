There is a folder called `tabLists` and in this folder is one file called default.yml which contains the tablist layout. Seeing this you might wonder why there's a folder if there's only one file in it. This is because you can have multiple tab lists. A second tablist is created by making a copy of default.yml and giving it another name (which has to end with `.yml`). After creating a new file you should edit it. Especially important is to change `showTo` which defines who will see a specific tablist and `priority` which is used to determine which tab list a player will see if multiple tab lists match.

Examples
========

Special tab list for the Factions server
----------------------------------------

```yaml
# tabLists/Factions.yml

# This tab list should be shown to players on the factions server.
showTo: ${viewer server} == "factions"
# Priority should be higher than the one of the default tab list.
priority: 25

# No header/ footer because space in the wiki is limited ;)
# You can add a header/ footer yourself if you like.
showHeaderFooter: false

# A fixed size tab list of size 60
type: FIXED_SIZE
size: 60 # 3 columns, 20 rows

# Somehow I like colors/dark_gray.png as default icon
defaultIcon: "colors/dark_gray.png"
defaultPing: 1000

# The player sets we need
playerSets:
  # All players
  global: all
  # Online players in your faction
  faction: ${player faction_name} == ${viewer faction_name}

components:
- !table
  columns:
    0: # 1st column
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
    - {text: "&6${playerset:global size}", icon: "default/players.png", ping: 0} # 14th row
    - {text: "", icon: "colors/gold.png", ping: 0} # 15th row
    - {text: "&cBalance:", icon: "default/balance.png", ping: 0} # 16th row
    - {text: "&6${viewer vault_balance}", icon: "default/balance.png", ping: 0} # 17th row
    - {text: "", icon: "colors/gold.png", ping: 0} # 18th row
    - {text: "&cTime:", icon: "default/clock.png", ping: 0} # 19th row
    - {text: "&6${time HH:mm:ss}", icon: "default/clock.png", ping: 0} # 20th row
    1: # 2nd column
    - {text: "&a&lPlayers", icon: "colors/green.png", ping: 0} # 1st row
    # Now we show the list of players on the network.
    - !players # 2nd to 20th row
      playerSet: global
      playerComponent: "${player vault_prefix}&f${player name}"
      morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
    2: # 3rd column
    - !conditional # In the third column there is different content depending on whether the player is member of a faction or not.
      condition: ${viewer faction_name} == ""
      true: # Not in a faction
      - {text: "&6Faction list", icon: "colors/gold.png", alignment: CENTER} # 1st row
      -
      -
      -
      -
      -
      -
      -
      -
      - {text: "Not in a Faction", alignment: CENTER} # 10th row
      - {text: "Join one!", alignment: CENTER} # 11th row
      false: # Member of a faction
      - {text: "&6Faction &f${viewer faction_name}", icon: "colors/gold.png", alignment: CENTER} # 1st row
      - {text: "&f${playerset:faction size} of ${viewer faction_member_count} &6Online", icon: "colors/gold.png", alignment: CENTER} # 2nd row
      - # 3rd row
      - !players # We use the remaining row to display the players in the players faction
        playerSet: faction
        playerComponent: "${player name}"
        morePlayersComponent: {text: "... and ${other_count} others", icon: "default/players.png", ping: 0}
```
![](images/factions-config.gif)