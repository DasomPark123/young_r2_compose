import com.young.r2.configureCoroutineAndroid
import com.young.r2.configureHiltAndroid
import com.young.r2.configureKotest
import com.young.r2.configureKotlinAndroid

plugins {
    id("com.android.library")
}

configureKotlinAndroid()
configureKotest()
configureCoroutineAndroid()
configureHiltAndroid()