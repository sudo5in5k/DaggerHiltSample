package com.example.daggerintentsample.di.module

import android.content.Context
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModel
import com.example.daggerintentsample.data.FirstRepository
import com.example.daggerintentsample.di.util.ViewModelKey
import com.example.daggerintentsample.di.scope.ActivityScope
import com.example.daggerintentsample.ui.FirstActivity
import com.example.daggerintentsample.viewmodel.FirstViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class FirstActivityModule {

//    @Binds
//    abstract fun bindsActivity(activity: FirstActivity): Activity

    @Binds
    @IntoMap
    @ViewModelKey(FirstViewModel::class)
    @ActivityScope
    abstract fun bindFirstViewModel(viewModel: FirstViewModel): ViewModel

    @Module
    companion object {

        @JvmStatic
        @Provides
        @Nullable
        @Singleton
        fun provideId(activity: FirstActivity): String? = null ?: "2"

        @JvmStatic
        @Provides
        @Singleton
        fun provideRepository(context: Context) = FirstRepository(context)
    }
}