package com.example.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.NetworkConnectivity
import com.example.data.ResultWrapper
import com.example.domain.GetUserLocal
import com.example.domain.GetUserRemote
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.data.Error


class UserViewModel @Inject constructor(
    private val getUserLocal: GetUserLocal,
    private val getUserRemote: GetUserRemote,
    private val networkConnectivity: NetworkConnectivity,
) : ViewModel() {

    private val _userData = MutableStateFlow<List<UserDataView>>(emptyList())
    val userData = _userData.asStateFlow()

    private val _viewState = MutableStateFlow<ViewState>(ViewState.Loading)
    val viewState = _userData.asStateFlow()

    init {
        getData()
    }

    private fun getData() = viewModelScope.launch {
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
                    getUserLocal().map { userData ->
                        _userData.emit(
                            userData.map { it.toUserDataView() }
                        )
                    }
                }
            }
        } else {
            _viewState.emit(ViewState.Error("Doesn't have network"))
        }
    }
}