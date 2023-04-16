package com.example.common

sealed interface NavigationActions : NavigationAction{

    object navigateToUserFragment : NavigationActions {
        override val fragmentId: String
            get() = "userFragment"
        override val module: String
            get() = "user:ui"

    }
}
