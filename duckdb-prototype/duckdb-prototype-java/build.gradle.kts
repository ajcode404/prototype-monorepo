plugins {
    kotlin("jvm") version "2.0.21"
}

group = "com.ajcode404"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.duckdb:duckdb_jdbc:1.1.3")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}