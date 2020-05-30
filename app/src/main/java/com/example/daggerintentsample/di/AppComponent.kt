package com.example.daggerintentsample.di

import com.example.daggerintentsample.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [
        AndroidInjectionModule::class,
        MainModule::class,
        ActivityModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): AndroidInjector<App>
    }
}