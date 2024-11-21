package com.young.r2

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureRetrofit() {
    val libs = extensions.libs
    androidExtension.apply {
        dependencies {
            "implementation"(libs.findLibrary("retrofit2").get())
            "implementation"(libs.findLibrary("retrofit2.converter.gson").get())
            "implementation"(libs.findLibrary("retrofit2.kotlinx.serialization.converter").get())
        }
    }
}

internal fun Project.configureOkHttp() {
    val libs = extensions.libs
    androidExtension.apply {
        dependencies {
            "implementation"(libs.findLibrary("okhttp3").get())
            "implementation"(libs.findLibrary("okhttp3.logging.interceptor").get())
        }
    }
}

internal fun Project.configureGson() {
    val libs = extensions.libs
    androidExtension.apply {
        dependencies {
            "implementation"(libs.findLibrary("google.gson").get())
        }
    }
}

internal fun Project.configureSerializationJson() {
    val libs = extensions.libs
    androidExtension.apply {
        dependencies {
            "implementation"(libs.findLibrary("kotlinx.serialization.json").get())
        }
    }
}