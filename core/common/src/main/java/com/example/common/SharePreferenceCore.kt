package com.example.common

import android.content.SharedPreferences
import androidx.core.content.edit
import kotlin.reflect.KProperty


/**
 *  this has some problems like we use property.name for keys
 *  or for setValues, we use hard code for the default value
 */
operator fun <T> SharedPreferences.setValue(thisRef: Any, property: KProperty<*>, value: T) {
    edit {
        when (value) {
            is Boolean -> putBoolean(property.name, value)
            is Int -> putInt(property.name, value)
            is Float -> putFloat(property.name, value)
            is Long -> putLong(property.name, value)
            is String -> putString(property.name, value)
            else -> throw UnsupportedOperationException()
        }
    }
}

inline operator fun <reified T> SharedPreferences.getValue(
    thisRef: Any,
    property: KProperty<*>
): T {
    return when (T::class) {
        Boolean::class -> getBoolean(property.name, false)
        Int::class -> getInt(property.name, 0)
        Float::class -> getFloat(property.name, 0.0f)
        Long::class -> getLong(property.name, 0L)
        String::class -> getString(property.name, "")
        else -> throw UnsupportedOperationException()
    } as T
}