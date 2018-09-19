package com.test.kotlintest.ui.newslist.interactor

import com.test.kotlintest.model.HeadlinesResponse
import io.reactivex.Observable

interface NewsListInteractor {
    fun loadArticles(): Observable<HeadlinesResponse>
}