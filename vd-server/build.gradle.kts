dependencies {
    api(project(":vd-persistence"))
    implementation(project(":vd-common"))
    implementation(libs.spring.boot.starter.web)
}

tasks.getByName("bootJar") {
    enabled = true
}

tasks.getByName("jar") {
    enabled = false
}
