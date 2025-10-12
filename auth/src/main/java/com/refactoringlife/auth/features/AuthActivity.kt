package com.refactoringlife.auth.features

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.login.presentation.fragment.LoginFragment
import com.refactoringlife.auth.features.register.presentation.fragment.RegisterFragment
import com.refactoringlife.core.common.utils.DeepLinks

class AuthActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        handleDeepLink()
    }

    private fun handleDeepLink() {
        val data: Uri? = intent.data
        val defaultFragment = intent.getStringExtra("default_fragment")

        when {
            data?.path?.contains(DeepLinks.Routes.authLogin()) == true -> {
                goToLoginFragment()
            }
            data?.path?.contains(DeepLinks.Routes.authRegister()) == true -> {
                goToRegisterFragment()
            }
            defaultFragment == DeepLinks.Screen.LOGIN -> {
                goToLoginFragment()
            }
            else -> {
                goToRegisterFragment()
            }
        }
    }

     fun goToLoginFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, LoginFragment.createInstance())
            .commit()
    }

     fun goToRegisterFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, RegisterFragment.createInstance())
            .commit()
    }
}