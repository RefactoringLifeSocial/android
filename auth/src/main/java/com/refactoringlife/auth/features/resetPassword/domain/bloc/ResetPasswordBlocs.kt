package com.refactoringlife.auth.features.resetPassword.domain.bloc

class ResetPasswordBlocs{
    companion object {
        fun getResetPasswordBlocs() = listOf(HandleResetPasswordBloc())
    }
}
