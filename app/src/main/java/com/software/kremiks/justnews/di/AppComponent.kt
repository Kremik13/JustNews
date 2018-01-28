package com.software.kremiks.justnews.di

import android.app.Application
import com.software.kremiks.justnews.JustNewsApp
import com.software.kremiks.justnews.data.remote.ApiModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApiModule::class,
    AppModule::class,
    ActivityBindingModule::class,
    FragmentBindingModule::class,
    AndroidSupportInjectionModule::class
])
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(application: JustNewsApp)

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}