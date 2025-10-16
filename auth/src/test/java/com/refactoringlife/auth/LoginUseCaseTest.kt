package com.refactoringlife.auth

import com.refactoringlife.auth.features.login.data.dto.request.UserLoginRequest
import com.refactoringlife.auth.features.login.data.dto.responses.UserLoginResponse
import com.refactoringlife.auth.features.login.domain.model.UserLoginModel
import com.refactoringlife.auth.features.login.domain.repository.UserLoginRepository
import com.refactoringlife.auth.features.login.domain.usecases.UserLoginUserCase
import com.refactoringlife.core.common.result.AsyncResult
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class LoginUseCaseTest {
    private val mockRepository: UserLoginRepository = mock()
    private lateinit var useCase: UserLoginUserCase

    private val fakeRequest = UserLoginRequest("user@gmail.com", "password01")

    @Before
    fun setUp() {
        useCase = UserLoginUserCase(repository = mockRepository)
    }

    @Test
    fun `should map and return Success when repository succeeds with valid data`() = runTest {
        // GIVEN
        val repoResponse = UserLoginResponse(
            accessToken = "access_token",
            refreshToken = "refresh_token",
            message = "Login successful", status = "OK",
            errorCode = ""
        )
        val expectedModel = UserLoginModel(
            accessToken = "access_token",
            refreshToken = "refresh_token",
            message = "Login successful",
            status = "OK", errorCode = ""
        )

        whenever(runBlocking { mockRepository.userLogin(fakeRequest) }) doReturn AsyncResult.Success(
            repoResponse
        )

        // WHEN
        val result = useCase.invoke(fakeRequest)

        // THEN
        assertEquals(
            AsyncResult.Success<UserLoginModel?, Exception>(expectedModel),
            result
        )
        verify(mockRepository, times(1)).userLogin(fakeRequest)
    }

    @Test
    fun `should return Failure when repository returns an error`() = runTest {
        // GIVEN
        val networkError = Exception("HTTP 401")
        whenever(runBlocking { mockRepository.userLogin(fakeRequest) }) doReturn AsyncResult.Failure(
            networkError
        )

        // WHEN
        val result = useCase.invoke(fakeRequest)

        // THEN
        assertEquals(
            AsyncResult.Failure<UserLoginModel?, Exception>(networkError),
            result
        )
        verify(mockRepository, times(1)).userLogin(fakeRequest)
    }

    @Test
    fun `should return Success null when repository succeeds with null response`() = runTest {
        // GIVEN
        whenever(runBlocking { mockRepository.userLogin(fakeRequest) }) doReturn AsyncResult.Success(
            null
        )

        // WHEN
        val result = useCase.invoke(fakeRequest)

        // THEN
        assertEquals(
            AsyncResult.Success<UserLoginModel?, Exception>(null),
            result
        )
        verify(mockRepository, times(1)).userLogin(fakeRequest)
    }
}