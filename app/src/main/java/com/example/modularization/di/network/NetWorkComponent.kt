package com.example.modularization.di.network

import com.example.core.utils.di.ModularComponent
import com.google.gson.Gson
import dagger.Component
import retrofit2.Retrofit

@NetWorkScope
@Component(modules = [NetWorkModule::class])
interface NetWorkComponent : ModularComponent {
    fun gson(): Gson
    fun retrofit(): Retrofit
    @Component.Factory
    interface Factory {
        fun create(): NetWorkComponent
    }
    companion object{
        fun create():NetWorkComponent{
            return DaggerNetWorkComponent.factory().create()
        }
    }
}