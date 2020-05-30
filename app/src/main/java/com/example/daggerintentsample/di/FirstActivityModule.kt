package com.example.daggerintentsample.di

import android.app.Activity
import androidx.annotation.Nullable
import com.example.daggerintentsample.data.FirstRepository
import com.example.daggerintentsample.ui.FirstActivity
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class FirstActivityModule {

//    @Binds
//    abstract fun bindsActivity(activity: FirstActivity): Activity

    @Module
    companion object {

        @JvmStatic
        @Provides
        @Nullable
        fun provideId(): String? = null ?: "2"

        @JvmStatic
        @Provides
        fun provideRepository(activity: FirstActivity) = FirstRepository(activity)
    }
}