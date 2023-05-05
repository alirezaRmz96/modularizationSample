package com.example.modularization

import android.app.Application
import com.example.loginUi.LoginFragment
import com.example.loginUi.LoginInjector
import com.example.modularization.di.*
import com.example.modularization.di.login.DaggerLoginComponent
import com.example.modularization.di.user.DaggerUserComponent
import com.example.userUi.UserFragment
import com.example.userUi.UserInjector

class ModularApp : Application(), UserInjector,LoginInjector {

    private val netWorkComponent: NetWorkComponent by lazy {
        DaggerNetWorkComponent.factory().create()
    }

    private val databaseComponent: DataBaseComponent by lazy {
        DaggerDataBaseComponent.factory().create(this)
    }

    override fun inject(fragment: UserFragment) {
        DaggerUserComponent.factory().create(
            netWorkComponent = netWorkComponent,
            dataBaseComponent = databaseComponent
        ).inject(fragment)
    }

    override fun inject(fragment: LoginFragment) {
        DaggerLoginComponent.factory().create(
            netWorkComponent = netWorkComponent,
            dataBaseComponent = databaseComponent
        ).inject(fragment)
    }


}