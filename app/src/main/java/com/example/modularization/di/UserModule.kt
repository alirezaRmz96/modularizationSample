package com.example.modularization.di

import com.example.modularization.AppDatabase
import com.example.userData.dataSource.local.UserDao
import com.example.userData.dataSource.local.UserLocalDataSource
import com.example.userData.dataSource.local.UserLocalDataSourceImpl
import com.example.userData.dataSource.remote.UserRemoteDataSource
import com.example.userData.dataSource.remote.UserRemoteDataSourceImpl
import com.example.userData.dataSource.remote.UserService
import com.example.userData.repository.UserRepositoryImpl
import com.example.userDomain.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class UserModule {

    companion object {
        @Provides
        fun provideUserService(retrofit: Retrofit): UserService {
            return retrofit.create(UserService::class.java)
        }
        @Provides
        fun provideUserDao(appDatabase: AppDatabase):UserDao{
            return appDatabase.userDao()
        }
    }

    @Binds
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun bindUserLocalDataSource(impl: UserLocalDataSourceImpl): UserLocalDataSource

    @Binds
    abstract fun bindUserRemoteDataSource(impl: UserRemoteDataSourceImpl): UserRemoteDataSource
}