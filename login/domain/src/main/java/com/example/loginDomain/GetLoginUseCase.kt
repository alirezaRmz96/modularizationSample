package com.example.loginDomain

import com.example.data.ResultWrapper
import com.example.data.safeData
import javax.inject.Inject

class GetLoginUseCase @Inject constructor(
    private val repository: LoginRepository,
) {
    suspend operator fun invoke(login: Login): ResultWrapper<LoginProperty> =
        safeData { repository.getUserLogin(login) }

}

