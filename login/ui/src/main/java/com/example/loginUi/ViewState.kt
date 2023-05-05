package com.example.loginUi

sealed class ViewState {
    object UnInitialize : ViewState()
    object Loading : ViewState()
    data class Error(val message: String? = null) : ViewState()
    data class Success(val data : Any):ViewState()
}