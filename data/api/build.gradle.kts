plugins {
    id("young.r2.android.library")
    id("young.r2.android.network")
}

android {
    namespace = "com.young.r2.api"
}

dependencies {
    implementation(projects.data.model)
    implementation(projects.core.common)
}