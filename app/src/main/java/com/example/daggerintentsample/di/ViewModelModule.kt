package com.example.daggerintentsample.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggerintentsample.viewmodel.FirstViewModel
import com.example.daggerintentsample.viewmodel.SecondViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

//    @Binds
//    @IntoMap
//    @ViewModelKey(FirstViewModel::class)
//    @ActivityScope
//    abstract fun bindFirstViewModel(viewModel: FirstViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SecondViewModel::class)
    @ActivityScope
    abstract fun bindSecondViewModel(viewModel: SecondViewModel): ViewModel

    @Binds
    @ActivityScope
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}