package com.test.kotlintest.ui.newslist.presenter

import android.content.Context
import android.content.Intent
import com.test.kotlintest.model.Article
import com.test.kotlintest.model.HeadlinesResponse
import com.test.kotlintest.network.CategoriesConstants
import com.test.kotlintest.ui.newslist.NewsListActivity
import com.test.kotlintest.ui.newslist.interactor.DefaultNewsListInteractor
import com.test.kotlintest.ui.newslist.interactor.NewsListInteractor
import com.test.kotlintest.ui.newslist.view.NewsListView
import com.test.kotlintest.ui.newslist.wireframe.NewsListWireframe
import io.reactivex.Observable
import io.reactivex.Scheduler
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.RobolectricTestRunner
import java.util.*
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.plugins.RxJavaPlugins
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit


@RunWith(RobolectricTestRunner::class)
class DefaultNewsListPresenterTest {


    lateinit var view: NewsListView
    @Mock
    lateinit var interactor: NewsListInteractor
    @Mock
    lateinit var wireframe: NewsListWireframe

    lateinit var presenter: DefaultNewsListPresenter

    @Before
    fun setUp() {
        RxJavaPlugins.setInitIoSchedulerHandler { immediate }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { immediate }

        view = mock(NewsListView::class.java)
        interactor = mock(NewsListInteractor::class.java)
        wireframe = mock(NewsListWireframe::class.java)
        presenter = DefaultNewsListPresenter(view, interactor, wireframe)
    }

    private val immediate = object : Scheduler() {
        override fun scheduleDirect(run: Runnable,
                                    delay: Long, unit: TimeUnit): Disposable {
            return super.scheduleDirect(run, 0, unit)
        }

        override fun createWorker(): Scheduler.Worker {
            return ExecutorScheduler.ExecutorWorker(Executor { it.run() })
        }
    }

    @Test
    fun testShowNewsList_shouldShowError() {
        `when`(view.getNewsListObserver()).thenReturn(Observable.just(Article()))
        `when`(interactor.loadArticles()).thenReturn(Observable.just(HeadlinesResponse()))
        presenter.showNewsList()
        verify(view).showError()
    }
//
//    @Test
//    fun testShowNewsList_shouldShowNewsList() {
//        `when`(view.getNewsListObserver()).thenReturn(Observable.just(Article()))
//        var headlinesResponse = HeadlinesResponse()
//        headlinesResponse.articles = Arrays.asList(Article(), Article())
//        `when`(interactor.loadArticles()).thenReturn(Observable.just(headlinesResponse))
//        presenter.showNewsList()
//        verify(view).showNewsList(headlinesResponse.articles)
//    }
}