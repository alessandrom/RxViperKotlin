package com.test.kotlintest.ui.newslist.core

import android.app.Activity
import android.app.Application
import android.content.Context
import com.test.kotlintest.network.NewsService
import com.test.kotlintest.ui.newslist.NewsListActivity
import com.test.kotlintest.ui.newslist.interactor.DefaultNewsListInteractor
import com.test.kotlintest.ui.newslist.interactor.NewsListInteractor
import com.test.kotlintest.ui.newslist.presenter.DefaultNewsListPresenter
import com.test.kotlintest.ui.newslist.presenter.NewsListPresenter
import com.test.kotlintest.ui.newslist.view.DefaultNewsListView
import com.test.kotlintest.ui.newslist.view.NewsListView
import com.test.kotlintest.ui.newslist.wireframe.DefaultNewsListWireframe
import com.test.kotlintest.ui.newslist.wireframe.NewsListWireframe

import dagger.Module
import dagger.Provides

@Module
class NewsListModule() {

    @NewsListScope
    @Provides
    internal fun provideView(context: Context): NewsListView {
        return DefaultNewsListView(context)
    }

    @NewsListScope
    @Provides
    internal fun providePresenter(view: NewsListView, wireframe: NewsListWireframe, interactor: NewsListInteractor): NewsListPresenter {
        return DefaultNewsListPresenter(view, interactor, wireframe)
    }

    @NewsListScope
    @Provides
    internal fun provideInteractor(activity: NewsListActivity, service: NewsService): NewsListInteractor {
        return DefaultNewsListInteractor(activity, service)
    }

    @NewsListScope
    @Provides
    internal fun provideWireframe(context: Context): NewsListWireframe {
        return DefaultNewsListWireframe(context)
    }

}
