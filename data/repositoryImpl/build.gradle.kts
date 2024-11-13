plugins {
    id("young.r2.android.library")
}

android {
    namespace = "com.young.r2.repositoryimpl"
}

dependencies {
    implementation(projects.data.model)
    implementation(projects.domain.repository)
}