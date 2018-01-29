package com.software.kremiks.justnews.screens

interface BaseContract {

    interface View<out T : BaseContract.Presenter> {
        val presenter: T
    }

    interface Presenter {

        fun onCreate() {}

        fun onDestroy() {}

        fun onStart() {}

        fun onStop() {}
    }
}