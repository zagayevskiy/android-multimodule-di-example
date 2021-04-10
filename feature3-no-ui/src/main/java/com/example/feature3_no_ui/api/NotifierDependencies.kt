package com.example.feature3_no_ui.api

import android.content.Context

interface NotifierDependencies {
    val context: Context
    val notifierInteractivityProvider: NotifierInteractivityProvider
}

interface NotifierInteractivityProvider {
    val interactivity: Notifier.Interactivity
}