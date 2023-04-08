package com.example.userUi

sealed interface ViewState {
    object Loading : ViewState
    data class Error(val message: String) : ViewState
}
