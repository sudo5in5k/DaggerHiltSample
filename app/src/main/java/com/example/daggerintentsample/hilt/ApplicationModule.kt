package com.example.daggerintentsample.hilt

import android.content.Context
import androidx.annotation.Nullable
import com.example.daggerintentsample.data.FirstRepository
import com.example.daggerintentsample.data.SecondRepository
import com.example.daggerintentsample.data.entity.SampleData
import com.example.daggerintentsample.ui.SecondActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Nullable
    @Singleton
    @Provides
    fun provideId(): String? = null ?: "2"

    @Nullable
    @Singleton
    @Provides
    fun provideSampleData(@ApplicationContext context: Context): SampleData? =
        (context as? SecondActivity)?.intent?.getSerializableExtra(
            SecondActivity.KEY
        ) as? SampleData
}

@Module
@InstallIn(ApplicationComponent::class)
object FirstRepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(@ApplicationContext context: Context) = FirstRepository(context)
}

@Module
@InstallIn(ApplicationComponent::class)
object SecondRepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(@ApplicationContext context: Context) = SecondRepository(context)
}

