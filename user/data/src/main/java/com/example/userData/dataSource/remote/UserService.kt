package com.example.userData.dataSource.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("users")
    suspend fun getUser(
        @Query("page")
        page: Int = 1,
    ): Response<List<UserResponse>>
}