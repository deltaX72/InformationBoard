package com.deltax72.informationboard.di.modules

import com.deltax72.informationboard.di.annotations.ActivityScope
import com.deltax72.informationboard.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    fun activityInjector(): MainActivity
}