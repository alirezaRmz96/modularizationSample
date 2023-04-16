package com.example.loginData.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginPropertyResponse>
}