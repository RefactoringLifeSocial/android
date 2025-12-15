package com.refactoringlife.auth.features.forgotpassword.domain.bloc

import com.refactoringlife.auth.features.forgotpassword.data.dto.request.UserSendEmailRequest
import com.refactoringlife.auth.features.forgotpassword.domain.state.ForgotPasswordState
import com.refactoringlife.auth.features.forgotpassword.domain.usecases.SendEmailResponseUseCase
import com.refactoringlife.core.common.utils.isValidEmail

class HandleForgotPasswordBloc(
    val sendEmailResponseUseCase: SendEmailResponseUseCase
) : ForgotPasswordBaseBloc {
    override fun canHandle(event: ForgotPasswordEvent) = event is ForgotPasswordEvent.ForgotPassword

    override suspend fun handle(
        event: ForgotPasswordEvent,
        update: suspend (suspend (ForgotPasswordState) -> ForgotPasswordState) -> Unit
    ) {

        if (event !is ForgotPasswordEvent.ForgotPassword) {
            return
        }

        if (event.email.isValidEmail()) {
            update {
                it.copy(showModal = true)
            }

            val request = UserSendEmailRequest(event.email)

            sendEmailResponseUseCase(request)
        }
    }
}
