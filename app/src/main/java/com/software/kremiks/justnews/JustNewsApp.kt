package com.software.kremiks.justnews

import com.software.kremiks.justnews.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class JustNewsApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
        return appComponent
    }
}