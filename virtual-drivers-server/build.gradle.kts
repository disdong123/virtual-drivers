dependencies {
    implementation(project(":virtual-drivers-persistence"))
    implementation(project(":virtual-drivers-domain"))
    implementation(project(":virtual-drivers-common"))
    implementation(project(":virtual-drivers-api-client"))
    implementation(project(":virtual-drivers-cache"))
    implementation(project(":virtual-drivers-broadcast"))
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.thymeleaf)

    testImplementation(libs.h2.database)
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}
