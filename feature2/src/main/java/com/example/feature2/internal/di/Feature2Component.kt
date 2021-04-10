package com.example.feature2.internal.di

import com.example.feature2.api.Feature2Dependencies
import com.example.feature2.api.Feature2Fragment
import dagger.Component

@Component(dependencies = [Feature2Dependencies::class])
internal interface Feature2Component {
    @Component.Factory
    interface Factory {
        fun create(deps: Feature2Dependencies): Feature2Component
    }

    fun inject(fragment: Feature2Fragment)
}