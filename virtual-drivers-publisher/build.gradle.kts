dependencies {
    implementation(project(":virtual-drivers-domain"))
    implementation(project(":virtual-drivers-common"))
    implementation(libs.spring.boot.starter.data.redis)
}
