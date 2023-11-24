package com.example.common

import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

fun Fragment.safeNavigate(route: String, routeName: String? = null) {
    try {
        val builder = routeName?.let {
            NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setPopUpTo(
                    it,
                    true
                ).build()
        }
        findNavController().navigate(
            route = route,
            navOptions = builder
        )
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    }
}
