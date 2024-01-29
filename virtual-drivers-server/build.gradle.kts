dependencies {
    api(project(":virtual-drivers-persistence"))
    api(project(":virtual-drivers-domain"))
    implementation(project(":virtual-drivers-common"))
    implementation(project(":virtual-drivers-api-client"))
    implementation(libs.spring.boot.starter.web)
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation(libs.h2.database)
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}
