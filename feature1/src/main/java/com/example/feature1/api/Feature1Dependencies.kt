package com.example.feature1.api

import com.example.core.Dependencies

interface Feature1Dependencies: Dependencies {
    val feature1Logger: Feature1Logger
    val feature1CaptionProvider: Feature1CaptionProvider
}

interface Feature1Logger {
    fun log(text: String)
}

interface Feature1CaptionProvider {
    val caption: String
}