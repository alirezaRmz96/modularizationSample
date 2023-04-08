package com.example.data

sealed interface ResultWrapper<out T> {
    object Loading : ResultWrapper<Nothing>
    data class Success<T>(val resultData: T) : ResultWrapper<T>
    data class Failure<T>(val error: Error<T>) : ResultWrapper<T>
}

sealed interface Error<out T> {
    data class AppError<T>(val message: String): Error<T>
    data class ServerError<T>(val message: String): Error<T>
    data class NetworkError<T>(val message: String): Error<T>
}
