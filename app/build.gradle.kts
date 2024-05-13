plugins {
    id("young.r2.android.application")
}

android {
    namespace = "com.young.r2.compose"

    defaultConfig {
        applicationId = "com.young.r2.compose"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.feature.main)
    implementation(projects.feature.barcode)
    implementation(projects.feature.nutrient)
    implementation(projects.feature.product)
}