package com.example.daggerintentsample.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.daggerintentsample.di.util.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}