package com.runle.fooddoor.presentation.fragment.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.runle.fooddoor.R
import com.runle.fooddoor.model.*
import com.runle.fooddoor.provider.DataProvider
import com.runle.fooddoor.viewmodel.itemviewmodel.ItemListingViewModel
import com.runle.fooddoor.viewmodel.itemviewmodel.ItemViewModel
import kotlinx.coroutines.launch

class ExploreViewModel (var dataProvider: DataProvider): ViewModel() {

    companion object {
        const val LISTING_ITEM = 0
    }

    val exploreData: LiveData<List<ItemViewModel>> get() = _exploreData
    private val _exploreData = MutableLiveData<List<ItemViewModel>>(emptyList())

    val eventsExplore: LiveData<Event<ItemListEvent>> get() = _eventsExplore
    private val _eventsExplore = MutableLiveData<Event<ItemListEvent>>()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            // create banner list

            val exploreList = dataProvider.getExploreListData()

            val exploreById = exploreList.groupBy { it.id }

            val exploreViewData = createExploreViewData(exploreById)
            _exploreData.postValue(exploreViewData)
        }
    }

    private fun createExploreViewData(exploreById: Map<Int?, List<ExploreModel>>): List<ItemViewModel> {
        val viewData = mutableListOf<ItemViewModel>()
        exploreById.keys.forEach {
            exploreById[it]?.forEach {model: ExploreModel ->
                viewData.add(ItemListingViewModel(model, R.layout.partial_item_explore,LISTING_ITEM,:: onExploreItemListingClicked))
            }
        }

        return viewData
    }

    private fun onExploreItemListingClicked(model: Any) {
        _eventsExplore.postValue(Event(ItemListEvent.ShowSelectedModel(model)))
    }

}