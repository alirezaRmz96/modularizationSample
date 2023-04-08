package com.example.data.repository

import com.example.data.dataSource.local.UserLocalDataSource
import com.example.data.dataSource.remote.UserRemoteDataSource
import com.example.domain.UserData
import com.example.domain.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: UserRemoteDataSource,
    private val localDataSource: UserLocalDataSource,
) : UserRepository {
    override suspend fun getUserRemote() {
        remoteDataSource.getUser().map { userResponse ->
            localDataSource.insertUsers(
                userResponse.userData.map { it.toUserDataEntity() })
        }
    }

    override fun getUserLocal(): Flow<List<UserData>> {
        return localDataSource.getUsers().map { userDataEntity ->
            userDataEntity.map { it.toUserData() }
        }
    }


}