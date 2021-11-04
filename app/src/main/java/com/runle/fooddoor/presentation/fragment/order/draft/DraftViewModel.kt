package com.runle.fooddoor.presentation.fragment.order.draft

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.runle.fooddoor.R
import com.runle.fooddoor.model.*
import com.runle.fooddoor.provider.DataProvider
import com.runle.fooddoor.viewmodel.itemviewmodel.*
import kotlinx.coroutines.launch

class DraftViewModel(var dataProvider: DataProvider): ViewModel() {

    companion object {
        const val HEADER_ITEM = 0
        const val LISTING_ITEM = 1
    }

    val draftData: LiveData<List<ItemViewModel>> get() = _draftData
    private val _draftData = MutableLiveData<List<ItemViewModel>>(emptyList())

    val eventsDraft: LiveData<Event<ItemListEvent>> get() = _eventsDraft
    private val _eventsDraft = MutableLiveData<Event<ItemListEvent>>()


    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {

            // create popular list
            val popularList = dataProvider.getPopularListData()

            val popularById = popularList.groupBy { it.title }

            val viewData = createViewData(popularById)
            _draftData.postValue(viewData)

        }
    }


    private fun createViewData(popularById: Map<String, List<PopularModel>>): List<ItemViewModel> {
        val viewData = mutableListOf<ItemViewModel>()
        popularById.keys.forEach {
            val popularItems = popularById[it]
            popularItems?.forEach {popularItem: PopularModel ->
                viewData.add(ItemListingViewModel(popularItem,R.layout.partial_item_draft, LISTING_ITEM, ::onPopularItemListingClicked))
            }
        }

        return viewData
    }


    private fun onPopularItemListingClicked(model: Any) {
        _eventsDraft.postValue(Event(ItemListEvent.ShowSelectedModel(model)))
    }

}