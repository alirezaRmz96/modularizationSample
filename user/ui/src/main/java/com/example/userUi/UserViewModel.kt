package com.example.userUi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Error
import com.example.data.NetworkConnectivity
import com.example.data.ResultWrapper
import com.example.userDomain.GetUserLocal
import com.example.userDomain.GetUserRemote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


class UserViewModel @Inject constructor(
    private val getUserLocal: GetUserLocal,
    private val getUserRemote: GetUserRemote,
    private val networkConnectivity: NetworkConnectivity,
) : ViewModel() {

    private val _userData = MutableStateFlow<List<UserDataView>>(emptyList())
    val userData = _userData.asStateFlow()

    private val _viewState = MutableSharedFlow<ViewState>()
    val viewState = _viewState.asSharedFlow()

    private var job: Job? = null

    init {
        getData()
    }

    private fun getData() = viewModelScope.launch(Dispatchers.IO) {
        if (networkConnectivity.getNetworkConnection()) {
            when (val response = getUserRemote()) {
                is ResultWrapper.Failure -> {
                    when (val error = response.error) {
                        is Error.AppError -> {
                            _viewState.emit(ViewState.Error(error.message))
                        }
                        is Error.NetworkError -> {
                            _viewState.emit(ViewState.Error(error.message))
                        }
                        // Doesn't work here
                        else -> {}
                    }
                }
                is ResultWrapper.Loading ->
                    _viewState.emit(ViewState.Loading)

                is ResultWrapper.Success -> {
                    job = getUserLocal().onEach { userData ->
                        _userData.emit(
                            userData.map { it.toUserDataView() }
                        )
                    }.launchIn(this)
                }
            }
        } else {
            _viewState.emit(ViewState.Error("Doesn't have network"))
        }
    }
}