package com.example.userData.dataSource.remote

import com.example.data.BaseRemoteDataSource
import com.google.gson.Gson
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(
    private val service: UserService,
    gson: Gson,
) : BaseRemoteDataSource(gson = gson), UserRemoteDataSource {
    override suspend fun getUser(): List<UserResponse> {
        return service.getUser(page = 1).bodyOrThrow()
    }
}