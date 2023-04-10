package com.example.userData.dataSource.remote

interface UserRemoteDataSource {
    suspend fun getUser(): List<UserDataResponse>?
}