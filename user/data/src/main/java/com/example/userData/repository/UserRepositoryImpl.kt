package com.example.userData.repository

import android.util.Log
import com.example.userData.dataSource.local.UserLocalDataSource
import com.example.userData.dataSource.remote.UserRemoteDataSource
import com.example.userDomain.UserData
import com.example.userDomain.UserRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: UserRemoteDataSource,
    private val localDataSource: UserLocalDataSource,
) : UserRepository {
    override suspend fun getUserRemote() {
        remoteDataSource.getUser()?.let {userDataResponses ->
            localDataSource.insertUsers(userDataResponses.map { it.toUserDataEntity() })
        }
    }

    override fun getUserLocal(): Flow<List<UserData>> {
        return localDataSource.getUsers().map { userDataEntity ->
            userDataEntity.map { it.toUserData() }
        }
    }


}