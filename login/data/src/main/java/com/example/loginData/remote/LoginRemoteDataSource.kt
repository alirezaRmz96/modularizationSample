package com.example.loginData.remote

interface LoginRemoteDataSource {
    suspend fun getLogin(loginRequest: LoginRequest):LoginPropertyResponse
}