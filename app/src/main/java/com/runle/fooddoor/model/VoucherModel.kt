package com.runle.fooddoor.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VoucherModel(
    @SerializedName("id")
    val id:Int?,
    @SerializedName("cover")
    val image:String?,
    @SerializedName("title")
    val title:String?,
    @SerializedName("description")
    val description:String?
): Parcelable