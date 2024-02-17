@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.kotlin.plugin.spring) apply false
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.spring.dependency.management)
}

allprojects {
    group = "kr.disdong"
    version = "0.0.1-SNAPSHOT"
    repositories {
        mavenCentral()
    }
}

subprojects {
    val libs = rootProject.libs
    apply(plugin = libs.plugins.kotlin.jvm.get().pluginId)
    apply(plugin = libs.plugins.kotlin.plugin.spring.get().pluginId)
    apply(plugin = libs.plugins.spring.boot.get().pluginId)
    apply(plugin = libs.plugins.spring.dependency.management.get().pluginId)
    apply(plugin = libs.plugins.kotlin.kapt.get().pluginId)
    apply(plugin = libs.plugins.ktlint.get().pluginId)

    dependencies {
        implementation(platform(libs.spring.cloud.dependencies))
        implementation(libs.kotlin.reflect)
        implementation(libs.kotlin.stdlib.jdk8)
        implementation(libs.jackson.module.kotlin)
        implementation(libs.spring.boot.configuration.processor)
        implementation(libs.springdoc.openapi.starter.webmvc.ui)

        testImplementation(libs.spring.boot.starter.test)
        testImplementation(libs.mockito.kotlin)
        testImplementation(libs.fixture.monkey.starter.kotlin)
    }

    java.sourceCompatibility = JavaVersion.VERSION_19

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "19"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        // 유닛 테스트만 돌리고 싶은 경우: ./gradlew test -Punit
        if (project.hasProperty("unit")) {
            exclude("**/*ITest.*")
        }
    }

    tasks.getByName("bootJar") {
        enabled = false
    }

    tasks.getByName("jar") {
        enabled = true
    }
}

val prettier by tasks.registering(Exec::class) {
    commandLine("npx", "prettier", ".", "--write")
}

val secretFiles = listOf(
    "ENV_SERVER" to "virtual-drivers-server/src/main/resources/application.yaml",
    "ENV_PERSISTENCE" to "virtual-drivers-persistence/src/main/resources/persistence.yaml",
    "ENV_CACHE" to "virtual-drivers-cache/src/main/resources/cache.yaml",
    "ENV_API_CLIENT" to "virtual-drivers-api-client/src/main/resources/api-client.yaml",
    "ENV_POSITION_HANDLER" to "internal/virtual-drivers-position-handler/src/main/resources/application.yaml",
    // "AWS_EC2_PEM" to "infra/terraform/app/prod/virtual_drivers_server_keypair.pem"
)

val ghSecretSet = tasks.register("env") {
    secretFiles.forEach { (secretName, filePath) ->
        exec {
            commandLine("bash", "-c", "gh secret set $secretName < ./$filePath")
        }
    }
}

tasks.getByName("ktlintFormat") {
    dependsOn(prettier)
}
