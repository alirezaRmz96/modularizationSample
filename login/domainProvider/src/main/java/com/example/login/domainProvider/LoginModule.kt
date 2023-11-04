package com.example.login.domainProvider

import com.example.loginData.LoginRepositoryImpl
import com.example.loginData.remote.LoginRemoteDataSource
import com.example.loginData.remote.LoginRemoteDataSourceImpl
import com.example.loginData.remote.LoginService
import com.example.loginDomain.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class LoginModule {

    companion object {
        @Provides
        fun provideLoginService(retrofit: Retrofit): LoginService {
            return retrofit.create(LoginService::class.java)
        }
    }
    @Binds
    abstract fun bindLoginRepository(impl: LoginRepositoryImpl): LoginRepository

    @Binds
    abstract fun bindLoginRemoteDataSource(impl: LoginRemoteDataSourceImpl): LoginRemoteDataSource

}