package com.example.feature3_no_ui.api

import com.example.feature3_no_ui.internal.di.DaggerNotifierComponent

object NotifierFactory {
    fun create(dependencies: NotifierDependencies): Notifier = DaggerNotifierComponent.factory()
        .create(dependencies)
        .impl
}