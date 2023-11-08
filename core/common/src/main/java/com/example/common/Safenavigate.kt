package com.example.common

import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

fun Fragment.safeNavigate(navigationAction: NavigationAction, id: Int? = null) {
    try {
        val builder = id?.let {
            NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setPopUpTo(
                    it,
                    true
                ).build()
        }
        findNavController().navigate(
            deepLink = getUriFromActions(navigationAction),
            navOptions = builder
        )
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    }
}
fun getUriFromActions(navigationAction: NavigationAction) =
    "modular-app://${navigationAction.module}/${navigationAction.fragmentId}${navigationAction.getArgsDeepLink()}"
        .toUri()
