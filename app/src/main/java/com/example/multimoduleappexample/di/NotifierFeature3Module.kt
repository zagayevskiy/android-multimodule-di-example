package com.example.multimoduleappexample.di

import com.example.feature3_no_ui.api.Notifier
import com.example.feature3_no_ui.api.NotifierFactory
import com.example.feature3_no_ui.api.NotifierInteractivityProvider
import dagger.Module
import dagger.Provides

@Module
object NotifierFeature3Module {

    @Provides
    @MainActivityScope
    fun interactivityProvider(): NotifierInteractivityProvider = object : NotifierInteractivityProvider {
        override val interactivity = Notifier.Interactivity.Both(logTag = "Main")

    }

    @Provides
    @MainActivityScope
    fun notifier(depsImpl: MainActivityComponent): Notifier = NotifierFactory.create(depsImpl)
}