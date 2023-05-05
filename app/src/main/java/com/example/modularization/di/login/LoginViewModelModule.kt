package com.example.modularization.di.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loginUi.LoginViewModel
import com.example.modularization.di.ModularViewModelFactory
import com.example.modularization.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ModularViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel
}