package com.example.feature3_no_ui.internal.di

import com.example.feature3_no_ui.api.NotifierDependencies
import com.example.feature3_no_ui.internal.NotifierImpl
import dagger.Component

@Component(dependencies = [NotifierDependencies::class])
internal interface NotifierComponent {
    @Component.Factory
    interface Factory {
        fun create(deps: NotifierDependencies): NotifierComponent
    }

    val impl: NotifierImpl
}