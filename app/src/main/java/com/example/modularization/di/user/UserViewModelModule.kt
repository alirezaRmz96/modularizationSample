package com.example.modularization.di.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.common.dagger.ModularViewModelFactory
import com.example.common.dagger.ViewModelKey
import com.example.userUi.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

//@Module
//abstract class UserViewModelModule {
//
//    @Binds
//    abstract fun bindViewModelFactory(factory: ModularViewModelFactory): ViewModelProvider.Factory
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(UserViewModel::class)
//    internal abstract fun bindUserViewModel(viewModel: UserViewModel): ViewModel
//}