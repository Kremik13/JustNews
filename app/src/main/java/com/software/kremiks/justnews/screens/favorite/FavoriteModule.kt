package com.software.kremiks.justnews.screens.favorite

import com.software.kremiks.justnews.di.FragmentScope
import dagger.Binds
import dagger.Module

@Module
abstract class FavoriteModule {

    @FragmentScope
    @Binds
    abstract fun bindPresenter(presenter: FavoritePresenter): FavoriteContract.Presenter

    @FragmentScope
    @Binds
    abstract fun bindView(view: FavoriteFragment): FavoriteContract.View
}