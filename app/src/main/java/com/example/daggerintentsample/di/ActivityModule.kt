package com.example.daggerintentsample.di

import com.example.daggerintentsample.ui.FirstActivity
import com.example.daggerintentsample.ui.SecondActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class ActivityModule {

    @Singleton
    @ContributesAndroidInjector(modules = [FirstActivityModule::class])
    abstract fun contributeFirstActivity(): FirstActivity

    @Singleton
    @ContributesAndroidInjector(modules = [SecondActivityModule::class])
    abstract fun contributeSecondActivity(): SecondActivity
}