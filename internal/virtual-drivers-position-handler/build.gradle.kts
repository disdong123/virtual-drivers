dependencies {
    implementation(project(":virtual-drivers-common"))
    implementation(project(":virtual-drivers-domain"))
    implementation(project(":virtual-drivers-cache"))
    implementation(project(":virtual-drivers-persistence"))
    implementation(project(":virtual-drivers-publisher"))
    implementation(libs.spring.boot.starter.web)
}
