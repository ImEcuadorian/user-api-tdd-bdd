plugins {
    java
    id("org.springframework.boot") version "3.5.0"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "io.github.imecuadorian"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

val cucumberVersion = "7.22.2"
val mockitoVersion = "5.18.0"
val junitPlatformVersion = "1.12.1"
val junitVersion = "5.12.1"
val junitPlatformSuiteVersion = "1.13.0"

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("io.cucumber:cucumber-java:$cucumberVersion")

    testImplementation("io.cucumber:cucumber-junit-platform-engine:$cucumberVersion")
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
    testImplementation("org.junit.platform:junit-platform-suite-api:$junitPlatformSuiteVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test"){
        exclude(module = "junit")
    }

    testRuntimeOnly("org.junit.platform:junit-platform-launcher:$junitPlatformVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<Test>("cucumber") {
    description = "Runs the BDD tests with Cucumber"
    group = "verification"
    useJUnitPlatform()
    include("**/CucumberTest.class")
    testClassesDirs = sourceSets["test"].output.classesDirs
    classpath = sourceSets["test"].runtimeClasspath
    systemProperty("cucumber.publish.quiet", "false")
    systemProperty("cucumber.plugin", "pretty")
}