package com.example.data

import java.net.ConnectException

suspend fun <T> safeData(apiCall: suspend () -> T): ResultWrapper<T> {
    return try {
        ResultWrapper.Loading
        ResultWrapper.Success(apiCall())
    } catch (e: Exception) {
        when (e) {
            is ConnectException -> {
                ResultWrapper.Failure(Error.NetworkError(message = "no connection"))
            }
            is NetworkException -> {
                ResultWrapper.Failure(Error.ServerError(message = ""))
            }
            else -> {
                ResultWrapper.Failure(Error.AppError(message = e.message.toString()))
            }
        }
    }
}