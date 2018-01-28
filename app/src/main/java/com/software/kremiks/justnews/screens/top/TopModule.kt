package com.software.kremiks.justnews.screens.top

import com.software.kremiks.justnews.di.FragmentScope
import dagger.Binds
import dagger.Module

@Module
abstract class TopModule {

    @FragmentScope
    @Binds
    abstract fun bindPresenter(presenter: TopPresenter): TopContract.Presenter

    @FragmentScope
    @Binds
    abstract fun bindView(view: TopFragment): TopContract.View
}