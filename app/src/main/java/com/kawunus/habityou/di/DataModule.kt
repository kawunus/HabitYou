package com.kawunus.habityou.di

import android.content.Context
import androidx.room.Room
import com.kawunus.habityou.core.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {

    single {
        androidContext().getSharedPreferences("local_storage", Context.MODE_PRIVATE)
    }

    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "database.db").build()
    }

    single { get<AppDatabase>().badHabitDao() }

    single { get<AppDatabase>().noteDao() }
}