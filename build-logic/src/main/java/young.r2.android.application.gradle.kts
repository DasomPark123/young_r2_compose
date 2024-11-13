import com.young.r2.configureHiltAndroid
import com.young.r2.configureKotest
import com.young.r2.configureKotlinAndroid

plugins {
    id("com.android.application")
}

configureKotlinAndroid()
configureHiltAndroid()
configureKotest()

//TODO: 필요한 플러그인인가??