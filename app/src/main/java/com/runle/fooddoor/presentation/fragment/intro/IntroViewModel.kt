package com.runle.fooddoor.presentation.fragment.intro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.viewpager.widget.ViewPager
import com.runle.fooddoor.base.BaseViewModel

class IntroViewModel : BaseViewModel() {

    private val _navigateToLogin = MutableLiveData<Boolean?>()
    val navigateToLogin: LiveData<Boolean?>
        get() = _navigateToLogin

    private val _navigateToMain = MutableLiveData<Boolean?>()
    val navigateToMain: LiveData<Boolean?>
        get() = _navigateToMain

    private val _navigateToPicker = MutableLiveData<Boolean?>()
    val navigateToPicker: LiveData<Boolean?>
        get() = _navigateToPicker

    private val _currentPosition = MutableLiveData<Int>().apply { value = 0 }
    val currentPosition: LiveData<Int>
        get() = _currentPosition


    var pageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {

        }

        override fun onPageSelected(position: Int) {
            _currentPosition.value = position
        }

        override fun onPageScrollStateChanged(state: Int) {

        }

    }


    fun skipBtnClick() {

        if (_currentPosition.value == 3 || _currentPosition.value == 0)
            _navigateToLogin.value = true
        else
            decrementPositionValue()
    }

    fun nextBtnClick() {

        if (_currentPosition.value == 3)
            _navigateToLogin.value = true
        else
            incrementPositionValue()
    }

    private fun incrementPositionValue() {
        _currentPosition.value = _currentPosition.value?.let {
            it + 1
        }
    }

    private fun decrementPositionValue() {
        _currentPosition.value = _currentPosition.value?.let {
            it - 1
        }
    }

    fun createBtnClick() {
        _navigateToMain.value = true
    }

    fun doneLoginNavigation() {
        _navigateToLogin.value = false
    }

    fun doneMainNavigation() {
        _navigateToMain.value = false
    }

}
