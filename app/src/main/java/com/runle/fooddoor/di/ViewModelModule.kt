package com.runle.fooddoor.di

import com.runle.fooddoor.presentation.fragment.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by elha on 14.10.2021.
 */
val viewModelModule = module {
    viewModel {
        HomeViewModel(get())
    }
}