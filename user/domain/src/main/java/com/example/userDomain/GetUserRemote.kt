package com.example.userDomain

import com.example.data.ResultWrapper
import com.example.data.safeData
import javax.inject.Inject

class GetUserRemote @Inject constructor(
    private val repository: UserRepository,
) {
    suspend operator fun invoke(): ResultWrapper<Unit> {
        return safeData { repository.getUserRemote() }
    }
}