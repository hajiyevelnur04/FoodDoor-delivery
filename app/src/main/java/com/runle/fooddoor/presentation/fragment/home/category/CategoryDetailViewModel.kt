package com.runle.fooddoor.presentation.fragment.home.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.runle.fooddoor.model.*
import com.runle.fooddoor.provider.DataProvider
import com.runle.fooddoor.viewmodel.itemviewmodel.CategoriesItemListingViewModel
import com.runle.fooddoor.viewmodel.itemviewmodel.ItemViewModel
import kotlinx.coroutines.launch

class CategoryDetailViewModel(var dataProvider: DataProvider): ViewModel() {
    companion object {
        const val LISTING_ITEM = 0
    }

    val categoryData: LiveData<List<ItemViewModel>> get() = _categoryData
    private val _categoryData = MutableLiveData<List<ItemViewModel>>(emptyList())

    val eventsCategory: LiveData<Event<CategoryListEvent>> get() = _eventsCategory
    private val _eventsCategory = MutableLiveData<Event<CategoryListEvent>>()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            // create banner list

            val categoryList = dataProvider.getCategoriesListData()

            val categoryById = categoryList.groupBy { it.id }

            val exploreViewData = createCategoryViewData(categoryById)
            _categoryData.postValue(exploreViewData)
        }
    }

    private fun createCategoryViewData(exploreById: Map<Long?, List<CategoryModel>>): List<ItemViewModel> {
        val viewData = mutableListOf<ItemViewModel>()
        exploreById.keys.forEach {
            exploreById[it]?.forEach {model: CategoryModel ->
                viewData.add(CategoriesItemListingViewModel(model,:: onCategoryItemListingClicked))
            }
        }

        return viewData
    }

    private fun onCategoryItemListingClicked(title: String) {
        _eventsCategory.postValue(Event(CategoryListEvent.ShowSelectedPopular(title)))
    }
}