plugins {
    id("young.r2.android.feature")
}

android {
    namespace = "com.young.r2.product"
}

dependencies {
    implementation(projects.domain.repository)
    implementation(projects.domain.model)
}