package com.example.feature3_no_ui.internal

import android.util.Log
import android.widget.Toast
import com.example.feature3_no_ui.api.Notifier
import javax.inject.Inject

internal class NotifierLevelConverter @Inject constructor() {
    fun convertToDuration(level: Notifier.Level): Int = when (level) {
        Notifier.Level.IMPORTANT -> Toast.LENGTH_LONG
        Notifier.Level.DEFAULT -> Toast.LENGTH_SHORT
    }
    fun convertToLogLevel(level: Notifier.Level): Int = when(level) {
        Notifier.Level.IMPORTANT -> Log.ERROR
        Notifier.Level.DEFAULT -> Log.INFO
    }
}