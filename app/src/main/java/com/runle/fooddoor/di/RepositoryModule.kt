package com.runle.fooddoor.di

import com.runle.fooddoor.provider.DataProvider
import org.koin.dsl.module

/**
 * Created by elha on 06.10.2021.
 */

val repoModule = module {
    single { DataProvider() }
}
