package com.young.r2.api.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.young.r2.api.BarcodeApiService
import com.young.r2.api.ProductApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
internal object AppModule {

    @Singleton
    @Provides
    fun provideConverterJson(): Converter.Factory = Json {
        isLenient = true // Json 큰따옴표 느슨하게 체크
        ignoreUnknownKeys = true // 필드 값이 없는 경우 무시
        coerceInputValues = true // value가 null인 경우 default value로 대체
    }.asConverterFactory("application/json".toMediaType())

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()

    @Singleton
    @Provides
    fun provideProductApi(okHttpClient: OkHttpClient, convertJson: Converter.Factory): com.young.r2.api.ProductApiService {
        return Retrofit.Builder()
            .baseUrl("http://apis.data.go.kr")
            .addConverterFactory(convertJson)
            .client(okHttpClient).build()
            .create(com.young.r2.api.ProductApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideBarcodeApi(okHttpClient: OkHttpClient, convertJson: Converter.Factory): com.young.r2.api.BarcodeApiService {
        return Retrofit.Builder()
            .baseUrl("https://openapi.foodsafetykorea.go.kr")
            .addConverterFactory(convertJson)
            .client(okHttpClient).build()
            .create(com.young.r2.api.BarcodeApiService::class.java)
    }
}