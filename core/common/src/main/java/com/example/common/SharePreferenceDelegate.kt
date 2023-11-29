package com.example.common

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

val SharedPreferences.delegates get() = PreferenceDelegate(this)

class PreferenceDelegate(private val prefs: SharedPreferences) {
    fun booleanDelegate(key: String? = null, default: Boolean = false) =
        createSharePreference(
            key = key,
            default = default,
            prefGet = prefs::getBoolean,
            prefSet = prefs.edit()::putBoolean
        )

    fun floatDelegate(key: String? = null, default: Float = 0f) =
        createSharePreference(
            key = key,
            default = default,
            prefGet = prefs::getFloat,
            prefSet = prefs.edit()::putFloat
        )

    fun intDelegate(key: String? = null, default: Int = 0) =
        createSharePreference(
            key = key,
            default = default,
            prefGet = prefs::getInt,
            prefSet = prefs.edit()::putInt
        )

    fun longDelegate(key: String? = null, default: Long = 0L) =
        createSharePreference(
            key = key,
            default = default,
            prefGet = prefs::getLong,
            prefSet = prefs.edit()::putLong
        )

    fun stringDelegate(key: String? = null, default: String = "") =
        createSharePreference(
            key = key,
            default = default,
            prefGet = { k, v -> prefs.getString(k, v) as String },
            prefSet = prefs.edit()::putString
        )

    /** second approach
     *  write this function for prevent to write ReadWriteProperty for multi times
     */
    private fun <T> createSharePreference(
        key: String? = null,
        default: T,
        prefGet: (key: String, default: T) -> T,
        prefSet: (key: String, value: T) -> SharedPreferences.Editor
    ) = object : ReadWriteProperty<Any, T> {
        override fun getValue(thisRef: Any, property: KProperty<*>): T {
            return prefGet(key ?: property.name, default)
        }

        override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
            prefSet(key ?: property.name, value).apply()
        }
    }
}















