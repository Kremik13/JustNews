package com.software.kremiks.justnews.extensions

import android.support.design.widget.Snackbar
import android.view.View

fun View.snack(
        message: String,
        length: Int = Snackbar.LENGTH_LONG,
        action: (Snackbar.() -> Unit)?
) {
    Snackbar.make(this, message, length).apply {
        action?.invoke(this)
        show()
    }
}