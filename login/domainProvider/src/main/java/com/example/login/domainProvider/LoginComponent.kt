package com.example.login.domainProvider

import com.example.common.dagger.NetWorkComponent
import com.example.common.dagger.db.DataBaseComponent
import com.example.common.dagger.db.DataBaseScope
import com.example.loginDomain.LoginRepository
import dagger.Component

@LoginScope
@Component(
    modules = [
        LoginModule::class,

    ], dependencies = [NetWorkComponent::class, DataBaseComponent::class]
)
interface LoginComponent {

    fun repository(): LoginRepository

    @Component.Factory
    interface Factory {
        fun create(
            netWorkComponent: NetWorkComponent,
            dataBaseComponent: DataBaseComponent,
        ): LoginComponent
    }
}