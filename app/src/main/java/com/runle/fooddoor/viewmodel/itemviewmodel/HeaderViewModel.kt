package com.runle.fooddoor.viewmodel.itemviewmodel

import com.runle.fooddoor.R
import com.runle.fooddoor.presentation.fragment.home.HomeViewModel

class HeaderViewModel(val title: String, override val _model: Any) : ItemViewModel {

    override val layoutId: Int = R.layout.partial_item_header

    override val viewType: Int = HomeViewModel.HEADER_ITEM
}