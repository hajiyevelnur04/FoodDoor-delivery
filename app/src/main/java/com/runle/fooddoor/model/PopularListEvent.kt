package com.runle.fooddoor.model

/**
 * Created by elnur on 26.10.21
 */
sealed class PopularListEvent {
    data class ShowSelectedPopular(val title: String): PopularListEvent()
}