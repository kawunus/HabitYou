package com.kawunus.habitu.core

import android.app.Application
import com.kawunus.habitu.di.dataModule
import com.kawunus.habitu.di.interactorModule
import com.kawunus.habitu.di.repositoryModule
import com.kawunus.habitu.di.utilModule
import com.kawunus.habitu.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HabituApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HabituApplication)
            modules(dataModule, repositoryModule, interactorModule, utilModule, viewModelModule)
        }
    }
}