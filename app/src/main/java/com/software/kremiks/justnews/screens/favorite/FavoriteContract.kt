package com.software.kremiks.justnews.screens.favorite

import com.software.kremiks.justnews.screens.swiperefresh.SwipeRefreshContract

interface FavoriteContract {

    interface View : SwipeRefreshContract.View<FavoriteContract.Presenter> {
        fun getFavorites(): Set<String>
    }

    interface Presenter : SwipeRefreshContract.Presenter
}