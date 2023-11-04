package com.example.data.dagger

import android.content.Context
import com.example.data.NetworkConnectivity
import dagger.BindsInstance
import dagger.Component

@ContextScope
@Component
interface ContextComponent {
    fun context(): Context
    fun network(): NetworkConnectivity
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ContextComponent
    }
}