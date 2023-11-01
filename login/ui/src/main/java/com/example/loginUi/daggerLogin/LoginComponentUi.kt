package com.example.loginUi.daggerLogin

import com.example.login.domainProvider.LoginComponent
import com.example.loginUi.LoginInjector
import dagger.Component

@LoginUiScope
@Component(
    modules = [
        LoginViewModelModule::class
    ],
    dependencies = [
        LoginComponent::class
    ]
)
interface LoginComponentUi : LoginInjector {

    @Component.Factory
    interface Factory {
        fun create(
            loginComponent: LoginComponent
        ): LoginComponentUi
    }

    companion object {
        /*fun builder():LoginComponentUi{

        }*/
    }
}