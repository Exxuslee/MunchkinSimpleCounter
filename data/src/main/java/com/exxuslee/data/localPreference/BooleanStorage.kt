package com.exxuslee.data.localPreference

import android.content.SharedPreferences

/**
 * @author Asatryan on 24.12.2022
 */
interface BooleanStorage {
    fun read(key: String, default: Boolean): Boolean
    fun save(key: String, value: Boolean)

    class Base(private val preferences: SharedPreferences) : BooleanStorage {

        override fun read(key: String, default: Boolean) =
            preferences.getBoolean(key, default)

        override fun save(key: String, value: Boolean) {
            preferences.edit().putBoolean(key, value).apply()
        }
    }
}