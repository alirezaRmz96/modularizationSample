package com.example.modularization.di

import com.example.loginUi.LoginInjector
import dagger.Component

@LoginScope
@Component(
    modules = [
        LoginModule::class,
        LoginViewModelModule::class
    ], dependencies = [NetWorkComponent::class]
)
interface LoginComponent : LoginInjector {

    @Component.Factory
    interface Factory {
        fun create(netWorkComponent: NetWorkComponent): LoginComponent
    }
}