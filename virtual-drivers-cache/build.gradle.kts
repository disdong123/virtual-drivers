dependencies {
    implementation(project(":virtual-drivers-domain"))
    implementation(libs.spring.boot.starter.cache)
    implementation(libs.spring.boot.starter.data.redis)
}
