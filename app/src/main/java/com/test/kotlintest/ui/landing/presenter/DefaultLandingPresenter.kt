package com.test.kotlintest.ui.landing.presenter

import android.util.Log
import android.widget.Button
import com.test.kotlintest.R
import com.test.kotlintest.network.CategoriesConstants
import com.test.kotlintest.ui.landing.interactor.LandingInteractor
import com.test.kotlintest.ui.landing.view.LandingView
import com.test.kotlintest.ui.landing.wireframe.LandingWireframe
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class DefaultLandingPresenter(private val view: LandingView, private val interactor: LandingInteractor, private val wireframe: LandingWireframe) : LandingPresenter {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        compositeDisposable.add(addOnGeneralButtonClickObserver())
        compositeDisposable.add(addOnSportsButtonClickObserver())
        compositeDisposable.add(addOnTechnologyButtonClickObserver())
    }

    private fun addOnGeneralButtonClickObserver(): Disposable? {
        return view.getGeneralCategoryButtonObserver()
                .subscribe { onGeneralButtonClick() }
    }

    private fun addOnSportsButtonClickObserver(): Disposable? {
        return view.getSportsCategoryButtonObserver()
                .subscribe { onSportButtonClick() }
    }

    private fun addOnTechnologyButtonClickObserver(): Disposable? {
        return view.getTechnologyCategoryButtonObserver()
                .subscribe { onTechnologyButtonClick() }
    }

    private fun onGeneralButtonClick() {
        wireframe.goToArticlesList(CategoriesConstants.GENERAL_CATEGORY_PARAM)
    }

    private fun onSportButtonClick() {
        wireframe.goToArticlesList(CategoriesConstants.SPORTS_CATEGORY_PARAM)
    }

    private fun onTechnologyButtonClick() {
        wireframe.goToArticlesList(CategoriesConstants.TECHNOLOGY_CATEGORY_PARAM)
    }


    override fun loadArticles() {
        interactor.loadArticles();
    }


    override fun destroy() {
        compositeDisposable.clear()
    }
}
