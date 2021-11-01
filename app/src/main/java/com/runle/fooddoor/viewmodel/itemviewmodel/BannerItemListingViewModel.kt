package com.runle.fooddoor.viewmodel.itemviewmodel

import com.runle.fooddoor.R
import com.runle.fooddoor.model.BannerModel
import com.runle.fooddoor.presentation.fragment.home.HomeViewModel

class BannerItemListingViewModel(
   val bannerModel: BannerModel,
    private val onItemClick: (String) -> Unit
) : ItemViewModel {

    override val layoutId: Int = R.layout.partial_item_banner

    override val viewType: Int = HomeViewModel.LISTING_ITEM

    fun onClick() {
        onItemClick("${bannerModel.title}")
    }
}