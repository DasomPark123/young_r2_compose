plugins {
    id("young.r2.android.library")
    id("young.r2.android.network")
}

android {
    namespace = "com.young.r2.model"
}

dependencies {
    implementation(projects.data.repositoryImpl)
}