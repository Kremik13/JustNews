package com.software.kremiks.justnews.screens.swiperefresh

import com.software.kremiks.justnews.R
import com.software.kremiks.justnews.data.ArticlesResponse
import com.software.kremiks.justnews.data.remote.NewsApi
import io.reactivex.disposables.CompositeDisposable

abstract class SwipeRefreshPresenter(
        protected open val view: SwipeRefreshContract.View<SwipeRefreshContract.Presenter>,
        protected open val model: NewsApi
) : SwipeRefreshContract.Presenter {

    protected val disposables = CompositeDisposable()

    override fun onStart() = onRefresh()

    override fun onDestroy() {
        disposables.dispose()
    }

    abstract override fun onRefresh()

    protected fun onRefreshSuccess(articlesResponse: ArticlesResponse) {
        view.apply {
            if (articlesResponse.articles.isEmpty()) {
                showNoArticles()
            } else {
                setArticles(articlesResponse.articles)
            }
        }
    }

    protected fun onRefreshError() {
        view.apply {
            showShowRefreshing(false)
            showToast(R.string.cannot_connect_internet)
        }
    }

    override fun onReadMoreClick(url: String) {
        view.openBrowser(url)
    }

    override fun onFavoriteClick(sourceId: String?) {
        sourceId?.let {
            view.editFavorites(it)
        }
    }
}