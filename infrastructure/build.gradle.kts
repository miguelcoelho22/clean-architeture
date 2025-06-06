plugins {
    id("java")
    id("org.springframework.boot") version "3.1.3"
    id("io.spring.dependency-management") version "1.1.3"
}


group = "org.example"

repositories {
    mavenCentral()
}

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-devtools")
        implementation("org.springframework.boot:spring-boot-starter-validation")
        // implementation("org.springframework.boot:spring-boot-starter-security")

        implementation("com.auth0:java-jwt:4.2.1")
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok")

        implementation("org.flywaydb:flyway-core")
        implementation("org.flywaydb:flyway-mysql")

        runtimeOnly("com.h2database:h2")
        runtimeOnly("com.mysql:mysql-connector-j")
        implementation("org.apache.commons:commons-lang3:3.8.1")

        testImplementation("org.springframework.boot:spring-boot-starter-test")

        implementation(project(":core"))
        implementation(project(":usecase"))
        implementation(project(":application"))

        testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    }

tasks.test {
    useJUnitPlatform()
}