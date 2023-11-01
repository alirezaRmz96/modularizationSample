package com.example.user.domainpovider

import com.example.common.dagger.NetWorkComponent
import com.example.common.dagger.db.DataBaseComponent
import com.example.userDomain.UserRepository
import dagger.Component

@UserScope
@Component(
    modules = [UserModule::class], dependencies = [
        NetWorkComponent::class,
        DataBaseComponent::class
    ]
)
interface UserComponent {

    fun userRepository(): UserRepository

    @Component.Factory
    interface Factory {
        fun create(
            netWorkComponent: NetWorkComponent,
            dataBaseComponent: DataBaseComponent,
        ): UserComponent
    }

}