package com.example.daggerintentsample.di.component

import com.example.daggerintentsample.App
import com.example.daggerintentsample.di.module.ViewModelModule
import com.example.daggerintentsample.di.module.ActivityModule
import com.example.daggerintentsample.di.module.MainModule
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