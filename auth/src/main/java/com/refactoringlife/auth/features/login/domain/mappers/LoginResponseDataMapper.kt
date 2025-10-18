package com.refactoringlife.auth.features.login.domain.mappers

import com.refactoringlife.auth.features.login.data.dto.responses.UserLoginResponse
import com.refactoringlife.auth.features.login.domain.model.UserLoginModel

object LoginResponseDataMapper {
    fun map(response: UserLoginResponse): UserLoginModel {
        return UserLoginModel(
            accessToken = response.accessToken,
            refreshToken = response.refreshToken,
            message = response.message,
            status = response.status,
            errorCode = response.errorCode
        )
    }
}