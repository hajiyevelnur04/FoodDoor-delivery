package com.runle.fooddoor.viewmodel.itemviewmodel

import com.runle.fooddoor.R
import com.runle.fooddoor.model.PopularModel
import com.runle.fooddoor.presentation.fragment.home.HomeViewModel

class PopularItemListingViewModel(
   val popularModel: PopularModel,
    private val onItemClick: (String) -> Unit
) : ItemViewModel {

    override val layoutId: Int = R.layout.partial_item_popular

    override val viewType: Int = HomeViewModel.LISTING_ITEM

    fun onClick() {
        onItemClick("${popularModel.title}")
    }
}