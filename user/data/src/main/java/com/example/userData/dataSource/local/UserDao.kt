package com.example.userData.dataSource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insertUsers(users: List<UserDataEntity>)

    @Query("SELECT * FROM Users")
    fun getUsers(): Flow<List<UserDataEntity>>
}