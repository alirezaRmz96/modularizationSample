package com.example.modularization.di

import android.content.Context
import androidx.room.Room
import com.example.modularization.AppDatabase
import com.example.modularization.ModularApp
import dagger.BindsInstance
import dagger.Module
import dagger.Provides

@Module
object DataBaseModule {

    @Provides
    fun provideAppDataBase(
        context: Context,
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "modular_db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    fun provideContext(modularApp: ModularApp): Context {
        return modularApp.applicationContext
    }
}