package com.refactoringlife.auth.features.forgotpassword.data.repository

class RecoverPasswordRepositoryImp(
    private val serviceImp: UserServiceImp = UserServiceImp()
): RecoverPasswordRepository {

}