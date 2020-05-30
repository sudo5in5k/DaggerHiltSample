package com.example.daggerintentsample.di

import com.example.daggerintentsample.ui.FirstActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FirstActivityModule::class])
    abstract fun contributeFirstActivity(): FirstActivity
}