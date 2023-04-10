package com.example.userData.dataSource.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<UserDataEntity>)

    @Query("SELECT * FROM users")
    fun getUsers(): Flow<List<UserDataEntity>>
}