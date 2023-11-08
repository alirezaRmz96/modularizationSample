package com.example.modularization.di

import android.app.Application
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.example.core.utils.di.ModularBaseComponentKey
import com.example.core.utils.di.ModularComponent
import com.example.core.utils.di.ModularComponentKey
import com.example.core.utils.di.ModularComponentProvider
import com.example.core.utils.di.ModularFeatureComponentKey
import com.example.modularization.di.context.ContextComponent
import com.example.modularization.di.database.DataBaseComponent
import com.example.modularization.di.login.LoginComponent
import com.example.modularization.di.network.NetWorkComponent
import com.example.modularization.di.user.UserComponent
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CopyOnWriteArrayList

class BaseComponentProvider(
    private val application: Application
) : ModularComponentProvider {

    private val component: ConcurrentHashMap<ModularComponentKey, ModularComponent> = ConcurrentHashMap()
    private val observers = ConcurrentHashMap<ModularComponentKey, CopyOnWriteArrayList<LifecycleObserver>>()
    override fun provideComponent(
        modularComponentKey: ModularComponentKey,
        lifecycleOwner: LifecycleOwner?
    ): ModularComponent {
        return component[modularComponentKey] ?: synchronized(component) {
            component[modularComponentKey] ?: createComponent(
                modularComponentKey,
                lifecycleOwner
            ).also {
                component[modularComponentKey] = it
            }
        }
    }

    private fun createComponent(
        key: ModularComponentKey,
        lifecycleOwner: LifecycleOwner?
    ): ModularComponent {
        return when (key) {
            is ModularBaseComponentKey -> {
                when (key) {
                    ModularBaseComponentKey.Context -> {
                        ContextComponent.create(application = application)
                    }

                    ModularBaseComponentKey.DataBase -> {
                        DataBaseComponent.create(
                            contextComponent = findContextComponent()
                        )
                    }

                    ModularBaseComponentKey.Network -> {
                        NetWorkComponent.create()
                    }
                }
            }

            is ModularFeatureComponentKey -> {
                when (key) {
                    ModularFeatureComponentKey.Login -> {
                        LoginComponent.create(
                            netWorkComponent = findNetworkComponent(),
                            dataBaseComponent = findDataBaseComponent()
                        )
                    }

                    ModularFeatureComponentKey.User -> {
                        UserComponent.create(
                            netWorkComponent = findNetworkComponent(),
                            dataBaseComponent = findDataBaseComponent()
                        )
                    }
                }
            }

            else -> {
                throw IllegalStateException("what fuck are you doing???")
            }
        }.also {
            lifecycleOwner ?: return@also
            val observerList = observers[key] ?: CopyOnWriteArrayList<LifecycleObserver>()
            val observer = object : DefaultLifecycleObserver {
                override fun onDestroy(owner: LifecycleOwner) {
                    observerList.remove(this)
                    if(observerList.isEmpty()) {
                        component.remove(key)
                    }
                }
            }
            observerList.add(observer)
            observers[key] = observerList
        }
    }

    override fun garbageComponent(key: ModularComponentKey) {
        when (key) {
            is ModularFeatureComponentKey -> {
                when (key) {
                    ModularFeatureComponentKey.Login -> {
                        component.keys.remove(key)
                    }

                    else -> {}
                }
            }
        }
    }

    private fun findContextComponent(): ContextComponent {
        return provideComponent(ModularBaseComponentKey.Context) as ContextComponent
    }

    private fun findNetworkComponent(): NetWorkComponent {
        return provideComponent(ModularBaseComponentKey.Network) as NetWorkComponent
    }

    private fun findDataBaseComponent(): DataBaseComponent {
        return provideComponent(ModularBaseComponentKey.DataBase) as DataBaseComponent
    }
}