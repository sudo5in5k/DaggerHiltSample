package com.example.daggerintentsample.di

import android.content.Context
import com.example.daggerintentsample.App
import dagger.Binds
import dagger.Module

@Module
interface MainModule {

    @Binds
    fun provideContext(app: App): Context
}