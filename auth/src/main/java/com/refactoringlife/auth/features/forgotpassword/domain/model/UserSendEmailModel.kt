package com.refactoringlife.auth.features.forgotpassword.domain.model

data class UserSendEmailModel(
    val message: String?,
    val token: String? = null,
    val resetUrl: String? = null
)
