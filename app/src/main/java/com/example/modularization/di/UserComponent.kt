package com.example.modularization.di

import dagger.Component

@UserScope
@Component(
    modules = [UserModule::class, UserViewModelModule::class], dependencies = [
        NetWorkComponent::class,
        DataBaseComponent::class
    ]
)
interface UserComponent {

    @Component.Factory
    interface Factory {
        fun create(
            netWorkComponent: NetWorkComponent,
            dataBaseComponent: DataBaseComponent,
        ): UserComponent
    }
}