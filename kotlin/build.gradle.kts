plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm("jvm8")
    js(IR) {
        useCommonJs()

        browser()
        nodejs()
    }

    val commonMain by sourceSets.getting {

    }

    val jvm8Main by sourceSets.getting {

    }

    val jsMain by sourceSets.getting {

    }
}
