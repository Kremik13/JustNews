package com.software.kremiks.justnews.ui.favourites

import com.software.kremiks.justnews.ui.BaseContract

interface FavouritesContract {

    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<FavouritesContract.View>
}