package com.example.feature2.api

import androidx.fragment.app.Fragment
import com.example.core.Dependencies

interface Feature2Dependencies: Dependencies {
    val otherFeatureFragmentProvider: Feature2OtherFeatureFragmentProvider
}


interface Feature2OtherFeatureFragmentProvider {
    fun otherFeatureFragment(): Fragment
}