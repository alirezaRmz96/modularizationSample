package com.example.modularization.di.login

import com.example.core.utils.di.ModularComponent
import com.example.loginUi.LoginInjector
import com.example.modularization.di.database.DataBaseComponent
import com.example.modularization.di.network.NetWorkComponent
import dagger.Component

@LoginScope
@Component(
    modules = [
        LoginModule::class,
        LoginViewModelModule::class
    ], dependencies = [NetWorkComponent::class, DataBaseComponent::class]
)
interface LoginComponent : ModularComponent, LoginInjector {

    @Component.Factory
    interface Factory {
        fun create(
            netWorkComponent: NetWorkComponent,
            dataBaseComponent: DataBaseComponent,
        ): LoginComponent
    }

    companion object {
        fun create(
            netWorkComponent: NetWorkComponent,
            dataBaseComponent: DataBaseComponent
        ): LoginComponent {
            return DaggerLoginComponent.factory().create(
                netWorkComponent, dataBaseComponent
            )
        }
    }
}