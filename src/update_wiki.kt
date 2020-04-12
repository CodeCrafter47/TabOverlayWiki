import java.io.File

fun main() {

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

    val prevFiles = target.listFiles().filter { it.isFile && it.name.endsWith(".md") }.map { it.name }.toMutableList()

    // copy images
    imagesSrc.listFiles()
        .filter { it.isFile }
        .forEach { it.copyTo(File(File(target, "images"), it.name), true) }

    // copy markdown
    pagesSrc.listFiles()
        .filter { it.isFile && it.name.endsWith(".md") }
        .forEach { file ->
            var lines = file.readLines()

            for ((line, text) in lines.withIndex()) {
                if (text.contains("todo"))
                    println("TODO: ${file.name} $line")
            }

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

            for ((line, text) in lines.withIndex()) {
                if (text.contains("[!]"))
                    println("TODO: [!] ${file.name} $line")
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
                }
            }
            lines = linesNew

            var text = lines.joinToString(separator = "\n")
            text = text.replace("!!name", pluginName)
            text = text.replace("!!iconFolder", iconFolder)
            text = text.replace("!!seevanishedperm", seevanishPerm)

            if (text.contains("!!")) {
                println("${file.name} contains !!")
            }

            File(target, file.name).writeText(text)
            prevFiles.remove(file.name)
        }

    if (!prevFiles.isEmpty()) {
        println("Old files: ${prevFiles.joinToString()}")
    }
}