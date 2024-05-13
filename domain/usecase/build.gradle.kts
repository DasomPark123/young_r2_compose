plugins {
    id("young.r2.android.library")
}

android {
    namespace = "com.young.r2.usecase"
}

dependencies {
    implementation(projects.domain.model)
    implementation(projects.domain.repository)
}