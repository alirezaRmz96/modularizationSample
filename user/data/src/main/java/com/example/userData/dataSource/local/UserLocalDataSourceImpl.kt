package com.example.userData.dataSource.local

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserLocalDataSourceImpl @Inject constructor(
    private val userDao: UserDao,
) : UserLocalDataSource {
    override suspend fun insertUsers(users: List<UserDataEntity>) {
        userDao.insertUsers(users)
    }

    override fun getUsers(): Flow<List<UserDataEntity>> {
        return userDao.getUsers()
    }
}