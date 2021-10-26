package com.runle.fooddoor.di

import android.content.Context
import com.runle.fooddoor.BuildConfig
import com.runle.fooddoor.data.api.ApiHelper
import com.runle.fooddoor.data.api.ApiHelperImpl
import com.runle.fooddoor.data.api.ApiService
import com.runle.fooddoor.util.AndroidUtils
import com.runle.fooddoor.util.Constants
import com.runle.fooddoor.util.PreferenceHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by elnur on 26.10.21
 */
val appModule = module {
    single { PreferenceHelper.customPrefs(androidContext(), Constants.SHARED_PREFERENCES_NAME) }
    single { provideOkHttpClient() }
    single { provideRetrofit(get(), Constants.BASE_URL) }
    single { provideApiService(get()) }
    single { provideNetworkHelper(androidContext()) }

    single<ApiHelper> {
        return@single ApiHelperImpl(get())
    }
}

private fun provideNetworkHelper(context: Context) = AndroidUtils(context)

private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
} else OkHttpClient
    .Builder()
    .build()

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    BASE_URL: String
): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

private fun provideApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)
