plugins {
    id("young.r2.android.library")
}

android {
    namespace = "com.young.r2.api"
}

dependencies {
    implementation(projects.domain.model)
    implementation(libs.serialization.json)
    implementation(libs.bundles.okhttp)
    implementation(libs.bundles.retrofit)
}