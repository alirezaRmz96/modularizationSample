package com.example.common.dagger.db

import android.content.Context
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
            @BindsInstance applicationContext: Context
        ): DataBaseComponent
    }
}