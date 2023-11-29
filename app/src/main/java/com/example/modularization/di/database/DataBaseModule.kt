package com.example.modularization.di.database

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.modularization.AppDatabase
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
    fun provideSharedPref(
        context: Context
    ): SharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)


}