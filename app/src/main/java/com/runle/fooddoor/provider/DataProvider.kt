package com.runle.fooddoor.provider

/**
 * Created by elnur on 26.10.21
 */

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.runle.fooddoor.model.*

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

    suspend fun getExploreListData(): List<ExploreModel> {
        val typeToken = object : TypeToken<List<ExploreModel>>() {}.type
        return gson.fromJson(getExploreString(), typeToken)
    }

    suspend fun getCategoriesListData(): List<CategoryModel> {
        val typeToken = object : TypeToken<List<CategoryModel>>() {}.type
        return gson.fromJson(getCategoriesString(), typeToken)
    }

    suspend fun getLanguagesListData(): List<LanguageModel> {
        val typeToken = object : TypeToken<List<LanguageModel>>() {}.type
        return gson.fromJson(getLanguagesString(), typeToken)
    }

    private fun getLanguagesString(): String {
        return """
            [{"id":1, "title":"English","description":""},
            {"id":2, "title":"Russian","description":""},
            {"id":3, "title":"Azerbaijani","description":""}]""".trimIndent()
    }

    private fun getBannerString(): String {
        return """
            [{"id":1, "image":"R.drawable.test_food","title":"Rice","description":""},
            {"id":2 , "image":"R.drawable.test_food","title":"Noodle","description":""},
            {"id":3, "image":"R.drawable.test_food","title":"Salad","description":""}]""".trimIndent()
    }

    private fun getExploreString(): String {
        return """
            [{"id":1, "image":"R.drawable.test_food","title":"Frash Fruits and Vegetable","description":""},
            {"id":2 , "image":"R.drawable.test_food","title":"Cooking Oil and Ghee","description":""},
            {"id":3 , "image":"R.drawable.test_food","title":"Meat and Fish","description":""},
            {"id":4 , "image":"R.drawable.test_food","title":"Bakery and Snacks","description":""},
            {"id":5 , "image":"R.drawable.test_food","title":"Dairy and Eggs","description":""},
            {"id":6 , "image":"R.drawable.test_food","title":"Beverages","description":""},
            {"id":7, "image":"R.drawable.test_food","title":"Salad","description":""}]""".trimIndent()
    }

    suspend fun getVoucherListData(): List<VoucherModel> {
        val typeToken = object : TypeToken<List<VoucherModel>>() {}.type
        return gson.fromJson(getVoucherString(), typeToken)
    }


    private fun getPopularString(): String {
        return """
            [{"image":"R.drawable.test_food","title":"Rice"},
            {"image":"R.drawable.test_nut","title":"Noodle"},
            {"image":"R.drawable.test_plate","title":"MacChicken"},
            {"image":"R.drawable.test_meat","title":"Bozartma"},
            {"image":"R.drawable.test_draft","title":"Dolma"},
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

    private fun getCategoriesString(): String {
        return """
            [{"id": 1,"title":"Breakfast", "image":R.drawable.test_food,"price":"${'$'}12.60"},
            {"id": 2,"title":"Rice", "image":R.drawable.test_food,"price":"${'$'}12.60"},
            {"id": 3,"title":"Super Deal", "image":R.drawable.test_food,"price":"${'$'}12.60"},
            {"id": 4,"title":"Drink", "image":R.drawable.test_food,"price":"${'$'}12.60"},
            {"id": 5,"title":"Fresh", "image":R.drawable.test_food,"price":"${'$'}12.60"},
            {"id": 6,"title":"Fast food", "image":R.drawable.test_food,"price":"${'$'}12.60"},
            {"id": 7,"title":"Launch", "image":R.drawable.test_food,"price":"${'$'}12.60"},
            {"id": 8,"title":"Fast food", "image":R.drawable.test_food,"price":"${'$'}12.60"},
            {"id": 9,"title":"Launch", "image":R.drawable.test_food,"price":"${'$'}12.60"},
            {"id": 10,"title":"Fast food", "image":R.drawable.test_food,"price":"${'$'}12.60"},
            {"id": 11,"title":"Launch", "image":R.drawable.test_food,"price":"${'$'}12.60"},
            {"id": 12,"title":"Chocolate", "image":R.drawable.test_food,"price":"${'$'}12.60"}]""".trimIndent()
    }


    private fun getVoucherString(): String {
        return """
            [{"id":1, "image":"R.drawable.test_food","title":"Rice","description":""},
            {"id":2 , "image":"R.drawable.test_food","title":"Noodle","description":""},
            {"id":3 , "image":"R.drawable.test_food","title":"Noodle","description":""},
            {"id":3, "image":"R.drawable.test_food","title":"Salad","description":""}]""".trimIndent()
    }

}