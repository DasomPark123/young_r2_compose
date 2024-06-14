plugins {
    id("young.r2.android.library")
}

android {
    namespace = "com.young.r2.common"
}

dependencies {
    implementation(libs.bundles.lifecycle)
}