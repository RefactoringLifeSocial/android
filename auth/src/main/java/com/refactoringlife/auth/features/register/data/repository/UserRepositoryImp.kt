package com.refactoringlife.auth.features.register.data.repository

import com.refactoringlife.auth.features.register.data.datasource.localData.LocalDataUser
import com.refactoringlife.auth.features.register.data.datasource.service.UserServiceImp
import com.refactoringlife.auth.features.register.data.dto.request.UserRegisterRequest
import com.refactoringlife.auth.features.register.data.dto.responses.UserRegisterResponse
import com.refactoringlife.auth.features.register.domain.repository.UserRepository
import com.refactoringlife.core.common.result.AsyncResult
import kotlinx.coroutines.flow.Flow

class UserRepositoryImp(
    private val service: UserServiceImp = UserServiceImp()
) : UserRepository {

    private val localDataUser = LocalDataUser()

    override suspend fun userRegister(
        email: String?,
        password: String
    ): AsyncResult<UserRegisterResponse?, Exception> {
        val result = service.userRegister(
            UserRegisterRequest(email.orEmpty(), password)
        )

        result.getValueOrNull()?.let {
            localDataUser.saveLocalData(it)  // ← Usar instancia
        }
        return result
    }

    override fun listenerUserResponse(): Flow<UserRegisterResponse?> {
        return localDataUser.listenerUserResponse()  // ← Usar instancia
    }
}