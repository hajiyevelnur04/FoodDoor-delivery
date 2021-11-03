package com.runle.fooddoor.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by elnur on 03.11.21
 */
@Parcelize
data class TrackItem(
    @SerializedName("id")
    var id: Int,
    @SerializedName("key")
    var key: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("created_at")
    var created_at: String? = null,
    @SerializedName("status")
    var status: String? = null
) : Parcelable