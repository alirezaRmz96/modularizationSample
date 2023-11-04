package com.example.common.dagger.db

import com.example.data.NetworkConnectivity
import com.example.data.dagger.ContextComponent
import dagger.Component

@DataBaseScope
@Component(modules = [DataBaseModule::class], dependencies = [ContextComponent::class])
interface DataBaseComponent {


    fun appDataBase(): AppDatabase
    fun network(): NetworkConnectivity

    @Component.Factory
    interface Factory {
        fun create(
            contextComponent: ContextComponent
        ): DataBaseComponent
    }
}