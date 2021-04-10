package com.example.feature3_no_ui.api

interface Notifier {
    enum class Level {
        IMPORTANT,
        DEFAULT,
    }

    sealed class Interactivity {
        object Toast: Interactivity()
        class Log(val tag: String): Interactivity()
        class Both(val logTag: String): Interactivity()
    }

    fun notify(text: String, level: Level)
}