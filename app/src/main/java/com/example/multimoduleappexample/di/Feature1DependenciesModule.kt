package com.example.multimoduleappexample.di

import com.example.core.Dependencies
import com.example.core.dagger.DependenciesKey
import com.example.feature1.api.Feature1CaptionProvider
import com.example.feature1.api.Feature1Dependencies
import com.example.feature1.api.Feature1Logger
import com.example.feature3_no_ui.api.Notifier
import com.example.multimoduleappexample.Feature1CaptionProviderImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface Feature1DependenciesModule {

    companion object {
        @Provides
        fun logger(notifier: Notifier): Feature1Logger = object : Feature1Logger {
            override fun log(text: String) {
                notifier.notify(text, Notifier.Level.DEFAULT)
            }
        }
    }

    @Binds
    fun bindCaptinProvider(impl: Feature1CaptionProviderImpl): Feature1CaptionProvider

    @Binds
    @IntoMap
    @DependenciesKey(Feature1Dependencies::class)
    fun bindFeature1Deps(impl: MainActivityComponent): Dependencies
}