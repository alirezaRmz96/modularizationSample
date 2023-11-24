package com.example.modularization.di.user

import com.example.core.utils.di.ModularComponent
import com.example.modularization.di.database.DataBaseComponent
import com.example.modularization.di.network.NetWorkComponent
import com.example.userUi.UserInjector
import dagger.Component

@UserScope
@Component(
    modules = [UserModule::class, UserViewModelModule::class], dependencies = [
        NetWorkComponent::class,
        DataBaseComponent::class
    ]
)
interface UserComponent : ModularComponent, UserInjector {

    @Component.Factory
    interface Factory {
        fun create(
            netWorkComponent: NetWorkComponent,
            dataBaseComponent: DataBaseComponent,
        ): UserComponent
    }

    companion object {
        fun create(
            netWorkComponent: NetWorkComponent,
            dataBaseComponent: DataBaseComponent
        ): UserComponent {
            return DaggerUserComponent.factory().create(
                netWorkComponent, dataBaseComponent
            )
        }
    }
}