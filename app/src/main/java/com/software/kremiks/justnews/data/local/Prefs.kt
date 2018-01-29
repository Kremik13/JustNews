package com.software.kremiks.justnews.data.local

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Prefs @Inject constructor(private val context: Context) {

    companion object {
        private const val PREFS_FILE_NAME = "com.software.kremiks.justnews.prefs"
        private const val FAVORITES = "FAVORITES"
    }

    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)

    var favorites: Set<String>
        get() = prefs.getStringSet(FAVORITES, emptySet())
        set(value) = prefs.edit().putStringSet(FAVORITES, value).apply()
}