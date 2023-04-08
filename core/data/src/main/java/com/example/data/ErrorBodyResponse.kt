package com.example.data

data class ErrorBodyResponse(
    val data: Any,
    val message: String,
    val status: String,
)