package com.runle.fooddoor.viewmodel.itemviewmodel

class ItemListingViewModel(
    val model: Any,
    val layout: Int,
    _viewType: Int,
    private val onItemClick: (Any) -> Unit
) : ItemViewModel {

    override val layoutId: Int = layout

    override val viewType: Int = _viewType

    override val _model: Any = model

    fun onClick() {
        onItemClick("$model")
    }
}