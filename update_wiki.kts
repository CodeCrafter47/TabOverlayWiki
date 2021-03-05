#!/usr/bin/env kotlin

import java.io.File

var has_error = false

println("Updating ATO wiki")
update_wiki(
        File("pages"),
        File("images"),
        File("AdvancedTabOverlay.wiki"),
        false,
        "AdvancedTabOverlay",
        "icons/",
        "advancedtaboverlay.seehidden"
)

println("Updating BTLP wiki")
update_wiki(
        File("pages"),
        File("images"),
        File("BungeeTabListPlus.wiki"),
        true,
        "BungeeTabListPlus",
        "heads/",
        "bungeetablistplus.seevanished"
)

if (has_error) {
    System.exit(1)
}

fun update_wiki(
        pagesSrc: File,
        imagesSrc: File,
        target: File,
        isBTLP: Boolean,
        pluginName: String,
        iconFolder: String,
        seevanishPerm: String
) {
    // create file if not exists
    if (!target.exists()) {
        target.mkdir();
    }

    val prevFiles = target.listFiles().filter { it.isFile && it.name.endsWith(".md") }.map { it.name }.toMutableList()
    val linkTargets =
            pagesSrc.listFiles()
                    .filter { it.isFile && it.name.endsWith(".md") }
                    .map { it.name.replace(".md", "").replace(" ", "-") }

    // copy images
    imagesSrc.listFiles()
            .filter { it.isFile }
            .forEach { it.copyTo(File(File(target, "images"), it.name), true) }

    // copy markdown
    pagesSrc.listFiles()
            .filter { it.isFile && it.name.endsWith(".md") }
            .forEach { file ->
                var lines = file.readLines()

                // check for todo
                for ((line, text) in lines.withIndex()) {
                    if (text.contains("todo")) {
                        println("TODO: ${file.name} $line")
                        has_error = true
                    }
                }

                // handle [!]: ifATO
                var linesNew = mutableListOf<String>()
                var restrictedBlock = false
                for (text in lines) {
                    if (!restrictedBlock && text.contains("[!]: ifATO"))
                        restrictedBlock = true
                    else if (restrictedBlock && text.contains("[!]: endIF", ignoreCase = true))
                        restrictedBlock = false
                    else if (!restrictedBlock || !isBTLP)
                        linesNew.add(text)
                }
                lines = linesNew

                // handle [!]: ifBTLP
                linesNew = mutableListOf<String>()
                restrictedBlock = false
                for (text in lines) {
                    if (!restrictedBlock && text.contains("[!]: ifBTLP"))
                        restrictedBlock = true
                    else if (restrictedBlock && text.contains("[!]: endIF", ignoreCase = true))
                        restrictedBlock = false
                    else if (!restrictedBlock || isBTLP)
                        linesNew.add(text)
                }
                lines = linesNew

                // handle [!]: ToC
                linesNew = mutableListOf<String>()
                for ((line, text) in lines.withIndex()) {
                    if (text.contains("[!]: ToC", ignoreCase = true)) {
                        for (l in lines.subList(line + 1, lines.size)) {
                            if (l.contains("##### ")) {
                                // ignore tier 5,6
                            } else if (l.contains("#### ")) {
                                // tier 4
                                val substring = l.substring(l.indexOf("#### ") + 5)
                                val label = extractLabel(substring)
                                linesNew.add("    * [$substring]($label)")
                            } else if (l.contains("### ")) {
                                // tier 3
                                val substring = l.substring(l.indexOf("### ") + 4)
                                val label = extractLabel(substring)
                                linesNew.add(" * [$substring]($label)")
                            }
                        }
                    } else {
                        linesNew.add(text)
                    }
                }
                lines = linesNew

                // check for issues
                for ((line, text) in lines.withIndex()) {
                    // lines containing [!] indicate an error.
                    // The [!] is used by template commands and should be removed at this stage.
                    if (text.contains("[!]")) {
                        println("TODO: [!] ${file.name} $line")
                        has_error = true
                    }
                    // check targets of local links
                    "\\[[^]]+\\]\\(([^)]+)\\)".toRegex().findAll(text).forEach { match ->
                        if ((!linkTargets.contains(match.groupValues[1]) && !match.groupValues[1].startsWith("http") && !match.groupValues[1].startsWith("#")) || match.groupValues[1].contains(
                                        ' '
                                )
                        ) {
                            println("Unknown link target: ${file.name} ${match.groupValues[1]} $line")
                            has_error = true
                        }
                    }
                }

                // remove double blank lines
                linesNew = mutableListOf<String>()
                var blankBefore = false
                for (text in lines) {
                    if (!blankBefore || !text.trim().isEmpty()) {
                        linesNew.add(text)
                    }
                    if (!blankBefore && text.trim().isEmpty()) {
                        blankBefore = true
                    } else if (!text.trim().isEmpty()) {
                        blankBefore = false
                    }
                }
                lines = linesNew

                // replace !!xxx placeholders
                var text = lines.joinToString(separator = "\n")
                text = text.replace("!!name", pluginName)
                text = text.replace("!!iconFolder", iconFolder)
                text = text.replace("!!seevanishedperm", seevanishPerm)

                // check if there is any !! left in the file
                if (text.contains("!!")) {
                    println("${file.name} contains !!")
                    has_error = true
                }

                File(target, file.name).writeText(text)
                prevFiles.remove(file.name)
            }

    if (!prevFiles.isEmpty()) {
        println("Old files: ${prevFiles.joinToString()}")
    }
}

fun extractLabel(substring: String): String {
    return "#" + substring
            .replace("`", "")
            .replace("$", "")
            .replace("{", "")
            .replace("}", "")
            .replace("!", "")
            .replace(":", "")
            .replace("<", "")
            .replace(">", "")
            .replace("[", "")
            .replace("]", "")
            .replace("/", "")
            .trim()
            .replace(" ", "-")
            .toLowerCase()
}
