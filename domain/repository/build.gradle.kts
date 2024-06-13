plugins {
    id("young.r2.android.library")
}

android {
    namespace = "com.young.r2.repository"
}

dependencies {
    implementation(projects.domain.model)
    implementation(projects.core.common)
}