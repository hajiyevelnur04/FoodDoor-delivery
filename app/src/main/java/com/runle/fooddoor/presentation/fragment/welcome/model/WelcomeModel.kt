package com.runle.fooddoor.presentation.fragment.welcome.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by elha on 10.08.2021.
 */
@Parcelize
data class WelcomeModel(
    var logo: String,
    var title: String,
    var description: String,
    var contentImage: Int,
    var duration: Long,
    var backgroundColor: String,
    var getStartedButtonText: String = "Get Started",
    var isLastModel: Boolean? = false
): Parcelable


@Parcelize
class WelcomeModels: ArrayList<WelcomeModel>(), Parcelable