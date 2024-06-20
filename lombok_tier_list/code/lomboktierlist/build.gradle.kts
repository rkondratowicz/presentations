plugins {
    id("java")
    id("io.freefair.lombok") version "8.6"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)
    testImplementation("org.assertj:assertj-core:3.26.0")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}