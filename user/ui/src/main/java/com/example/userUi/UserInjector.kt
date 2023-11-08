package com.example.userUi

import androidx.lifecycle.LifecycleOwner

interface UserInjector {
    fun inject(fragment: UserFragment, viewLifecycleOwner: LifecycleOwner)
}