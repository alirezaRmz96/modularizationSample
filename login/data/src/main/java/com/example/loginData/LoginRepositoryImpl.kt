package com.example.loginData

import com.example.loginData.remote.LoginRemoteDataSource
import com.example.loginData.remote.toRequest
import com.example.loginDomain.Login
import com.example.loginDomain.LoginProperty
import com.example.loginDomain.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val remote: LoginRemoteDataSource,
) : LoginRepository {
    override suspend fun getUserLogin(login: Login): LoginProperty =
        remote.getLogin(
            login.toRequest()
        ).toLoginProperty()
}