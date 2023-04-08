package com.example.modularization.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.userUi.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class UserViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ModularViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    internal abstract fun bindDashboardViewModel(viewModel: UserViewModel): ViewModel
}