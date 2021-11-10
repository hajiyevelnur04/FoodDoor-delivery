package com.runle.fooddoor.data.api.call

import android.content.Context
import com.google.gson.Gson
import com.runle.fooddoor.BuildConfig
import com.runle.fooddoor.data.network.handler.Resource
import com.runle.fooddoor.data.network.handler.ResponseHandler
import com.runle.fooddoor.model.BannerModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by elnur on 04.11.21
 */
suspend fun <T> safeApiCall(responseHandler: ResponseHandler, apiCall: suspend () -> T): Resource<T> {
    return if(BuildConfig.isMock){
        withContext(Dispatchers.IO) {
            responseHandler.handleOffline(apiCall.invoke())
        }

    } else {
        withContext(Dispatchers.IO) {
            try {
                responseHandler.handleSuccess(apiCall.invoke())
            } catch (e: Exception) {
                e.printStackTrace()
                responseHandler.handleException(e)
            }
        }
    }
}

suspend inline fun <reified T> readOfflineFile(context: Context, fileName: String) : T {
    return Gson().fromJson(context.assets.open(fileName).bufferedReader().use { it.readText() }, T::class.java)
}