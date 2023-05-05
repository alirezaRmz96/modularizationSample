package com.example.modularization.di.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.modularization.di.ModularViewModelFactory
import com.example.modularization.di.ViewModelKey
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
    internal abstract fun bindUserViewModel(viewModel: UserViewModel): ViewModel
}