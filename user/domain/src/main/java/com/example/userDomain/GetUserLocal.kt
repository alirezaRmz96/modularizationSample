package com.example.userDomain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserLocal @Inject constructor(
    private val repository: UserRepository,
) {
    operator fun invoke(): Flow<List<UserData>> {
        return repository.getUserLocal()
    }
}