plugins {
    kotlin("js") version "1.4.31"
}

val kotlinJS = "pre.113-kotlin-1.4.0"

group = "dev.skalable"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://dl.bintray.com/kotlin/kotlin-js-wrappers") }
}

dependencies {
    implementation(kotlin("stdlib-js"))
    testImplementation(kotlin("test-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-html:0.7.2")
    implementation("org.jetbrains:kotlin-react:16.13.1-${kotlinJS}")
    implementation("org.jetbrains:kotlin-react-dom:16.13.1-${kotlinJS}")
    implementation("org.jetbrains:kotlin-styled:1.0.0-${kotlinJS}")
}

kotlin {
    js(IR) {
        browser {
            binaries.executable()
            webpackTask {
                cssSupport.enabled = true
            }
            runTask {
                cssSupport.enabled = true
            }
            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
    }
}