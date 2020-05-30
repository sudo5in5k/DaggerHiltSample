package com.example.daggerintentsample.di.module

import com.example.daggerintentsample.di.scope.ActivityScope
import com.example.daggerintentsample.ui.FirstActivity
import com.example.daggerintentsample.ui.SecondActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class ActivityModule {

    @Singleton
    @ActivityScope
    @ContributesAndroidInjector(modules = [FirstActivityModule::class])
    abstract fun contributeFirstActivity(): FirstActivity

    @Singleton
    @ActivityScope
    @ContributesAndroidInjector(modules = [SecondActivityModule::class])
    abstract fun contributeSecondActivity(): SecondActivity
}