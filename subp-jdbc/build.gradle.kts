dependencies {
    implementation(project(":subp-domain"))
    api(libs.spring.boot.starter.data.jdbc)
    runtimeOnly(libs.mysql.connector.java)
}
