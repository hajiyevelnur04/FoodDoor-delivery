package com.runle.fooddoor.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by elnur on 03.11.21
 */
@Parcelize
data class LanguageModel(
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var key: String? = null,
    @SerializedName("description")
    var description: String? = null,
    var isSelected: Boolean? = false
) : Parcelable