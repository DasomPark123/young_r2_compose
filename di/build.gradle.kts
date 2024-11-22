plugins {
    id("young.r2.android.library")
    id("young.r2.android.network")
}

android {
    namespace = "com.young.r2.di"
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.domain.repository)
    implementation(projects.data.repositoryImpl)
    implementation(projects.data.api)
}
