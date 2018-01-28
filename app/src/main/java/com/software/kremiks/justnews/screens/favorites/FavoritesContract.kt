package com.software.kremiks.justnews.screens.favorites

import com.software.kremiks.justnews.screens.BaseContract

interface FavoritesContract {

    interface View : BaseContract.View<FavoritesContract.Presenter>

    interface Presenter : BaseContract.Presenter
}