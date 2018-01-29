package com.software.kremiks.justnews.screens.favorite

import com.software.kremiks.justnews.data.remote.NewsApi
import com.software.kremiks.justnews.screens.swiperefresh.SwipeRefreshPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FavoritePresenter @Inject constructor(
        override val view: FavoriteContract.View,
        override val model: NewsApi
) : SwipeRefreshPresenter(view, model), FavoriteContract.Presenter {

    override fun onRefresh() {
        onRefresh(view.getFavorites().toList())
    }

    private fun onRefresh(favoriteSources: List<String>) {
        disposables.add(model.getFavoriteNews(favoriteSources)
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