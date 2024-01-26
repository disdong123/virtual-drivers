dependencies {
    api(project(":virtual-drivers-persistence"))
    implementation(project(":virtual-drivers-common"))
    implementation(libs.spring.boot.starter.web)
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}
