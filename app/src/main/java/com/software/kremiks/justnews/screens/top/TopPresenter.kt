package com.software.kremiks.justnews.screens.top

import com.software.kremiks.justnews.R
import com.software.kremiks.justnews.data.ArticlesResponse
import com.software.kremiks.justnews.data.remote.NewsApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TopPresenter @Inject constructor(
        private val view: TopContract.View,
        private val model: NewsApi
) : TopContract.Presenter {

    private val disposables = CompositeDisposable()

    override fun onStart() = onRefresh()

    override fun onDestroy() {
        disposables.dispose()
    }

    override fun onRefresh() {
        disposables.add(model.getTopNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { view.showShowRefreshing(true) }
                .doAfterTerminate { view.showShowRefreshing(false) }
                .subscribe(
                        { onRefreshSuccess(it) },
                        { onRefreshError(it) }
                ))
    }

    private fun onRefreshSuccess(articlesResponse: ArticlesResponse) {
        view.apply {
            if (articlesResponse.articles.isEmpty()) {
                showNoArticles()
            } else {
                setArticles(articlesResponse.articles)
            }
        }
    }

    private fun onRefreshError(throwable: Throwable) {
        view.apply {
            showShowRefreshing(false)
            showToast(R.string.cannot_connect_internet)
        }
    }

    override fun onReadMoreClick(url: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFavoriteClick(sourceId: String?) {
        sourceId?.let {
            view.editFavorites(it)
        }
    }

    override fun loadArticleImage(imageUrl: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}