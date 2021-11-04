package com.runle.fooddoor.data.repository

import com.runle.fooddoor.data.api.call.safeApiCall
import com.runle.fooddoor.data.api.services.OrderServices
import com.runle.fooddoor.data.network.handler.ResponseHandler

/**
 * Created by elnur on 04.11.21
 */
class OrderRepository(private val orderServices: OrderServices,
                      private val responseHandler: ResponseHandler
) {
    suspend fun getOrders() = safeApiCall(responseHandler = responseHandler) { orderServices.getOrders() }
}