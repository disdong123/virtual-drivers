@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.plugin.jpa)
}

dependencies {
    implementation(project(":virtual-drivers-domain"))
    api(libs.spring.boot.starter.data.jpa)
    implementation(libs.querydsl.jpa) {
        artifact {
            classifier = "jakarta"
        }
    }
    kapt(libs.querydsl.apt) {
        artifact {
            classifier = "jakarta"
        }
    }
    kapt(libs.jakarta.persistence.api)
    kapt(libs.jakarta.annotation.api)
    runtimeOnly(libs.mysql.connector.java)
    implementation(libs.gson)
}
