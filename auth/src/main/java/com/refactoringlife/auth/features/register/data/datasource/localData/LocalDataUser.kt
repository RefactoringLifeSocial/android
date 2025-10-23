package com.refactoringlife.auth.features.register.data.datasource.localData

import com.refactoringlife.auth.features.register.data.dto.responses.UserRegisterResponse
import com.refactoringlife.core.data.local.LocalDataRepositoryImpl
import kotlinx.coroutines.flow.Flow

class LocalDataUser {

    private val dataRepository: LocalDataRepositoryImpl<UserRegisterResponse> =
        LocalDataRepositoryImpl("user_register_response")

    fun listenerUserResponse(): Flow<UserRegisterResponse?> {
        return dataRepository.observe()
    }

    suspend fun saveLocalData(data: UserRegisterResponse) {
        dataRepository.saveData(data)
    }

    suspend fun clear() {
        dataRepository.clearData()
    }

    suspend fun getCurrentData(): UserRegisterResponse? {
        return dataRepository.getData()
    }
}
