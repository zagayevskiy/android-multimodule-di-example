package com.example.feature1.internal.di

import com.example.feature1.api.Feature1Dependencies
import com.example.feature1.api.Feature1Fragment
import dagger.Component

@Component(dependencies = [Feature1Dependencies::class])
internal interface Feature1Component {
    @Component.Factory
    interface Factory {
        fun create(deps: Feature1Dependencies): Feature1Component
    }

    fun inject(fragment: Feature1Fragment)
}