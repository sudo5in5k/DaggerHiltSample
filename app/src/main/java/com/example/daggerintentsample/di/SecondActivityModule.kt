package com.example.daggerintentsample.di

import android.content.Context
import androidx.annotation.Nullable
import com.example.daggerintentsample.data.SecondRepository
import com.example.daggerintentsample.data.entity.SampleData
import com.example.daggerintentsample.ui.SecondActivity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class SecondActivityModule {

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