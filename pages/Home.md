Welcome to the BungeeTabListPlus wiki!

Getting Started
===============

These pages provide you with a variety of useful information to help new users setting up the plugin.
The provided Configuration Examples can help you setup a nice looking tab list in no time.
And the Lists of Commands, Permissions and Placeholder can be used as Reference whenever you're working with the plugin.

* [Installing the plugin](Installation)
* [Global configuration options (`config.yml`)](GlobalConfiguration)
* [List of Commands and Permissions](Commands)
* [List of Placeholders](Placeholders)
* [Configuration Examples](Examples)

Tab List Configuration
======================

The following pages provide you with the knowledge required to edit the configuration files.
It is recommended that you read all of them in the provided order before you start configuring the plugin.

* [Part 1: Overview](Configuration-Basics-Part-1---Overview)
* [Part 2: Tablist configuration file structure](Configuration-Basics-Part-2---Tablist-Configuration-File)
* [Part 3: Header and Footer](Configuration-Basics-Part-3---Header-and-Footer)
* [Part 4: Player sets](Configuration-Basics-Part-4---Player-sets)
* [Part 5: Dynamic Size Tablist](Configuration-Basics-Part-5---Dynamic-Size-Tablist)
* [Part 6: Fixed Size Tablist - Introduction](Configuration-Basics-Part-6---Fixed-Size-Tablist-Introduction)
* [Part 7: Fixed Size Tablist - Adding Players](Configuration-Basics-Part-7---Fixed-Size-Tablist---Adding-Players)
* [Part 8: Fixed Size Tablist - The Table Component](Configuration-Basics-Part-8---Fixed-Size-Tablist---Table)

Advanced Configuration
======================

These pages cover some more advanced topics. You can read them in any order. It is however recommended you read the basic topics above before reading any of the advanced pages.

* [Hidden Players](Hidden-Players)

  Learn how to remove vanished players from the tab list.

* [Text Alignment and Cutting Off Long Text](Alignment-and-Long-Text)

  Understand how text alignment works and how to cut off long text.

* [Animations](Animations)

  Learn how to animate text in slots.

* [Integrating with PermissionsEx](PermissionsEx)

  Display the prefix and suffix from PermissionsEx in the tab list and sort players by their permissions group.

* [Using PlaceholderAPI placeholders](PlaceholderAPI)

  Get access to over 1000 additional placeholders using PlaceholderAPI.

* [Sorting players](PlayerOrder)

  Players can be ordered by many different criteria. They can be sorted alphabetically, by rank or by server just to name a few options.

* [Custom placeholders](CustomPlaceholders)

  Custom Placeholders are a powerful mechanism to customize the tab list even further.

* [Multiple Tablists](MultipleTablists)

  You can have different tab lists for specific servers, players, ranks, Minecraft versions, etc.

* [The `DYNAMIC_SIZE_FIXED_COLUMNS` tab list type](DYNAMIC_SIZE_FIXED_COLUMNS)

  The `DYNAMIC_SIZE_FIXED_COLUMNS` tab list type is the third available tab list type. It is similar to the `FIXED_SIZE`
  tab list type. It keeps the number of columns constant while automatically adjusting the number of rows to fit the content.
  You can create custom slots and configure the content of the tab list freely, the same way it's possible when using the `FIXED_SIZE` tab list type.

* [Vertical Slot Order](Vertical-Slot-Order)

  Instead of filling the tab list from left to right first then top to bottom you can also fill it top to bottom first then left to right. 

Special pages
=============

These are rather technical. Unless you're a developer you probably won't be able make much out of them.

* [List of all Components](Components)
  
  List of all Components and respective options.
  
* [Expression syntax](Expressions)

  Very technical description of the expression syntax.

Developer Resources
===================

Here are some links which you might find useful working with the plugin's API.

* [Instructions how to use the API](Developers)
* [Javadoc for the Bukkit side API](http://ci.codecrafter47.dyndns.eu/job/BungeeTabListPlus/codecrafter47.bungeetablistplus$bungeetablistplus-api-bukkit/javadoc/)
* [Javadoc for the Bungee side API](http://ci.codecrafter47.dyndns.eu/job/BungeeTabListPlus/codecrafter47.bungeetablistplus$bungeetablistplus-api-bungee/javadoc/)
* [Javadoc for the Sponge side API](http://ci.codecrafter47.dyndns.eu/job/BungeeTabListPlus/codecrafter47.bungeetablistplus$bungeetablistplus-api-sponge/javadoc/)