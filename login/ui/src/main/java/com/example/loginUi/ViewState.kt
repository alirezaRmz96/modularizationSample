package com.example.loginUi

sealed interface ViewState {
    object Loading : ViewState
    data class Error(val message: String) : ViewState
    data class Success<T>(val data : T):ViewState
}