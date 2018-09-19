package com.test.kotlintest.ui.articledetail.presenter

import com.test.kotlintest.ui.articledetail.interactor.ArticleDetailInteractor
import com.test.kotlintest.ui.articledetail.view.ArticleDetailView
import com.test.kotlintest.ui.articledetail.wireframe.ArticleDetailWireframe
import io.reactivex.disposables.CompositeDisposable

class DefaultArticleDetailPresenter(private val view: ArticleDetailView,
                                    private val interactor: ArticleDetailInteractor,
                                    private val wireframe: ArticleDetailWireframe) : ArticleDetailPresenter {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
    }

    override fun showDetail() {
        view.loadArticle(interactor.getArticleDetailUrl())
    }

    override fun destroy() {
        compositeDisposable.clear()
    }
}
