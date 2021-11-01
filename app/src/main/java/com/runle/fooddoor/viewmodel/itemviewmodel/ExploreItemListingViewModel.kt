package com.runle.fooddoor.viewmodel.itemviewmodel

import com.runle.fooddoor.R
import com.runle.fooddoor.model.ExploreModel
import com.runle.fooddoor.presentation.fragment.explore.ExploreViewModel


class ExploreItemListingViewModel(
   val model: ExploreModel,
    private val onItemClick: (String) -> Unit
) : ItemViewModel {

    override val layoutId: Int = R.layout.partial_item_explore

    override val viewType: Int = ExploreViewModel.LISTING_ITEM

    fun onClick() {
        onItemClick("${model.title}")
    }
}