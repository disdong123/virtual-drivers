dependencies {
    api(project(":virtual-drivers-persistence"))
    api(project(":virtual-drivers-domain"))
    implementation(project(":virtual-drivers-common"))
    implementation(project(":virtual-drivers-api-client"))
    implementation(libs.spring.boot.starter.web)

    testImplementation(libs.h2.database)
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}
