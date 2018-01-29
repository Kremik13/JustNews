package com.software.kremiks.justnews.di

import com.software.kremiks.justnews.screens.favorite.FavoriteFragment
import com.software.kremiks.justnews.screens.favorite.FavoriteModule
import com.software.kremiks.justnews.screens.top.TopFragment
import com.software.kremiks.justnews.screens.top.TopModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [TopModule::class])
    internal abstract fun topFragment(): TopFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [FavoriteModule::class])
    internal abstract fun favoriteFragment(): FavoriteFragment
}