package com.runle.fooddoor.model

/**
 * Created by elnur on 26.10.21
 */
sealed class BannerListEvent {
    data class ShowSelectedPopular(val title: String): BannerListEvent()
}