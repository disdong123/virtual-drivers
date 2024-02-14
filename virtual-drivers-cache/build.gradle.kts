dependencies {
    implementation(project(":virtual-drivers-domain"))
    implementation(libs.spring.boot.starter.cache)
    api(libs.spring.boot.starter.data.redis)
    implementation("com.github.ben-manes.caffeine:caffeine:3.1.8")
}
