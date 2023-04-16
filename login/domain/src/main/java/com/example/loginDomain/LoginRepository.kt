package com.example.loginDomain

interface LoginRepository {
    suspend fun getUserLogin(login: Login): LoginProperty
}