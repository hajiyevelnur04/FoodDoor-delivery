package com.runle.fooddoor.viewmodel.itemviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.runle.fooddoor.model.CategoryModel
import com.runle.fooddoor.model.PopularModel

class ItemListingViewModel(
    val model: Any,
    val layout: Int,
    _viewType: Int,
    private val onItemClick: (Any) -> Unit
) : ItemViewModel {

    val popularModel: LiveData<PopularModel> get() = _popularData
    private val _popularData = MutableLiveData<PopularModel>()

    val categoryModel: LiveData<CategoryModel> get() = _categoryModel
    private val _categoryModel = MutableLiveData<CategoryModel>()

    override val layoutId: Int = layout

    init {
        if(model is PopularModel){
            _popularData.postValue(model)
        }
        if(model is CategoryModel){
            _categoryModel.postValue(model)
        }
    }
    override val viewType: Int = _viewType

    fun onClick() {
        onItemClick("$model")
    }
}