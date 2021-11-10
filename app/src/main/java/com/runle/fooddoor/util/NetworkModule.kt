package com.runle.fooddoor.util

import android.content.Context
import com.runle.fooddoor.BuildConfig
import com.runle.fooddoor.data.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.BufferedInputStream
import java.security.KeyStore
import java.security.cert.CertificateFactory
import java.util.concurrent.TimeUnit
import javax.net.ssl.*

/**
 * Created by elnur on 04.11.21
 */

const val CONNECT_TIME_OUT = 300L
const val READ_TIMEOUT = 300L

fun provideOkHttpClient(context: Context) = if (BuildConfig.DEBUG) {
    val sslContext = SSLContext.getInstance("TLS")
    var trustManagers: Array<TrustManager> = emptyArray()

    try {
        val keyStore: KeyStore = KeyStore.getInstance(KeyStore.getDefaultType())
        keyStore.load(null, null)

        val certInputStream = context.assets.open(Constants.PEM_FILE)
        val bis = BufferedInputStream(certInputStream)
        val certificateFactory = CertificateFactory.getInstance("X.509")

        while (bis.available() > 0) {
            val cert = certificateFactory.generateCertificate(bis)
            keyStore.setCertificateEntry("www.test.com/main", cert)
        }

        val trustManagerFactory =
            TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        trustManagerFactory.init(keyStore)
        trustManagers = trustManagerFactory.trustManagers

        sslContext.init(null, trustManagers, null)

    } catch (e: Exception) {
        e.printStackTrace()
    }

    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    OkHttpClient.Builder()
        .addInterceptor(provideLoggingInterceptor())
        .hostnameVerifier(provideHostnameVerifier())
        .sslSocketFactory(sslContext.socketFactory, trustManagers[0] as X509TrustManager)
        .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .build()
} else OkHttpClient
    .Builder()
    .build()

fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

//fun provideRxJavaCallAdapter(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

fun provideLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

fun provideHostnameVerifier(
) = HostnameVerifier { _, _ ->
    return@HostnameVerifier true
}

fun provideRetrofit(
    okHttpClient: OkHttpClient,
    BASE_URL: String
): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

fun provideApiService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)