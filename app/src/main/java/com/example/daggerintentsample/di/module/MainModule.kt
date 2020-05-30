package com.example.daggerintentsample.di.module

import android.content.Context
import com.example.daggerintentsample.App
import dagger.Binds
import dagger.Module

@Module
interface MainModule {

    @Binds
    fun provideContext(app: App): Context
}