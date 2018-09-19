package com.test.kotlintest.ui.newslist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.test.kotlintest.ui.newslist.presenter.NewsListPresenter
import com.test.kotlintest.ui.newslist.view.NewsListView
import dagger.android.AndroidInjection
import javax.inject.Inject

class NewsListActivity : AppCompatActivity() {

    @Inject
    lateinit var view: NewsListView
    @Inject
    lateinit var presenter: NewsListPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this);
        setContentView(view.getView())

        presenter.showNewsList()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }
}
