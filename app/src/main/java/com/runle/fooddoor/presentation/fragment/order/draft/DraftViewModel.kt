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

    val popularData: LiveData<List<ItemViewModel>> get() = _popularData
    private val _popularData = MutableLiveData<List<ItemViewModel>>(emptyList())

    val eventsPopular: LiveData<Event<ItemListEvent>> get() = _eventsPopular
    private val _eventsPopular = MutableLiveData<Event<ItemListEvent>>()


    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {

            // create popular list
            val popularList = dataProvider.getPopularListData()

            val popularById = popularList.groupBy { it.title }

            val viewData = createViewData(popularById)
            _popularData.postValue(viewData)

        }
    }


    private fun createViewData(popularById: Map<String, List<PopularModel>>): List<ItemViewModel> {
        val viewData = mutableListOf<ItemViewModel>()
        popularById.keys.forEach {
            val popularItems = popularById[it]
            popularItems?.forEach {popularItem: PopularModel ->
                val item = if (popularItem.isHeader) {
                    HeaderViewModel("Popular",popularItem)
                } else {
                    ItemListingViewModel(popularItem,R.layout.partial_item_draft, LISTING_ITEM, ::onPopularItemListingClicked)
                }
                viewData.add(item)
            }
        }

        return viewData
    }


    private fun onPopularItemListingClicked(model: Any) {
        _eventsPopular.postValue(Event(ItemListEvent.ShowSelectedModel(model)))
    }

}