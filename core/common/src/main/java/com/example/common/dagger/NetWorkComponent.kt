package com.example.common.dagger

import com.google.gson.Gson
import dagger.Component
import retrofit2.Retrofit

@NetWorkScope
@Component(modules = [NetWorkModule::class])
interface NetWorkComponent {

    fun gson(): Gson
    fun retrofit(): Retrofit


    @Component.Factory
    interface Factory {
        fun create(): NetWorkComponent
    }
}