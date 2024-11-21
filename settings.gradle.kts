pluginManagement {
    includeBuild("build-logic")
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

rootProject.name = "YoungR2"
include(
    ":app",
    ":core:designSystem",
    ":core:common",

    ":data:repositoryImpl",

    ":domain:model",
    ":domain:repository",
    ":domain:usecase",

    ":feature:barcode",
    ":feature:main",
    ":feature:nutrient",
    ":feature:product"
)
include(":buildsrc")
include(":di")
include(":data:model")
include(":data:api")
