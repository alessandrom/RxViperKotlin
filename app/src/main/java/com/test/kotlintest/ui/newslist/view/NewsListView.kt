package com.test.kotlintest.ui.newslist.view

import android.view.View
import com.test.kotlintest.model.Article
import io.reactivex.Observable

interface NewsListView {

    fun showNewsList(articles: List<Article>)

    fun getNewsListObserver(): Observable<Article>

    fun showError()

    fun getView(): View
}
