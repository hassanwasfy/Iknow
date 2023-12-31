pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "IKnow"
include(":app")
include(":entities")
include(":local")
include(":remote")
include(":repository")
include(":ui")
include(":usecase")
include(":viewmodels")
include(":exception")



include(":firebase")
