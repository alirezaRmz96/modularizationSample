package com.example.userData.dataSource.local

import kotlinx.coroutines.flow.Flow

interface UserLocalDataSource {
    suspend fun insertUsers(users: List<UserDataEntity>)
    fun getUsers(): Flow<List<UserDataEntity>>
}