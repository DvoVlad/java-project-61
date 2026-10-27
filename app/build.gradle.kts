plugins {
    application
    id("java")
    id("com.diffplug.spotless") version "6.25.0"
    id("io.github.ben-manes.versions") version "0.66.0"
}

application {
    mainClass = "hexlet.code.App"
}

group = "org.braingames"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

spotless {
    java {
        importOrder()
        removeUnusedImports()
        googleJavaFormat().aosp()
        formatAnnotations()
        indentWithSpaces(4)
    }
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}