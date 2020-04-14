

Make sure you have read the [Player Order](Player-Order) page before reading this page.

### Using the `weight` of the Primary Group

We can configure the plugin to use the weight of the players primary group to sort the players.
The `weight` property is used by many permission plugin to decide which group is a players primary group, so it says something about whether a player has a high or low rank.
That makes it a good candidate for sorting players.
To sort players by the `weight` of their primary group do the following two steps:

1. ##### Configure your Permission Plugin to Assign a `weight` to Each Group

    You need to assign a `weight` to each group.
    Check the documentation of your permission plugin to learn
    * how to set the weight, and
    * whether a low or a high number equals a high rank.
    
    When using PermissionsEx the command is `/pex group <group> weight [weight]` and a lower number equals a higher rank.
    
    When using LuckPerms the command is `/lp group <group> setweight <weight>` and a higher number equals a higher rank.
    
    For other permission plugins check their documentation.

2. ##### Change your Tab List Configuration

    Once your permission plugin is setup correctly and all groups have a weight assigned, you are ready to make the changes to your tab list configuration file to sort the players by the `weight` of their primary group.
    
    Specifying the order of players on the tab list is done using the `playerOrder` option.
    This option is available in the `DYNAMIC_SIZE` tab list type.
    When using the `FIXED_SIZE` tab list type all components which insert players to the tab list allow for setting the `playerOrder` option.
    
    In your current tab list configuration the `playerOrder` option might be set as follows, which sorts the players alphabetically:
    ```yaml
    playerOrder: "name asc"
   ```
   
   To sort them by the `weight` you need to add the `vault_primary_group_weight asc` or `vault_primary_group_weight desc` depending on whether a low or a high `weight` equals a high rank.
   E.g. when using PermissionsEx the following would be correct:
    ```yaml
    playerOrder: "vault_primary_group_weight asc, name asc"
    ```
   When using LuckPerms you would use 
    ```yaml
    playerOrder: "vault_primary_group_weight desc, name asc"
    ```
   
   Depending on your permission plugin you could replace the `vault_primary_group_weight` placeholder with a plugin specific placeholder.
   However, we recommend sticking with the vault placeholder unless you have a specific reason not to use it.
   
##### Troubleshooting

If the players are not sorted correctly check the following things:

* Verify that the group weights are set correctly and each player is assigned the correct primary group using the commands provided by your permission plugin.
* Make sure you have installed Vault.
[!]: ifBTLP
* Make sure you installed BungeeTabListPlus_BukkitBridge. Use `/btlp status` to verify.
[!]: endIF
* Display the primary group and the weight in the tab list, e.g. using 
    ```yaml
    playerComponent: "${player name} ${player vault_primary_group}/${player vault_primary_group_weight}"
    ```

### Using a Custom Meta Value

An alternative to using the weight is using a custom meta value.
This is especially useful when the order induced by the weight is different from the order you want to have in the tab list.

In the following we create a custom meta value called `taborder` and use that to sort the players.

1. ##### Set the `taborder` Meta Value of Your Groups

    The first step is to set the `taborder` meta value of your group.
    You need to decide whether you want a low or a high `weight` equals a high rank.
    We are going to assume low value equals high rank for now.
    
    For LuckPerms the command is `/lp group <group> meta set taborder <value>`
    When using a different permission plugin checkout its documentation.
    
2. ##### Change your Tab List Configuration

    Next we need to create comparison rule to sort the players by the `taborder` meta value.
    
    For LuckPerms you can use `luckperms_meta_taborder as number asc`.
    The `luckperms_meta_<meta>` placeholder is provided by PlaceholderAPI.
    If you use a different permission plugin check if PlaceholderAPI has a suitable placeholder for you.
    
    Adding that comparison rule to the `playerOrder` option you should end up with something similar to the following:
    ```yaml
    playerOrder: "luckperms_meta_taborder as number asc, name asc"
    ```