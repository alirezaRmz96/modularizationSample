package com.example.loginUi

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Error
import com.example.data.NetworkConnectivity
import com.example.data.ResultWrapper
import com.example.loginDomain.GetLoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val getLoginUseCase: GetLoginUseCase,
    private val networkConnectivity: NetworkConnectivity,
) : ViewModel() {

    val email = MutableStateFlow("eve.holt@reqres.in")
    val password = MutableStateFlow("cityslicka")

    private val _viewState = Channel<ViewState>()
    val viewState = _viewState.consumeAsFlow()

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
                            _viewState.send(ViewState.Error(error.message))
                            Log.d("messi one", "AppError: ${error.message}")
                        }
                        is Error.NetworkError -> {
                            _viewState.send(ViewState.Error(error.message))
                            Log.d("messi one", "NetworkError: ${error.message}")
                        }
                        // Doesn't work here
                        else -> {}
                    }

                }
                ResultWrapper.Loading -> {
                    Log.d("messi one", "Loading: ")
                    _viewState.send(ViewState.Loading)
                }
                is ResultWrapper.Success -> {
                    _viewState.send(ViewState.Success(response.resultData.token))
                    Log.d("messi one", "Success: ${response.resultData.token}")
                }
            }
        } else {
            _viewState.send(ViewState.Error("Doesn't have network"))
        }
    }
}
