package com.example.modularization.di.context

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides


@Module
object ContextModule {
    @ContextScope
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }
}