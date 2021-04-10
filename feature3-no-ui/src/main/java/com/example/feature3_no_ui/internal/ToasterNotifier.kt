package com.example.feature3_no_ui.internal

import android.content.Context
import android.widget.Toast
import com.example.feature3_no_ui.api.Notifier
import javax.inject.Inject

internal class ToasterNotifier @Inject constructor(
    private val context: Context,
    private val levelConverter: NotifierLevelConverter
) : Notifier {
    override fun notify(text: String, level: Notifier.Level) {
        Toast.makeText(context, text, levelConverter.convertToDuration(level)).show()
    }
}