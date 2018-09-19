package com.test.kotlintest.ui.newslist.presenter

import com.test.kotlintest.model.Article
import com.test.kotlintest.ui.newslist.interactor.NewsListInteractor

import com.test.kotlintest.ui.newslist.view.NewsListView
import com.test.kotlintest.ui.newslist.wireframe.NewsListWireframe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class DefaultNewsListPresenter(private val view: NewsListView,
                               private val interactor: NewsListInteractor,
                               private val wireframe: NewsListWireframe) : NewsListPresenter {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private fun addOnNewsListClickObserver(): Disposable? {
        return view.getNewsListObserver()
                .subscribe { article ->
                    onNewsListClickObserve(article)
                }
    }

    private fun onNewsListClickObserve(article: Article) {
        wireframe.goToArticleDetail(article)
    }

    override fun showNewsList() {
        interactor.loadArticles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { response ->
                            if (response.articles == null) {
                                view.showError()
                            } else {
                                view.showNewsList(response.articles)
                                compositeDisposable.add(addOnNewsListClickObserver())
                            }
                        },
                        { throwable ->
                            throwable.printStackTrace()
                            view.showError()
                        }
                )
    }

    override fun destroy() {
        compositeDisposable.clear()
    }
}
