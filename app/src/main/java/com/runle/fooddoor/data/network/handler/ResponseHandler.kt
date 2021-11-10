package com.runle.fooddoor.data.network.handler

import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import com.runle.fooddoor.data.enums.ErrorCodes
import okio.IOException
import retrofit2.HttpException
import java.net.SocketTimeoutException


open class ResponseHandler {
    fun <T> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T> handleOffline(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T : Any> handleException(e: Exception): Resource<T> {
        e.printStackTrace()

        return when (e) {
            is HttpException -> {

                val errorJsonString = e.response()?.errorBody()?.string()

                val message = try {
                    JsonParser.parseString(errorJsonString)
                        .asJsonObject["message"]
                        .asString
                } catch (e: JsonSyntaxException) {
                    "Internal server error"
                } catch (e: IllegalStateException) {
                    "Internal server error"
                } catch (e: NullPointerException) {
                    "Internal server error"
                } catch (e: Exception) {
                    "Internal server error"
                }

                Resource.error(message, null)
            }
            is SocketTimeoutException -> Resource.error(
                getErrorMessage(ErrorCodes.SocketTimeOut.code),
                null
            )

            is IOException -> Resource.networkError("No internet connection", null)
            else -> Resource.error(getErrorMessage(Int.MAX_VALUE), null)
        }
    }

    private fun getErrorMessage(code: Int): String {
        return when (code) {
            ErrorCodes.SocketTimeOut.code -> "Timeout"
            401 -> "Unauthorised"
            404 -> "Not found"
            500 -> "Internal server error"
            503 -> "Server not response"
            else -> "Something went wrong"
        }
    }

}
