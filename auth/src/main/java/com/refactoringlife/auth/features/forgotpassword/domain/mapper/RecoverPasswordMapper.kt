package com.refactoringlife.auth.features.forgotpassword.domain.mapper

import com.refactoringlife.auth.features.forgotpassword.data.dto.response.UserSendEmailResponse
import com.refactoringlife.auth.features.forgotpassword.domain.model.UserSendEmailModel

fun UserSendEmailResponse.toUserSendEmailModel(): UserSendEmailModel {
    return UserSendEmailModel(
        message = this.message,
        token = this.token,
        resetUrl = this.resetUrl
    )
}
