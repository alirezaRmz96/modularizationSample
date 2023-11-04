package com.example.loginData.remote

import com.example.data.BaseRemoteDataSource
import com.google.gson.Gson
import javax.inject.Inject

class LoginRemoteDataSourceImpl @Inject constructor(
    private val loginService: LoginService,
    gson: Gson
) : BaseRemoteDataSource(gson = gson), LoginRemoteDataSource {
    override suspend fun getLogin(loginRequest: LoginRequest): LoginPropertyResponse {
        return loginService.login(loginRequest).bodyOrThrow()
    }

}