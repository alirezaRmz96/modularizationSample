package com.example.userUi

import androidx.fragment.app.Fragment
import com.example.core.utils.di.ModularComponentProvider
import com.example.core.utils.di.ModularFeatureComponentKey

fun Fragment.provideInjector(): UserInjector {
    val component = (activity?.application as? ModularComponentProvider)?.provideComponent(
        ModularFeatureComponentKey.User
    ) ?: throw IllegalStateException("Could Not Find User Component")

    return (component as? UserInjector)
        ?: throw IllegalStateException("Could Not Find User Component")
}