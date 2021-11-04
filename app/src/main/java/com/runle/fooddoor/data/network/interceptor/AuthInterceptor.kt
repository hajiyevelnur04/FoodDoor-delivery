package com.runle.fooddoor.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request =
            chain.request().newBuilder().apply {

                /*if (prefs?.isJoined() == true)
                    addHeader("Authorization", "Bearer ${prefs?.getToken()}")
                        .addHeader("Accept-Lang", prefs?.getLanguage().toString())*/
            }
                .build()
        return chain.proceed(request)
    }
}