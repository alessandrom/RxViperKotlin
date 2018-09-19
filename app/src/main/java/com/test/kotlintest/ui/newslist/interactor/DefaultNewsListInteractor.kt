package com.test.kotlintest.ui.newslist.interactor

import android.app.Activity
import android.content.Context
import com.test.kotlintest.model.HeadlinesResponse
import com.test.kotlintest.network.NewsService
import io.reactivex.Observable

class DefaultNewsListInteractor(private val activity: Activity, private val service: NewsService) : NewsListInteractor {

    private var category: String

    companion object {
        const val CATEGORY_EXTRA_CODE: String = "categoryExtraCode"
    }

    init {
        category = activity.intent.getStringExtra(CATEGORY_EXTRA_CODE)
    }

    override fun loadArticles(): Observable<HeadlinesResponse> {
        return service.getHeadlines("us", category, "53c4a8a570f849e38a4b278320999ecc")
    }
}