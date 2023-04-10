package com.example.modularization

import android.app.Application
import com.example.modularization.di.*
import com.example.userUi.UserFragment
import com.example.userUi.UserInjector

class ModularApp : Application(), UserInjector {

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


}