package com.refactoringlife.auth.features.register.domain.repository

import com.refactoringlife.auth.features.register.data.dto.request.UserRegisterRequest
import com.refactoringlife.auth.features.register.data.dto.responses.UserRegisterResponse
import com.refactoringlife.core.common.result.AsyncResult
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun userRegister(userRegisterRequest: UserRegisterRequest): AsyncResult<UserRegisterResponse?, Exception>
    fun listenerUserResponse(): Flow<UserRegisterResponse?>
}
