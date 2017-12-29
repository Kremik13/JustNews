package com.software.kremiks.justnews.ui.top

import com.software.kremiks.justnews.ui.BaseContract

interface TopContract {

    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<TopContract.View>
}