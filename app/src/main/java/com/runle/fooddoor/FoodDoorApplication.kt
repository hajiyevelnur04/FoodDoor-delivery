package com.runle.fooddoor

import android.app.Application
import com.runle.fooddoor.di.appModule
import com.runle.fooddoor.di.repoModule
import com.runle.fooddoor.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class FoodDoorApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidContext(this@FoodDoorApplication)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }

}