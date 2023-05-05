package com.example.loginData.remote

import com.example.loginDomain.Login

data class LoginRequest(
    val email: String,
    val password: String,
)

fun Login.toRequest() = LoginRequest(
    email = email,
    password = password
)