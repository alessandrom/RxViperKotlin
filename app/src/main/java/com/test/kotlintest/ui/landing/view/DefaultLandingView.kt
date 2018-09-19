package com.test.kotlintest.ui.landing.view


import android.content.Context
import android.view.View
import android.widget.LinearLayout
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.view.clicks

import com.test.kotlintest.R
import io.reactivex.Observable
import kotlinx.android.synthetic.main.landing_view.view.*

class DefaultLandingView(context: Context) : LinearLayout(context), LandingView {

    init {
        inflate(context, R.layout.landing_view, this)
    }


//    override fun getGeneralCategoryButtonObserver(): Observable<Any> {
//        return RxView.clicks(generalButton)
//    }

    override fun getGeneralCategoryButtonObserver(): Observable<Unit> {
        return generalButton.clicks()
    }

    override fun getSportsCategoryButtonObserver(): Observable<Unit> {
        return sportButton.clicks()
    }

    override fun getTechnologyCategoryButtonObserver(): Observable<Unit> {
        return technologyButton.clicks()
    }

    override fun getView(): View {
        return this
    }

}
