package com.software.kremiks.justnews.di

import com.software.kremiks.justnews.screens.navdrawer.NavDrawerActivity
import com.software.kremiks.justnews.screens.navdrawer.NavDrawerModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [NavDrawerModule::class])
    internal abstract fun navDrawerActivity(): NavDrawerActivity
}