package com.example.loginDomain

import com.example.common.CorePreference
import com.example.data.Error
import com.example.data.ResultWrapper
import com.example.data.safeData
import javax.inject.Inject

class GetLoginUseCase @Inject constructor(
    private val repository: LoginRepository,
    private val corePreference: CorePreference
) {
    suspend operator fun invoke(login: Login): ResultWrapper<LoginProperty> {
        return when (val result = safeData { repository.getUserLogin(login) }) {
            is ResultWrapper.Failure -> ResultWrapper.Failure(Error.AppError("appError"))
            ResultWrapper.Loading -> ResultWrapper.Loading
            is ResultWrapper.Success -> {
                corePreference.token = result.resultData.token
                corePreference.theme = true
                ResultWrapper.Success(result.resultData)
            }
        }

    }


}

