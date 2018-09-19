package com.test.kotlintest.ui.landing.core

import android.content.Context
import com.test.kotlintest.ui.landing.interactor.DefaultLandingInteractor
import com.test.kotlintest.ui.landing.interactor.LandingInteractor
import com.test.kotlintest.ui.landing.presenter.DefaultLandingPresenter
import com.test.kotlintest.ui.landing.presenter.LandingPresenter

import com.test.kotlintest.ui.landing.view.DefaultLandingView
import com.test.kotlintest.ui.landing.view.LandingView
import com.test.kotlintest.ui.landing.wireframe.DefaultLandingWireframe
import com.test.kotlintest.ui.landing.wireframe.LandingWireframe

import dagger.Module
import dagger.Provides

@Module
class LandingModule {

    @LandingScope
    @Provides
    internal fun provideView(context: Context): LandingView {
        return DefaultLandingView(context)
    }

    @LandingScope
    @Provides
    internal fun providePresenter(view: LandingView, wireframe: LandingWireframe, interactor: LandingInteractor): LandingPresenter {
        return DefaultLandingPresenter(view, interactor, wireframe)
    }

    @LandingScope
    @Provides
    internal fun provideInteractor(context: Context): LandingInteractor {
        return DefaultLandingInteractor(context)
    }

    @LandingScope
    @Provides
    internal fun provideWireframe(context: Context): LandingWireframe {
        return DefaultLandingWireframe(context)
    }

}
