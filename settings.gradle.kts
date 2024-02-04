rootProject.name = "virtual-drivers"

include(
    "virtual-drivers-api-client",
    "virtual-drivers-broadcast",
    "virtual-drivers-cache",
    "virtual-drivers-domain",
    "virtual-drivers-persistence",
    "virtual-drivers-common",
    "virtual-drivers-server"
)

enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        maven {
            url = uri("https://maven.pkg.github.com/disdong123/version-catalog")
            credentials {
                // PAT, github username 을 환경변수 (.zshrc 등)로 저장해야합니다.
                username = System.getenv("DISDONG_USERNAME")
                password = System.getenv("DISDONG_TOKEN")
            }
        }
    }
    versionCatalogs {
        create("libs") {
            from("kr.disdong:spring-version-catalog:0.0.27")
        }
    }
}
