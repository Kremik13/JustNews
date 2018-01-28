package com.software.kremiks.justnews.data.remote

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi = NewsApi.Factory.service
}