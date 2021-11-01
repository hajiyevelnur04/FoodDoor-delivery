package com.runle.fooddoor.provider

/**
 * Created by elnur on 26.10.21
 */

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.runle.fooddoor.model.BannerModel
import com.runle.fooddoor.model.CategoryModel
import com.runle.fooddoor.model.PopularModel
import com.runle.fooddoor.model.VoucherModel

class DataProvider {

    private val gson = Gson()

    suspend fun getBannerListData(): List<BannerModel> {
        val typeToken = object : TypeToken<List<BannerModel>>() {}.type
        return gson.fromJson(getBannerString(), typeToken)
    }

    suspend fun getPopularListData(): List<PopularModel> {
        val typeToken = object : TypeToken<List<PopularModel>>() {}.type
        return gson.fromJson(getPopularString(), typeToken)
    }

    suspend fun getCategoryListData(): List<CategoryModel> {
        val typeToken = object : TypeToken<List<CategoryModel>>() {}.type
        return gson.fromJson(getCategoryString(), typeToken)
    }

    private fun getBannerString(): String {
        return """
            [{"id":1, "image":"R.drawable.test_food","title":"Rice","description":""},
            {"id":2 , "image":"R.drawable.test_food","title":"Noodle","description":""},
            {"id":3, "image":"R.drawable.test_food","title":"Salad","description":""}]""".trimIndent()
    }

    suspend fun getVoucherListData(): List<VoucherModel> {
        val typeToken = object : TypeToken<List<VoucherModel>>() {}.type
        return gson.fromJson(getVoucherString(), typeToken)
    }


    private fun getPopularString(): String {
        return """
            [{"image":"R.drawable.test_food","title":"Rice"},
            {"image":"R.drawable.test_food","title":"Noodle"},
            {"image":"R.drawable.test_food","title":"MacChicken"},
            {"image":"R.drawable.test_food","title":"Bozartma"},
            {"image":"R.drawable.test_food","title":"Dolma"},
            {"image":"R.drawable.test_food","title":"Salad"}]""".trimIndent()
    }

    private fun getCategoryString(): String {
        return """
            [{"id": 1,"title":"Breakfast", "image":R.drawable.test_food,"price":"${'$'}12.60"},
            {"id": 2,"title":"Rice", "image":R.drawable.test_food,"price":"${'$'}12.60"},
            {"id": 3,"title":"Super Deal", "image":R.drawable.test_food,"price":"${'$'}12.60"},
            {"id": 4,"title":"Drink", "image":R.drawable.test_food,"price":"${'$'}12.60"},
            {"id": 5,"title":"Fresh", "image":R.drawable.test_food,"price":"${'$'}12.60"},
            {"id": 6,"title":"Fast food", "image":R.drawable.test_food,"price":"${'$'}12.60"},
            {"id": 7,"title":"Launch", "image":R.drawable.test_food,"price":"${'$'}12.60"},
            {"id": 8,"title":"Chocolate", "image":R.drawable.test_food,"price":"${'$'}12.60"}]""".trimIndent()
    }


    private fun getVoucherString(): String {
        return """
            [{"id":1, "image":"R.drawable.test_food","title":"Rice","description":""},
            {"id":2 , "image":"R.drawable.test_food","title":"Noodle","description":""},
            {"id":3 , "image":"R.drawable.test_food","title":"Noodle","description":""},
            {"id":3, "image":"R.drawable.test_food","title":"Salad","description":""}]""".trimIndent()
    }

}