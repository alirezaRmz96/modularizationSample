package com.example.modularization.di.database

import android.content.Context
import android.content.SharedPreferences
import com.example.core.utils.di.ModularComponent
import com.example.modularization.AppDatabase
import com.example.modularization.di.context.ContextComponent
import dagger.Component

@DataBaseScope
@Component(
    modules = [DataBaseModule::class],
    dependencies = [ContextComponent::class]
)
interface DataBaseComponent : ModularComponent {

    fun appDataBase(): AppDatabase
    fun context(): Context
    fun sharedPreferences(): SharedPreferences
    @Component.Factory
    interface Factory {
        fun create(
            contextComponent: ContextComponent
        ): DataBaseComponent
    }

    companion object {
        fun create(
            contextComponent: ContextComponent
        ): DataBaseComponent {
            return DaggerDataBaseComponent.factory().create(contextComponent)
        }
    }
}