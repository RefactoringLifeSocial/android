package com.refactoringlife.auth.features.login.domain.model

data class UserLoginModel(
    val accessToken: String?,
    val refreshToken: String?,
    val message: String?,
    val status: String?,
    val errorCode: String?
)
