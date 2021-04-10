package com.example.multimoduleappexample.di

import android.content.Context
import com.example.feature1.api.Feature1Dependencies
import com.example.feature2.api.Feature2Dependencies
import com.example.feature3_no_ui.api.NotifierDependencies
import com.example.multimoduleappexample.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@Scope
annotation class MainActivityScope

@Component(
    modules = [
        Feature1DependenciesModule::class,
        Feature2DependenciesModule::class,
        NotifierFeature3Module::class,
    ]
)
@MainActivityScope
interface MainActivityComponent : Feature1Dependencies, Feature2Dependencies, NotifierDependencies {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): MainActivityComponent
    }

    fun inject(activity: MainActivity)
}