package com.example.modularization.di.user

import com.example.modularization.di.DataBaseComponent
import com.example.modularization.di.NetWorkComponent
import com.example.userUi.UserInjector
import dagger.Component

@UserScope
@Component(
    modules = [UserModule::class, UserViewModelModule::class], dependencies = [
        NetWorkComponent::class,
        DataBaseComponent::class
    ]
)
interface UserComponent : UserInjector {

    @Component.Factory
    interface Factory {
        fun create(
            netWorkComponent: NetWorkComponent,
            dataBaseComponent: DataBaseComponent,
        ): UserComponent
    }
}