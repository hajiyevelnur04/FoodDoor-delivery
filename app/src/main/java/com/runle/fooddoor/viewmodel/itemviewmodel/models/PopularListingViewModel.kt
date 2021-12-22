package com.runle.fooddoor.viewmodel.itemviewmodel.models

import com.runle.fooddoor.model.PopularModel
import com.runle.fooddoor.viewmodel.itemviewmodel.ItemViewModel

class PopularListingViewModel(
    val model: PopularModel,
    val layout: Int,
    _viewType: Int,
    private val onItemClick: (Any) -> Unit
) : ItemViewModel {

    override val layoutId: Int = layout

    override val viewType: Int = _viewType

    fun onClick() {
        onItemClick("$model")
    }
}