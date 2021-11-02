package com.runle.fooddoor.model

/**
 * Created by elnur on 26.10.21
 */
sealed class ItemListEvent {
    data class ShowSelectedModel(val model: Any): ItemListEvent()
}