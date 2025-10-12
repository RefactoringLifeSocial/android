package com.refactoringlife.auth.features

import android.net.Uri
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentActivity
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.login.presentation.fragment.LoginFragment
import com.refactoringlife.auth.features.register.presentation.fragment.RegisterFragment
import com.refactoringlife.core.common.navigation.NavigationManager
import com.refactoringlife.core.common.utils.DeepLinks

class AuthActivity : FragmentActivity() {

    private lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        navigationManager = NavigationManager(this, R.id.fragment_container)

        handleDeepLink()
        setupBackPressedHandler()
    }

    private fun setupBackPressedHandler() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (navigationManager.canGoBack()) {
                    navigationManager.navigateBack()
                } else {
                    finishAffinity()

                }
            }
        })
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
        navigationManager.navigateToInitial(LoginFragment.createInstance())
    }

    fun goToRegisterFragment() {
        navigationManager.navigateTo(RegisterFragment.createInstance())
    }
}
