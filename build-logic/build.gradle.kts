plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidHilt") {
            id = "com.young.r2.hilt"
            implementationClass = "com.young.r2.HiltAndroidPlugin"
        }
        register("kotlinHilt") {
            id = "com.young.r2.hilt"
            implementationClass = "com.young.r2.HiltKotlinPlugin"
        }
    }
}