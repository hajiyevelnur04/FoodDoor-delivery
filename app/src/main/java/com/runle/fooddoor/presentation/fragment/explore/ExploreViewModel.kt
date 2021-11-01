package com.runle.fooddoor.presentation.fragment.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.runle.fooddoor.model.*
import com.runle.fooddoor.provider.DataProvider
import com.runle.fooddoor.viewmodel.itemviewmodel.BannerItemListingViewModel
import com.runle.fooddoor.viewmodel.itemviewmodel.ExploreItemListingViewModel
import com.runle.fooddoor.viewmodel.itemviewmodel.ItemViewModel
import kotlinx.coroutines.launch

class ExploreViewModel (var dataProvider: DataProvider): ViewModel() {

    companion object {
        const val LISTING_ITEM = 0
    }

    val exploreData: LiveData<List<ItemViewModel>> get() = _exploreData
    private val _exploreData = MutableLiveData<List<ItemViewModel>>(emptyList())

    val eventsExplore: LiveData<Event<ExploreListEvent>> get() = _eventsExplore
    private val _eventsExplore = MutableLiveData<Event<ExploreListEvent>>()

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
                viewData.add(ExploreItemListingViewModel(model,:: onExploreItemListingClicked))
            }
        }

        return viewData
    }

    private fun onExploreItemListingClicked(title: String) {
        _eventsExplore.postValue(Event(ExploreListEvent.ShowSelectedPopular(title)))
    }

}