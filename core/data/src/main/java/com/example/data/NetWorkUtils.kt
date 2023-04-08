package com.example.data

import com.google.gson.Gson
import retrofit2.Response

abstract class BaseRemoteDataSource(
    private val gson: Gson,
) {
    fun <T> Response<T>.bodyOrThrow(): T {
        if (isSuccessful)
            return body() ?: throw NullPointerException()
        else {
            val errorBody = errorBody()?.string()
            var errorMessage = ""

            errorBody?.let {
                errorMessage = try {
                    gson.fromJson(errorBody, ErrorBodyResponse::class.java).message
                } catch (e: Exception) {
                    e.message.toString()
                }
            }
            throw NetworkException(
                serverMassage = errorMessage
            )
        }
    }
}