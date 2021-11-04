package com.runle.fooddoor.di

import android.content.Context
import com.runle.fooddoor.BuildConfig
import com.runle.fooddoor.data.api.ApiHelper
import com.runle.fooddoor.data.api.ApiHelperImpl
import com.runle.fooddoor.data.api.ApiService
import com.runle.fooddoor.util.*
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

    single<ApiHelper> { return@single ApiHelperImpl(get()) }
}

private fun provideNetworkHelper(context: Context) = AndroidUtils(context)


