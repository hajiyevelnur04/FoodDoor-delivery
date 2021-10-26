package com.runle.fooddoor.data.api


import com.runle.fooddoor.model.PopularModel
import retrofit2.Response
/**
 * Created by elha on 14.10.2021.
 */
interface ApiHelper {
    suspend fun getBanner(): Response<List<PopularModel>>
}