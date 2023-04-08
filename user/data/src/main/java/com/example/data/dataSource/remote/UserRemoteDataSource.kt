package com.example.data.dataSource.remote

interface UserRemoteDataSource {
    suspend fun getUser(): List<UserResponse>
}