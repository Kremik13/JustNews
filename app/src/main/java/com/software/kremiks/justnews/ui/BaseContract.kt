package com.software.kremiks.justnews.ui

interface BaseContract {

    interface View

    interface Presenter<T: BaseContract.View> {
        var view: T?

        fun bind(view: T)

        fun unbind() {
            view = null
        }
    }
}