package com.runle.fooddoor.viewmodel.itemviewmodel

import com.runle.fooddoor.R
import com.runle.fooddoor.model.CategoryModel
import com.runle.fooddoor.model.VoucherModel
import com.runle.fooddoor.presentation.fragment.home.HomeViewModel

class VoucherItemListingViewModel(
   val model: VoucherModel,
    private val onItemClick: (String) -> Unit
) : ItemViewModel {

    override val layoutId: Int = R.layout.partial_item_voucher

    override val viewType: Int = HomeViewModel.LISTING_ITEM

    fun onClick() {
        onItemClick("${model.title}")
    }
}