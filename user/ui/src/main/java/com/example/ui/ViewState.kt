package com.example.ui

sealed interface ViewState {
    object Loading : ViewState
    data class Error(val message: String) : ViewState
}
