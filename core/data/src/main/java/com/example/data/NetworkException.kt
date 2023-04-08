package com.example.data

data class NetworkException(
    val serverMassage: String,
) : Exception()