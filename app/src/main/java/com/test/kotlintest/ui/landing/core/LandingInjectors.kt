package com.test.kotlintest.ui.landing.core

import com.test.kotlintest.ui.landing.LandingActivity
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Module
abstract class LandingInjectors {
    @LandingScope
    @ContributesAndroidInjector(modules = [LandingModule::class])
    internal abstract fun contributeLandingActivity(): LandingActivity
}
