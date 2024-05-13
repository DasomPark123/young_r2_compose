import com.young.r2.configureHiltAndroid
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

plugins {
    id("young.r2.android.library")
    id("young.r2.android.compose")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

configureHiltAndroid()

dependencies {
    implementation(project(":core:designSystem"))
    implementation(project(":core:common"))
    implementation(project(":domain:usecase"))
}