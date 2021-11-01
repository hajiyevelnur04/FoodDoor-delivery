package com.runle.fooddoor.viewmodel.itemviewmodel

import com.runle.fooddoor.R
import com.runle.fooddoor.model.CategoryModel
import com.runle.fooddoor.presentation.fragment.home.HomeViewModel

class CategoryItemListingViewModel(
   val model: CategoryModel,
    private val onItemClick: (String) -> Unit
) : ItemViewModel {

    override val layoutId: Int = R.layout.partial_item_category

    override val viewType: Int = HomeViewModel.LISTING_ITEM

    fun onClick() {
        onItemClick("${model.title}")
    }
}