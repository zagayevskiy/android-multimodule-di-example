package com.example.multimoduleappexample.di

import androidx.fragment.app.Fragment
import com.example.core.Dependencies
import com.example.core.dagger.DependenciesKey
import com.example.feature1.api.Feature1Fragment
import com.example.feature2.api.Feature2Dependencies
import com.example.feature2.api.Feature2OtherFeatureFragmentProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface Feature2DependenciesModule {

    companion object {
        @Provides
        @MainActivityScope
        fun otherFeaturesFragmentProvider(): Feature2OtherFeatureFragmentProvider = object : Feature2OtherFeatureFragmentProvider {
            override fun otherFeatureFragment(): Fragment = Feature1Fragment()
        }
    }

    @Binds
    @IntoMap
    @DependenciesKey(Feature2Dependencies::class)
    fun bindFeature2Deps(impl: MainActivityComponent): Dependencies
}