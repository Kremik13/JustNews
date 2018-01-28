package com.software.kremiks.justnews.screens.top

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import com.software.kremiks.justnews.R
import com.software.kremiks.justnews.data.Article
import com.software.kremiks.justnews.data.remote.NewsApi
import com.software.kremiks.justnews.screens.BaseFragment
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_feed.*
import javax.inject.Inject

class TopFragment : BaseFragment<TopContract.Presenter>(), TopContract.View {

    @Inject
    override lateinit var presenter: TopContract.Presenter
    override val contentViewId = R.layout.fragment_feed
    private val adapter: TopAdapter by lazy {
        TopAdapter(presenter::onReadMoreClick, presenter::onFavouriteClicked )
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        feedSRL.setOnRefreshListener(presenter::onRefresh)
        feedRV.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@TopFragment.adapter
            this.adapter = adapter
        }
    }

    override fun setArticles(news: List<Article>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private class Model : NewsApi
}