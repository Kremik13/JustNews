package com.software.kremiks.justnews.screens.top

import com.software.kremiks.justnews.screens.swiperefresh.SwipeRefreshContract

interface TopContract {

    interface View : SwipeRefreshContract.View<TopContract.Presenter>

    interface Presenter : SwipeRefreshContract.Presenter
}