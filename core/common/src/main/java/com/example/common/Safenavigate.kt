package com.example.common

import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.safeNavigate(navigationAction: NavigationAction, id: Int? = null) {
    try {
        findNavController().navigate(
            deepLink = getUriFromActions(navigationAction),
        )
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    }
}
fun getUriFromActions(navigationAction: NavigationAction) =
    "samangar-app://${navigationAction.module}/${navigationAction.fragmentId}${navigationAction.getArgsDeepLink()}"
        .toUri()
