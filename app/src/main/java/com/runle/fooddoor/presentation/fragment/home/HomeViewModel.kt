package com.runle.fooddoor.presentation.fragment.home

import android.icu.text.CaseMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.runle.fooddoor.viewmodel.itemviewmodel.ItemViewModel
import com.runle.fooddoor.model.Event
import com.runle.fooddoor.model.PopularListEvent
import com.runle.fooddoor.model.PopularModel
import com.runle.fooddoor.provider.DataProvider
import com.runle.fooddoor.viewmodel.itemviewmodel.HeaderViewModel
import com.runle.fooddoor.viewmodel.itemviewmodel.PopularItemListingViewModel
import kotlinx.coroutines.launch

class HomeViewModel(var dataProvider: DataProvider): ViewModel() {

    companion object {
        const val HEADER_ITEM = 0
        const val LISTING_ITEM = 1
    }

    val data: LiveData<List<ItemViewModel>> get() = _data
    private val _data = MutableLiveData<List<ItemViewModel>>(emptyList())

    val events: LiveData<Event<PopularListEvent>> get() = _events
    private val _events = MutableLiveData<Event<PopularListEvent>>()


    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val popularList = dataProvider.getPopularListData()

            val popularById = popularList.groupBy { it.title }

            val viewData = createViewData(popularById)
            _data.postValue(viewData)
        }
    }

    private fun createViewData(popularById: Map<String, List<PopularModel>>): List<ItemViewModel> {
        val viewData = mutableListOf<ItemViewModel>()
        popularById.keys.forEach {
            viewData.add(HeaderViewModel(it))
            val popularItems = popularById[it]
            popularItems?.forEach {popularItems: PopularModel ->
                val item = if (popularItems.isHeader) {
                    HeaderViewModel("Popular")
                } else {
                    PopularItemListingViewModel(popularItems, ::onPopularItemListingClicked)
                }
                viewData.add(item)
            }
        }

        return viewData
    }

    private fun onPopularItemListingClicked(title: String) {
        _events.postValue(Event(PopularListEvent.ShowSelectedPopular(title)))
    }

}