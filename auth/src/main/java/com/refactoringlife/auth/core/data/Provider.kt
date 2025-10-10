package com.refactoringlife.auth.core.data

import com.refactoringlife.auth.core.data.service.UserService
import com.refactoringlife.core.data.network.OKHttpProvider
import com.refactoringlife.core.data.network.RetrofitProvider

val serviceProvider: UserService =
    RetrofitProvider.create(OKHttpProvider.create()).create(UserService::class.java)