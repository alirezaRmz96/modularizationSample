package com.example.modularization.di.context

import android.app.Application
import android.content.Context
import com.example.core.utils.di.ModularComponent
import dagger.BindsInstance
import dagger.Component

@ContextScope
@Component(
    modules = [
        ContextModule::class
    ]
)
interface ContextComponent : ModularComponent {

    fun context(): Context
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ContextComponent
    }
    companion object{
        fun create(
            application: Application
        ):ContextComponent{
            return DaggerContextComponent.factory().create(application)
        }
    }
}