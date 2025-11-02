package com.refactoringlife.auth.features.login.data.datasource.service

import com.google.firebase.auth.FirebaseAuth

class GoogleService {
    val auth by lazy {
        FirebaseAuth.getInstance()
    }
}