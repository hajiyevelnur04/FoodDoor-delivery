package com.runle.fooddoor.data.api.call

import com.runle.fooddoor.data.network.handler.Resource
import com.runle.fooddoor.data.network.handler.ResponseHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by elnur on 04.11.21
 */
suspend fun <T> safeApiCall(responseHandler: ResponseHandler, apiCall: suspend () -> T): Resource<T> {
    return withContext(Dispatchers.IO) {
        try {
            responseHandler.handleSuccess(apiCall.invoke())
        } catch (e: Exception) {
            e.printStackTrace()
            responseHandler.handleException(e)
        }
    }
}