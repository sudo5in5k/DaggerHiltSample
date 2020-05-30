package com.example.daggerintentsample.di.module

import android.content.Context
import androidx.annotation.Nullable
import androidx.lifecycle.ViewModel
import com.example.daggerintentsample.data.SecondRepository
import com.example.daggerintentsample.data.entity.SampleData
import com.example.daggerintentsample.di.util.ViewModelKey
import com.example.daggerintentsample.di.scope.ActivityScope
import com.example.daggerintentsample.ui.SecondActivity
import com.example.daggerintentsample.viewmodel.SecondViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class SecondActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(SecondViewModel::class)
    @ActivityScope
    abstract fun bindSecondViewModel(viewModel: SecondViewModel): ViewModel


    @Module
    companion object {

        @JvmStatic
        @Provides
        @Nullable
        @Singleton
        fun provideSampleData(activity: SecondActivity) =
            activity.intent.getSerializableExtra(SecondActivity.KEY) as? SampleData

        @JvmStatic
        @Provides
        @Singleton
        fun provideRepository(context: Context) = SecondRepository(context)

    }
}