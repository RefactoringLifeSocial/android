package com.refactoringlife.auth

import com.refactoringlife.auth.features.register.data.dto.responses.UserRegisterResponse
import com.refactoringlife.auth.features.register.domain.usecases.RegisterListenerUseCase
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

class RegisterListenerUseCaseTest {

    @Test
    fun `repository emits responses - useCase maps and filters nulls`() = runBlocking {
        val repo = mock<com.refactoringlife.auth.features.register.data.repository.UserRepositoryImp>()

        val response1 = mock<UserRegisterResponse>()
        val response2 = mock<UserRegisterResponse>()

        whenever(repo.listenerUserResponse()).thenReturn(flowOf(response1, null, response2))

        val useCase = RegisterListenerUseCase(repo)

        val emitted = mutableListOf<com.refactoringlife.auth.features.register.domain.model.UserRegisterModel>()
        useCase().toList(emitted)

        assertEquals(2, emitted.size)

        emitted.forEach {
            assertEquals(
                com.refactoringlife.auth.features.register.domain.model.UserRegisterModel::class,
                it::class
            )
        }
    }

    @Test
    fun `repository emits only nulls - useCase emits nothing`() = runBlocking {
        val repo = mock<com.refactoringlife.auth.features.register.data.repository.UserRepositoryImp>()

        whenever(repo.listenerUserResponse()).thenReturn(flowOf(null, null))

        val useCase = RegisterListenerUseCase(repo)

        val emitted = mutableListOf<com.refactoringlife.auth.features.register.domain.model.UserRegisterModel>()
        useCase().toList(emitted)

        assertTrue(emitted.isEmpty())
    }
}