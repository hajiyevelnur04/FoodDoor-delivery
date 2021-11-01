package com.runle.fooddoor.di

import com.runle.fooddoor.presentation.fragment.explore.ExploreViewModel
import com.runle.fooddoor.presentation.fragment.home.HomeViewModel
import com.runle.fooddoor.presentation.fragment.home.category.CategoryDetailFragment
import com.runle.fooddoor.presentation.fragment.home.category.CategoryDetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by elha on 14.10.2021.
 */
val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { ExploreViewModel(get()) }
    viewModel { CategoryDetailViewModel(get()) }
}