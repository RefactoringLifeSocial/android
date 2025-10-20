package com.refactoringlife.auth.features.register.domain.blocs

import com.refactoringlife.auth.features.register.domain.usecases.RegisterResponseUseCase
import com.refactoringlife.core.common.result.AsyncResult

class HandleRegisterBloc(
    private val userRegisterResponseUseCase: RegisterResponseUseCase = RegisterResponseUseCase()
) : RegisterBaseBloc {

    override fun canHandle(event: RegisterEvent): Boolean {
        return event is RegisterEvent.UserRegister
    }

    override suspend fun handle(event: RegisterEvent, update: RegisterStateUpdate) {
        if (event is RegisterEvent.UserRegister){

            val result = userRegisterResponseUseCase(event.email.orEmpty(), event.password.orEmpty())
            when(result){
                is AsyncResult.Success -> {}

                is AsyncResult.Failure -> {
                    update{
                        it.copy(
                            isError = result.error.message ?: "Generic Error"
                        )
                    }
                }
            }
        }
    }
}
