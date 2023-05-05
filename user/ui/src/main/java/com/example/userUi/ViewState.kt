package com.example.userUi

sealed class ViewState {
    object Loading : ViewState()
    data class Error(val message: String) : ViewState()
    data class Success(val data : Any):ViewState()
}
