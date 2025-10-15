package com.refactoringlife.auth.features.register.domain.mappers

import com.refactoringlife.auth.features.register.data.dto.responses.UserRegisterResponse
import com.refactoringlife.auth.features.register.domain.model.UserRegisterModel

fun UserRegisterResponse.toUserRegisterModel(): UserRegisterModel {
    return UserRegisterModel(
        message = this.message,
        status = this.status,
        errorCode = this.errorCode
    )
}
