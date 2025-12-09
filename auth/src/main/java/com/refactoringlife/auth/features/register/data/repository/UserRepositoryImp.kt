package com.refactoringlife.auth.features.register.data.repository

import com.refactoringlife.auth.features.register.data.datasource.localData.LocalDataUser
import com.refactoringlife.auth.features.register.data.datasource.service.UserServiceImp
import com.refactoringlife.auth.features.register.data.dto.request.UserRegisterRequest
import com.refactoringlife.auth.features.register.data.dto.responses.UserRegisterResponse
import com.refactoringlife.auth.features.register.domain.model.UserRegisterParams
import com.refactoringlife.auth.features.register.domain.repository.UserRepository
import com.refactoringlife.core.common.result.AsyncResult
import kotlinx.coroutines.flow.Flow

class UserRepositoryImp(
    private val service: UserServiceImp = UserServiceImp()
) : UserRepository {

    override suspend fun userRegister(params: UserRegisterParams): AsyncResult<UserRegisterResponse?, Exception> {
        val result = service.userRegister(
            UserRegisterRequest(
                image = null,
                name = params.name,
                country = params.country,
                address = params.address,
                phone = params.phone,
                email = params.email,
                password = params.password
            )
        )

        result.getValueOrNull()?.let {
            LocalDataUser.saveLocalData(it)
        }
        return result
    }

    override fun listenerUserResponse(): Flow<UserRegisterResponse?> {
        return LocalDataUser.listenerUserResponse()
    }
}
