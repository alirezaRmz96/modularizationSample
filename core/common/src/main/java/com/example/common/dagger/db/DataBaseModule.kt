package com.example.common.dagger.db

import android.content.Context
import androidx.room.Room
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


    /*@Provides
    fun provideContext(@BindsInstance applicationContext: Context): Context {
        return applicationContext
    }*/
}