package com.example.modularization

import android.app.Application
import com.example.common.dagger.DaggerNetWorkComponent
import com.example.common.dagger.NetWorkComponent
import com.example.common.dagger.db.DaggerDataBaseComponent
import com.example.common.dagger.db.DataBaseComponent
import com.example.login.domainProvider.DaggerLoginComponent
import com.example.login.domainProvider.LoginComponent
import com.example.loginUi.LoginFragment
import com.example.loginUi.LoginInjector
import com.example.loginUi.daggerLogin.DaggerLoginComponentUi
import com.example.user.domainpovider.DaggerUserComponent
import com.example.user.domainpovider.UserComponent
import com.example.userUi.UserFragment
import com.example.userUi.UserInjector
import com.example.userUi.dagger.DaggerUserUiComponent

class ModularApp : Application(),UserInjector,LoginInjector {

    private val netWorkComponent: NetWorkComponent by lazy {
        DaggerNetWorkComponent.factory().create()
    }
//
    private val databaseComponent: DataBaseComponent by lazy {
        DaggerDataBaseComponent.factory().create(this)
    }

    private val userComponent: UserComponent by lazy {
        DaggerUserComponent.factory().create(
            netWorkComponent,
            databaseComponent
        )
    }

    private val loginComponent: LoginComponent by lazy {
        DaggerLoginComponent.factory().create(
            netWorkComponent,
            databaseComponent
        )
    }

    override fun inject(fragment: UserFragment) {
        DaggerUserUiComponent.factory().create(
            userComponent
        ).inject(fragment = fragment)
    }

    override fun inject(fragment: LoginFragment) {
        DaggerLoginComponentUi.factory().create(
            loginComponent
        ).inject(fragment = fragment)
    }

    /*override fun inject(fragment: LoginFragment) {
        DaggerLoginComponent.factory().create(
            netWorkComponent = netWorkComponent,
            dataBaseComponent = databaseComponent
        ).inject(fragment)
    }*/


}