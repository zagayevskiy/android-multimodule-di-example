package com.example.feature3_no_ui.internal

import com.example.feature3_no_ui.api.Notifier
import com.example.feature3_no_ui.api.NotifierInteractivityProvider
import javax.inject.Inject
import javax.inject.Provider

internal class NotifierImpl @Inject constructor(
    private val interactivityProvider: NotifierInteractivityProvider,
    private val logNotifier: Provider<LogNotifier>,
    private val toasterNotifier: Provider<ToasterNotifier>,
) : Notifier {
    override fun notify(text: String, level: Notifier.Level) = when (val interactivity = interactivityProvider.interactivity) {
        is Notifier.Interactivity.Log -> logNotifier.get().notify(text = text, level, tag = interactivity.tag)
        Notifier.Interactivity.Toast -> toasterNotifier.get().notify(text, level)
        is Notifier.Interactivity.Both -> {
            toasterNotifier.get().notify(text, level)
            logNotifier.get().notify(text = text, level, tag = interactivity.logTag)
        }
    }
}
