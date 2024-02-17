dependencies {
    implementation(project(":virtual-drivers-domain"))
    implementation(project(":virtual-drivers-common"))
    implementation(libs.gson)
    implementation(libs.spring.cloud.starter.openfeign)
}
