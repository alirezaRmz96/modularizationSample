package com.example.userDomain

import com.example.userDomain.UserData
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUserRemote()
    fun getUserLocal(): Flow<List<UserData>>
}