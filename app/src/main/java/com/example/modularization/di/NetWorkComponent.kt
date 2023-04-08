package com.example.modularization.di

import dagger.Component

@NetWorkScope
@Component(modules = [NetWorkModule::class])
interface NetWorkComponent {
    @Component.Factory
    interface Factory {
        fun create(): NetWorkComponent
    }
}