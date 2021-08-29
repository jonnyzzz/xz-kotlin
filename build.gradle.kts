plugins {
  kotlin("multiplatform") version "1.5.30" apply false
  `java-library`
}

allprojects {
  repositories {
    mavenCentral()
  }
}


sourceSets.main.configure {
  java.setSrcDirs(listOf(file("src")))
}

