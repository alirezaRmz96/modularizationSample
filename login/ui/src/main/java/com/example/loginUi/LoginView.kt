package com.example.loginUi

import com.example.loginDomain.Login

data class LoginView(
    val email : String,
    val password : String
){
    fun toLogin() = Login(
        email = email,
        password = password
    )
}
