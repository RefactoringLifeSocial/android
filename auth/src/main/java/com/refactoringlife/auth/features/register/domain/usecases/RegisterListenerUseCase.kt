package com.refactoringlife.auth.features.register.domain.usecases

import com.refactoringlife.auth.features.register.data.repository.UserRepositoryImp
import com.refactoringlife.auth.features.register.domain.mappers.toUserRegisterModel
import com.refactoringlife.auth.features.register.domain.model.UserRegisterModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map

class RegisterListenerUseCase(val repositoryImp: UserRepositoryImp) {

    operator fun invoke(): Flow<UserRegisterModel> {
        return repositoryImp.listenerUserResponse().map { response ->
                response?.toUserRegisterModel()
            }.filterNotNull()

    }
}
