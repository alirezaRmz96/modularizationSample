package com.example.loginData.remote

import com.example.loginDomain.LoginProperty

data class LoginPropertyResponse(
    val token: String?,
) {
    fun toLoginProperty() = LoginProperty(
        token = token.orEmpty()
    )
}