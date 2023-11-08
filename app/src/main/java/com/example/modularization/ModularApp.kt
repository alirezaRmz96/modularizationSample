package com.example.modularization

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import com.example.core.utils.di.ModularComponent
import com.example.core.utils.di.ModularComponentKey
import com.example.core.utils.di.ModularComponentProvider
import com.example.modularization.di.BaseComponentProvider

class ModularApp : Application(), ModularComponentProvider {

    private lateinit var componentProvider: ModularComponentProvider

    override fun onCreate() {
        componentProvider = BaseComponentProvider(this)
        super.onCreate()

    }

    /*private val netWorkComponent: NetWorkComponent by lazy {
        DaggerNetWorkComponent.factory().create()
    }

    private val contextComponent: ContextComponent by lazy {
        DaggerContextComponent.factory().create(this)
    }

    private val databaseComponent: DataBaseComponent by lazy {
        DaggerDataBaseComponent.factory().create(
            contextComponent = contextComponent
        )
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
    }*/
    override fun provideComponent(modularComponentKey: ModularComponentKey, lifecycleOwner: LifecycleOwner?): ModularComponent {
        if (!::componentProvider.isInitialized)
            throw IllegalStateException("component is not create yet what fuck are you doing???")
        return componentProvider.provideComponent(modularComponentKey, lifecycleOwner)
    }

    override fun garbageComponent(modularComponentKey: ModularComponentKey) {
        componentProvider.garbageComponent(modularComponentKey)
    }


}