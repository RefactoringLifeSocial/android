package com.refactoringlife.auth.features.forgotpassword.data.repository

import com.refactoringlife.auth.features.forgotpassword.data.dto.request.UserSendEmailRequest
import com.refactoringlife.auth.features.forgotpassword.data.dto.response.UserSendEmailResponse
import com.refactoringlife.auth.features.register.data.datasource.service.UserServiceImp
import com.refactoringlife.core.common.result.AsyncResult

class RecoverPasswordRepositoryImp(
    private val serviceImp: UserServiceImp = UserServiceImp()
) : RecoverPasswordRepository {
    override suspend fun userSendEmail(userSendEmailRequest: UserSendEmailRequest): AsyncResult<UserSendEmailResponse?, Exception> {
        val result = serviceImp.userSendEmail(userSendEmailRequest)
        return result
    }
}
