package com.test.kotlintest.ui.articledetail.core

import android.app.Activity
import android.content.Context
import com.test.kotlintest.ui.articledetail.ArticleDetailActivity
import com.test.kotlintest.ui.articledetail.interactor.ArticleDetailInteractor
import com.test.kotlintest.ui.articledetail.interactor.DefaultArticleDetailInteractor
import com.test.kotlintest.ui.articledetail.presenter.ArticleDetailPresenter
import com.test.kotlintest.ui.articledetail.presenter.DefaultArticleDetailPresenter
import com.test.kotlintest.ui.articledetail.view.ArticleDetailView
import com.test.kotlintest.ui.articledetail.view.DefaultArticleDetailView
import com.test.kotlintest.ui.articledetail.wireframe.ArticleDetailWireframe
import com.test.kotlintest.ui.articledetail.wireframe.DefaultArticleDetailWireframe


import dagger.Module
import dagger.Provides

@Module
class ArticleDetailModule {

    @ArticleDetailScope
    @Provides
    internal fun provideView(context: Context): ArticleDetailView {
        return DefaultArticleDetailView(context)
    }

    @ArticleDetailScope
    @Provides
    internal fun providePresenter(view: ArticleDetailView, wireframe: ArticleDetailWireframe, interactor: ArticleDetailInteractor): ArticleDetailPresenter {
        return DefaultArticleDetailPresenter(view, interactor, wireframe)
    }

    @ArticleDetailScope
    @Provides
    internal fun provideInteractor(activity: ArticleDetailActivity): ArticleDetailInteractor {
        return DefaultArticleDetailInteractor(activity)
    }

    @ArticleDetailScope
    @Provides
    internal fun provideWireframe(context: Context): ArticleDetailWireframe {
        return DefaultArticleDetailWireframe(context)
    }

}
