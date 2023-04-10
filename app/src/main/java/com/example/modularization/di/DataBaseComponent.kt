package com.example.modularization.di

import android.content.Context
import com.example.modularization.AppDatabase
import com.example.modularization.ModularApp
import dagger.BindsInstance
import dagger.Component

@DataBaseScope
@Component(modules = [DataBaseModule::class])
interface DataBaseComponent {

    fun appDataBase(): AppDatabase
    fun context(): Context

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance app: ModularApp
        ): DataBaseComponent
    }
}