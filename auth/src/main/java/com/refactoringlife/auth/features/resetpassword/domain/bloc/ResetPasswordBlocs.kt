package com.refactoringlife.auth.features.resetpassword.domain.bloc

class ResetPasswordBlocs{
    companion object {
        fun getResetPasswordBlocs() = listOf(HandleResetPasswordBloc())
    }
}
