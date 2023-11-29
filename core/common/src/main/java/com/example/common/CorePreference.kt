package com.example.common

import android.content.SharedPreferences
import javax.inject.Inject


/**
 *   if I use first method for it, it's not type safe you can see in previous code I just write
 *   some condition for them and if our data was not primitive type we throw the exception
 *   and in code below we can change the type like(var token: Context by preferences) we don't get
 *   compile error for that
 */
class CorePreference @Inject constructor(preferences: SharedPreferences) {
    var token: String by preferences.delegates.stringDelegate(key = "Token", default = "it's works")
    var theme: Boolean by preferences.delegates.booleanDelegate()
}