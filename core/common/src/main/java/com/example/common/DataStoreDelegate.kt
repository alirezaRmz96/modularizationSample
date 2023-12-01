package com.example.common

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.common.DataStoreDelegate.PreferencesKeys.SHOW_TOKEN
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

private const val USER_PREFERENCES_NAME = "user_preferences"


val Context.dataStore by preferencesDataStore(
    name = USER_PREFERENCES_NAME
)

class DataStoreDelegate @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    private val coroutineScope: GlobalScope
) : ReadWriteProperty<Any, String> {
    private object PreferencesKeys {
        val SHOW_TOKEN = stringPreferencesKey("show_completed")
    }

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        var token = ""
        coroutineScope.launch {
            dataStore.data.map { preference ->
                token = preference[SHOW_TOKEN] ?: "default"
            }
        }
        return token
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        coroutineScope.launch {
            dataStore.edit { preference ->
                preference[SHOW_TOKEN] = value
            }
        }
    }
}
