package com.kawunus.habityou.core

import android.app.Application
import com.kawunus.habityou.di.dataModule
import com.kawunus.habityou.di.interactorModule
import com.kawunus.habityou.di.repositoryModule
import com.kawunus.habityou.di.utilModule
import com.kawunus.habityou.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HabitYouApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HabitYouApplication)
            modules(dataModule, repositoryModule, interactorModule, utilModule, viewModelModule)
        }
    }
}