package com.software.kremiks.justnews.screens.top

import com.software.kremiks.justnews.data.remote.NewsApi
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class TopPresenter @Inject constructor(private val api: NewsApi) : TopContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate() {
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }

    override fun onRefresh() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onReadMoreClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFavouriteClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadArticleImage(imageUrl: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}