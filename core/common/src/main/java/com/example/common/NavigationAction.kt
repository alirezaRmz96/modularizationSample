package com.example.common

interface NavigationAction {
    val fragmentId: String
    val module: String
    fun getArgsDeepLink(): String = ""
}
