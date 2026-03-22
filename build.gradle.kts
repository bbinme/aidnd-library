plugins {
    id("java-library")
    id("maven-publish")
}

group   = "com.aidnd"
version = "0.1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
    withSourcesJar()
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.1")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "aethermere-library"
            from(components["java"])
        }
    }
}
