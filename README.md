[BungeeTabListPlus]: https://github.com/CodeCrafter47/BungeeTabListPlus
[AdvancedTabOverlay]: https://github.com/CodeCrafter47/AdvancedTabOverlay

This repository contains the template files from which the wiki for [BungeeTabListPlus] and [AdvancedTabOverlay] is generated.

Templates for the pages are located in the `pages/` directory.
Images are located in `images/`.

### Generating the wiki

The wiki can be generated from the templates by running the following command.
```sh
kotlin update_wiki.kts
```

### Template files

Within the template files the following placeholders and commands are processed.
* **Conditional Inclusion**
  ```
  [!]: ifBTLP
  This text is only included in the BTLP wiki.
  [!]: endIF
  ```
  ```
  [!]: ifATO
  This text is only included in the ATO wiki.
  [!]: endIF
  ```
* **Table of Contents**
  
  Add the following line to generate a table of contents for the wiki page.
  ```
  [!]: ToC
  ```
* **Placeholders**
  
  The following placeholders are replaced.
  * `!!name` - name of the plugin
  * `!!iconFolder` - name of the icon folder
  * `!!seevanishedperm` - permission that allows seeing vanished players
  
  
