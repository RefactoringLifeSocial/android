package com.refactoringlife.auth.features

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.login.presentation.fragment.LoginFragment

class AuthActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        goToFragment()
    }

    private fun goToFragment() {
        val fragment = LoginFragment.createInstance()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.view, fragment)
            .commit()
    }
}