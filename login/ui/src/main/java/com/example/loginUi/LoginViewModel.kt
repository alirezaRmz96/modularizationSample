package com.example.loginUi

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Error
import com.example.data.NetworkConnectivity
import com.example.data.ResultWrapper
import com.example.loginDomain.GetLoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val getLoginUseCase: GetLoginUseCase,
    private val networkConnectivity: NetworkConnectivity,
) : ViewModel() {

    val email = MutableStateFlow("")
    val password = MutableStateFlow("")

    private val _viewState = MutableStateFlow<ViewState>(ViewState.UnInitialize)
    val viewState = _viewState.asStateFlow()

    suspend fun loginUser() = viewModelScope.launch(Dispatchers.IO) {
        if (networkConnectivity.getNetworkConnection()) {

            val loginView = LoginView(
                email = email.value,
                password = password.value
            )
            when (val response = getLoginUseCase(login = loginView.toLogin())) {
                is ResultWrapper.Failure -> {
                    when (val error = response.error) {
                        is Error.AppError -> {
                            _viewState.emit(ViewState.Error(error.message))
                            Log.d("messi one", "AppError: ${error.message}")
                        }
                        is Error.NetworkError -> {
                            _viewState.emit(ViewState.Error(error.message))
                            Log.d("messi one", "NetworkError: ${error.message}")
                        }
                        // Doesn't work here
                        else -> {}
                    }

                }
                ResultWrapper.Loading -> {
                    Log.d("messi one", "Loading: ")
                    _viewState.emit(ViewState.Loading)
                }
                is ResultWrapper.Success -> {
                    _viewState.emit(ViewState.Success(response.resultData.token))
                    Log.d("messi one", "Success: ${response.resultData.token}")
                }
            }
        } else {
            _viewState.emit(ViewState.Error("Doesn't have network"))
        }
    }
}
