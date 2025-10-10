package com.refactoringlife.auth.features.register.data.datasource.localData

import com.refactoringlife.auth.features.register.data.dto.responses.UserRegisterResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.update

object LocalDataUser {

    private val userRegisterResponse: MutableStateFlow<UserRegisterResponse?> = MutableStateFlow(null)

    fun listenerUserResponse(): Flow<UserRegisterResponse?> {
        return userRegisterResponse
    }

    fun saveLocalData(data: UserRegisterResponse) {
        userRegisterResponse.update { data }
    }

    fun clear() {
        userRegisterResponse.value = null
    }
}
