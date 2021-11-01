package com.runle.fooddoor.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryModel(
    @SerializedName("id")
    var id: Long?,
    @SerializedName("title")
    val title: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("price")
    val price: String
): Parcelable