package com.example.daggerintentsample.di

import android.app.Activity
import android.content.Context
import androidx.annotation.Nullable
import com.example.daggerintentsample.data.FirstRepository
import com.example.daggerintentsample.ui.FirstActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class FirstActivityModule {

//    @Binds
//    abstract fun bindsActivity(activity: FirstActivity): Activity

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