package com.example.loginUi.daggerLogin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.common.dagger.ModularViewModelFactory
import com.example.common.dagger.ViewModelKey
import com.example.loginUi.LoginViewModel
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