package com.example.loginUi

import androidx.fragment.app.Fragment
import com.example.core.utils.di.ActionEntity
import com.example.core.utils.di.BookmarkActionCommand
import com.example.core.utils.di.CommandExecute
import com.example.core.utils.di.ModularComponentProvider
import com.example.core.utils.di.ModularFeatureComponentKey

fun Fragment.provideInjector(): LoginInjector {
    val component = (activity?.application as? ModularComponentProvider)?.provideComponent(
        ModularFeatureComponentKey.Login,
        this
    ) ?: throw IllegalStateException("Could Not Find User Component")

    return (component as? LoginInjector)
        ?: throw IllegalStateException("Could Not Find User Component")
}

fun Fragment.findCommandExecute(
    actions: ActionEntity
): Boolean {
    return (activity as? CommandExecute)?.execute(
        BookmarkActionCommand(actions)
    ) ?: false
}

fun Fragment.garbageInjector() {
    (activity?.application as? ModularComponentProvider)?.garbageComponent(
        ModularFeatureComponentKey.Login
    ) ?: throw IllegalStateException("Could Not Find User Component")
}
