package com.runle.fooddoor.presentation.view.lang

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.runle.fooddoor.base.BaseViewModel
import com.runle.fooddoor.data.enums.LanguageEnum
import com.runle.fooddoor.viewmodel.itemviewmodel.ItemViewModel

/**
 * Created by elnur on 24.11.21
 */
class LanguageBottomSheetViewModel: BaseViewModel() {

    private val _currentLanguage = MutableLiveData<LanguageEnum>()
    val currentLanguage: LiveData<LanguageEnum> get() = _currentLanguage

    private val _disMiss = MutableLiveData<Boolean>()
    val disMiss: LiveData<Boolean> get() = _disMiss

    val languageData: LiveData<List<ItemViewModel>> get() = _languageData
    private val _languageData = MutableLiveData<List<ItemViewModel>>(emptyList())

    init {
        _disMiss.postValue(false)
        _currentLanguage.postValue(LanguageEnum.AZ)
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