package com.refactoringlife.auth.features.forgotpassword.domain.usecases

import android.util.Log
import com.refactoringlife.auth.features.forgotpassword.data.dto.request.UserSendEmailRequest
import com.refactoringlife.auth.features.forgotpassword.data.repository.RecoverPasswordRepositoryImp
import com.refactoringlife.auth.features.forgotpassword.domain.mapper.toUserSendEmailModel
import com.refactoringlife.auth.features.forgotpassword.domain.model.UserSendEmailModel
import com.refactoringlife.core.common.result.AsyncResult

class SendEmailResponseUseCase(val repositoryImp: RecoverPasswordRepositoryImp = RecoverPasswordRepositoryImp()) {
    suspend operator fun invoke(
        userSendEmailRequest: UserSendEmailRequest
    ): AsyncResult<UserSendEmailModel?, Exception> {
        return when (val result = repositoryImp.userSendEmail(userSendEmailRequest)) {
            is AsyncResult.Failure -> {
                AsyncResult.Failure(error = result.error)
            }

            is AsyncResult.Success -> {
                result.value?.let { response ->
                    AsyncResult.Success(response.toUserSendEmailModel())
                } ?: AsyncResult.Failure(Exception("Data is null"))
            }
        }
    }
}