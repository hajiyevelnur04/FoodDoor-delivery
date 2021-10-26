package com.runle.fooddoor.data

import okhttp3.Headers
import retrofit2.Response

/**
 * Created by elha on 02.09.2021.
 */
sealed class ApiResponse<T> {
    companion object{
        fun <T> create(error: Throwable): ApiErrorResponse<T> {
            return ApiErrorResponse(error.message ?: "Unknown error",0)
        }

        fun <T> create(response: Response<T>): ApiResponse<T> {
            return if(response.isSuccessful){
                val body = response.body()
                val headers = response.headers()
                if(body == null || response.code() == 204){
                    ApiEmptyResponse()
                } else {
                    ApiSuccessResponse(
                        body,
                        headers
                    )
                }
            } else {
                val msg = response.errorBody()?.string()
                val errorMsg = if(msg.isNullOrEmpty()){
                    response.message()
                } else {
                    msg
                }

                ApiErrorResponse(
                    errorMsg ?: "Unknown error",
                    response.code()
                )
            }
        }
    }
}


data class ApiErrorResponse<T>(val errorMessages: String, val statusCode: Int) : ApiResponse<T>()

class ApiEmptyResponse<T> : ApiResponse<T>()

data class ApiSuccessResponse<T>(
    val body: T?,
    val headers: Headers
) : ApiResponse<T>()