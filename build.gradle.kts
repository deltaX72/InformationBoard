import java.nio.file.Files

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.3.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
    }
}

val projectPath: String = "app/src/main/java/com/deltax72/informationboard"

val utils: String = "$projectPath/presentation/utils"
val resources: String = "app/src/main/res"

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

tasks.register<Sync>("new_contract") {
    val contractName = project.property("contract").toString()
    val contractNameLowerCase = contractName.toLowerCase()
    val contractNameXml = toXmlFormatNaming(contractName)

    val fromContractPath = "$utils/patterns/contract"
    val packageContractPath = "$projectPath/presentation/fragments/$contractNameLowerCase"

    createDirectory(packageContractPath)

    from(fromContractPath)
    into(packageContractPath)

    rename("PatternnameContract.kt", "${contractName}Contract.kt")
    rename("PatternnameFragment.kt", "${contractName}Fragment.kt")
    rename("PatternnameRepository.kt", "${contractName}Repository.kt")
    rename("PatternnameViewModel.kt", "${contractName}ViewModel.kt")

    doLast {
        replacePatternNames(
            keywords = listOf("Contract", "Fragment", "Repository", "ViewModel"),
            packagePath = packageContractPath,
            name = contractName
        )
    }

    val fromLayoutPath = "$resources/layout"
    val intoLayoutPath = "$resources/layouts/fragment/layout"

    val fileFrom = File(
        "$fromLayoutPath/fragment_patternname.xml"
    )
    val fileInto = File(
        "$intoLayoutPath/fragment_${contractNameXml}.xml"
    )
    fileInto.writeText(fileFrom.readText())
}

tasks.register<Sync>("new_adapter") {
    val adapterName = project.property("adapter").toString()
    val adapterNameLowerCase = adapterName.toLowerCase()

    val fromAdapterPath = "$utils/patterns/adapter"
    val packageAdapterPath = "$projectPath/presentation/adapters/$adapterNameLowerCase"

    createDirectory(packageAdapterPath)

    from(fromAdapterPath)
    into(packageAdapterPath)

    rename("PatternnameAdapter.kt", "${adapterName}Adapter.kt")

    doLast {
        replacePatternNames(
            keywords = listOf("Adapter"),
            packagePath = packageAdapterPath,
            name = adapterName
        )
    }
}

fun getPackageName(path: String) = path
    .removePrefix("app/src/main/java/")
    .replace("/", ".")
    .toLowerCase()

fun createDirectory(path: String) = Files.createDirectories(file(path).toPath())

fun replacePatternNames(keywords: List<String>, packagePath: String, name: String) {
    for (word in keywords) {
        var lineNumber = 0
        var newFileText = ""
        file("$packagePath/${name}$word.kt").forEachLine {
            newFileText +=
                if (lineNumber == 0) "package ${getPackageName(packagePath)}"
                else it.replace("Patternname", name)
            newFileText += "\n"
            lineNumber++
        }
        file("$packagePath/${name}$word.kt").writeText(newFileText)
    }
}

fun toXmlFormatNaming(value: String) = with(value) {
    val result = StringBuilder()
    for (i in indices) {
        if (i == 0) {
            result.append(this[i].toLowerCase())
            continue
        }
        if (this[i].isUpperCase()) {
            result.append("_${this[i].toLowerCase()}")
            continue
        }
        result.append(this[i])
    }
    result.toString()
}

// Top-level build file where you can icon_add configuration options common to all sub-projects/modules.
//plugins {
//    id("com.android.application") version '7.3.1' apply false
//    id 'com.android.library' version '7.3.1' apply false
//    id 'org.jetbrains.kotlin.android' version '1.8.20' apply false
//}