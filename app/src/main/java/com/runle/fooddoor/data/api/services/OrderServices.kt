package com.runle.fooddoor.data.api.services

import com.runle.fooddoor.model.BannerModel
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by elnur on 04.11.21
 */
interface OrderServices {

    @GET("orders")
    suspend fun getOrders(): Response<List<BannerModel>>

    @GET("orderById")
    suspend fun getOrderById(): Response<List<BannerModel>>
}