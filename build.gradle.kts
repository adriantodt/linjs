plugins {
    kotlin("js") version "1.6.0-RC2"
}

group = "com.github.adriantodt"
version = "0.2.2"

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        url = uri("https://maven.cafeteria.dev/releases")
    }
}

dependencies {
    implementation("com.github.adriantodt:lin:0.2-localtest4")
    testImplementation(kotlin("test"))
}

kotlin {
    js(IR) {
        moduleName = "lin"
        browser()
        nodejs()
        binaries.library()
        compilations.named("main") {
            packageJson {
                customField("name", "@lin-lang/lin")
                customField("description", "A JS wrapper for the programming language Lin.")
                customField(
                    "author", mapOf(
                        "name" to "adriantodt",
                        "email" to "adrian.todtsilva@gmail.com",
                        "url" to "https://adriantodt.net"
                    )
                )
                customField("license", "MIT")
                customField(
                    "repository", mapOf(
                        "type" to "git",
                        "url" to "https://github.com/adriantodt/linjs.git"
                    )
                )
                customField(
                    "bugs", mapOf(
                        "url" to "https://github.com/adriantodt/linjs/issues"
                    )
                )
                customField("homepage", "https://github.com/adriantodt/linjs")
                customField("keywords", listOf("kotlin", "lin", "programming-language"))
            }
        }
    }

    sourceSets {
        all {
            languageSettings.optIn("kotlin.RequiresOptIn")
        }
    }
}
/**
 * {
"name": "@lin-lang/lin",
"version": "0.1.0-alpha.1",
"license": "MIT",
"main": "lin.js",
"types": "lin.d.ts",
"devDependencies": {},
"dependencies": {},
"peerDependencies": {},
"optionalDependencies": {},
"bundledDependencies": [],
"private": false
}
 */
