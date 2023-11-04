package com.example.userData.dataSource.local

interface UserDaoProvider {
    fun userDao(): UserDao
}