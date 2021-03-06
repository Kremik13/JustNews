package com.software.kremiks.justnews.screens.top

import com.software.kremiks.justnews.data.remote.NewsApi
import com.software.kremiks.justnews.screens.swiperefresh.SwipeRefreshPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TopPresenter @Inject constructor(
        override val view: TopContract.View,
        override val model: NewsApi
) : SwipeRefreshPresenter(view, model), TopContract.Presenter {
    override fun onRefresh() {
        disposables.add(model.getTopNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { view.showShowRefreshing(true) }
                .doAfterTerminate { view.showShowRefreshing(false) }
                .subscribe(
                        { onRefreshSuccess(it) },
                        { onRefreshError() }
                )
        )
    }
}