package com.software.kremiks.justnews.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class AppModule {
    @Binds
    internal abstract fun bindContext(application: Application): Context
}