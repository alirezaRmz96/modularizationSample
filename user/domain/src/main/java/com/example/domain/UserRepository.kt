package com.example.domain

import com.example.domain.UserData
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUserRemote()
    fun getUserLocal(): Flow<List<UserData>>
}