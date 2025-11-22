package com.refactoringlife.auth.features.forgotpassword.data.repository

import com.refactoringlife.auth.features.forgotpassword.data.dto.request.UserSendEmailRequest
import com.refactoringlife.auth.features.forgotpassword.data.dto.response.UserSendEmailResponse
import com.refactoringlife.auth.features.register.data.dto.responses.UserRegisterResponse
import com.refactoringlife.core.common.result.AsyncResult
import kotlinx.coroutines.flow.Flow

interface RecoverPasswordRepository {
    suspend fun userSendEmail(userSendEmailRequest: UserSendEmailRequest): AsyncResult<UserSendEmailResponse?, Exception>
}
