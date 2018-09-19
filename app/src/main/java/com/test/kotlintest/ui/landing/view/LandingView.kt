package com.test.kotlintest.ui.landing.view

import android.view.View

interface LandingView {
    fun getView(): View
    fun getGeneralCategoryButtonObserver(): io.reactivex.Observable<Unit>
    fun getSportsCategoryButtonObserver(): io.reactivex.Observable<Unit>
    fun getTechnologyCategoryButtonObserver(): io.reactivex.Observable<Unit>
}
