plugins {
    kotlin("jvm") version "1.9.0"  // Use latest Kotlin version
    id("java-library") // For creating a Jakarta EE library
}

group = "com.ajcode404"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {

    // Jakarta EE API
    implementation("jakarta.platform:jakarta.jakartaee-api:10.0.0")
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")
    implementation("org.hibernate.validator:hibernate-validator:8.0.1.Final")
    implementation("org.glassfish.expressly:expressly:5.0.0")

    // Testing
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}