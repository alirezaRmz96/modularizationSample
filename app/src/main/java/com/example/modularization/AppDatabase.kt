package com.example.modularization

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.userData.dataSource.local.UserDao
import com.example.userData.dataSource.local.UserDataEntity

@Database(entities = [UserDataEntity::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun userDao(): UserDao
}