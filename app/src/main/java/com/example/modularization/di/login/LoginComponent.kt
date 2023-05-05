package com.example.modularization.di.login

import com.example.loginUi.LoginInjector
import com.example.modularization.di.DataBaseComponent
import com.example.modularization.di.NetWorkComponent
import dagger.Component

@LoginScope
@Component(
    modules = [
        LoginModule::class,
        LoginViewModelModule::class
    ], dependencies = [NetWorkComponent::class, DataBaseComponent::class]
)
interface LoginComponent : LoginInjector {

    @Component.Factory
    interface Factory {
        fun create(
            netWorkComponent: NetWorkComponent,
            dataBaseComponent: DataBaseComponent,
        ): LoginComponent
    }
}