package com.runle.fooddoor.presentation.view.lang

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.runle.fooddoor.R
import com.runle.fooddoor.base.BaseViewModel
import com.runle.fooddoor.data.enums.LanguageEnum
import com.runle.fooddoor.model.Event
import com.runle.fooddoor.model.ItemListEvent
import com.runle.fooddoor.model.LanguageModel
import com.runle.fooddoor.provider.DataProvider
import com.runle.fooddoor.viewmodel.itemviewmodel.ItemListingViewModel
import com.runle.fooddoor.viewmodel.itemviewmodel.ItemViewModel
import kotlinx.coroutines.launch

/**
 * Created by elnur on 24.11.21
 */
class LanguageBottomSheetViewModel(var dataProvider: DataProvider): BaseViewModel() {

    companion object {
        const val LISTING_ITEM = 0
    }

    private val _currentLanguage = MutableLiveData<LanguageEnum>()
    val currentLanguage: LiveData<LanguageEnum> get() = _currentLanguage

    private val _disMiss = MutableLiveData<Boolean>()
    val disMiss: LiveData<Boolean> get() = _disMiss

    val languageData: LiveData<List<ItemViewModel>> get() = _languageData
    private val _languageData = MutableLiveData<List<ItemViewModel>>(emptyList())

    val eventsLanguage: LiveData<Event<ItemListEvent>> get() = _eventsLanguage
    private val _eventsLanguage = MutableLiveData<Event<ItemListEvent>>()

    init {
        loadLanguages()
        _disMiss.postValue(false)
        _currentLanguage.postValue(LanguageEnum.AZ)
    }

    private fun loadLanguages(){
        viewModelScope.launch {
            // create banner list

            val langList = dataProvider.getLanguagesListData()

            val langListById = langList.groupBy { it.id }

            val exploreViewData = createLangViewData(langListById)
            _languageData.postValue(exploreViewData)
        }
    }

    private fun createLangViewData(langListById: Map<Int, List<LanguageModel>>): List<ItemViewModel> {
        val viewData = mutableListOf<ItemViewModel>()
        langListById.keys.forEach {
            langListById[it]?.forEach {model: LanguageModel ->
                viewData.add(
                    ItemListingViewModel(model, R.layout.partial_item_language,
                        LISTING_ITEM,:: onCategoryItemListingClicked)
                )
            }
        }

        return viewData
    }

    private fun onCategoryItemListingClicked(model: Any) {
        _eventsLanguage.postValue(Event(ItemListEvent.ShowSelectedModel(model)))
    }

    fun doneDisMiss() {
        _disMiss.postValue(false)
    }

    fun languageBtnClick(languageEnum: LanguageEnum) {
        _currentLanguage.postValue(languageEnum)
        //prefs?.setLanguage(languageEnum)
        _disMiss.postValue(true)
    }

}