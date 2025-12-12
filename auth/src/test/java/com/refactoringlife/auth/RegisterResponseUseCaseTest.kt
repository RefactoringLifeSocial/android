package com.refactoringlife.auth

import com.refactoringlife.auth.features.register.data.dto.request.UserRegisterRequest
import com.refactoringlife.auth.features.register.data.dto.responses.UserRegisterResponse
import com.refactoringlife.auth.features.register.domain.model.UserRegisterParams
import com.refactoringlife.auth.features.register.domain.usecases.RegisterResponseUseCase
import com.refactoringlife.core.common.result.AsyncResult
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Assert.fail

class RegisterResponseUseCaseTest {

    private val dummyParams = UserRegisterRequest(
        name = "Test Name",
        country = "Test Country",
        address = "Test Address",
        phone = "123456789",
        email = "test@email.com",
        password = "password123",
        image = ""
    )

    @Test
    fun `when repository returns Failure, useCase returns Failure with same error`() = runBlocking {
        val repo = mock<com.refactoringlife.auth.features.register.data.repository.UserRepositoryImp>()
        val ex = Exception("repo fail")
        whenever(repo.userRegister(dummyParams)).thenReturn(AsyncResult.Failure(error = ex))

        val useCase = RegisterResponseUseCase(repo)
        val result = runBlocking { useCase.invoke(dummyParams) }

        assertTrue(result is AsyncResult.Failure)
        assertEquals(ex, (result as AsyncResult.Failure).error)
    }

    @Test
    fun `when repository returns Success with null value, useCase returns Failure Data is null`() = runBlocking {
        val repo = mock<com.refactoringlife.auth.features.register.data.repository.UserRepositoryImp>()
        whenever(repo.userRegister(dummyParams)).thenReturn(AsyncResult.Success(value = null))

        val useCase = RegisterResponseUseCase(repo)
        val result = runBlocking { useCase.invoke(dummyParams) }

        assertTrue(result is AsyncResult.Failure)
        assertEquals("Data is null", (result as AsyncResult.Failure).error.message)
    }

    @Test
    fun `when repository returns Success with response, useCase maps to UserRegisterModel Success`() = runBlocking {
        val repo = mock<com.refactoringlife.auth.features.register.data.repository.UserRepositoryImp>()

        val response = mock<UserRegisterResponse>()

        whenever(repo.userRegister(dummyParams)).thenReturn(AsyncResult.Success(value = response))

        val useCase = RegisterResponseUseCase(repo)
        val result = runBlocking { useCase.invoke(dummyParams) }

        if (result is AsyncResult.Success) {
            val model = result.value
            assertNotNull(model)
            assertEquals(
                com.refactoringlife.auth.features.register.domain.model.UserRegisterModel::class,
                model!!::class
            )
        } else {
            fail("Expected Success but got $result")
        }
    }
}