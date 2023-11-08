package com.example.modularization.di.database

import android.content.Context
import androidx.room.Room
import com.example.modularization.AppDatabase
import com.example.modularization.ModularApp
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

}