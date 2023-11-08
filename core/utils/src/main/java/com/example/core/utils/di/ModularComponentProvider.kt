package com.example.core.utils.di

import androidx.lifecycle.LifecycleOwner

interface ModularComponentProvider {
    fun provideComponent(modularComponentKey: ModularComponentKey, lifecycleOwner: LifecycleOwner? = null): ModularComponent
    fun garbageComponent(modularComponentKey: ModularComponentKey)
}

