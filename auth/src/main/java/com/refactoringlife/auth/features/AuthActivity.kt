package com.refactoringlife.auth.features

import android.net.Uri
import android.os.Bundle
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.home.presentation.fragment.HomeFragment
import com.refactoringlife.auth.features.login.domain.state.LoginState
import com.refactoringlife.auth.features.login.presentation.fragment.LoginFragment
import com.refactoringlife.auth.features.register.presentation.fragment.RegisterFragment
import com.refactoringlife.core.common.activities.BaseFragmentActivity
import com.refactoringlife.core.common.navigation.NavigationManager

class AuthActivity : BaseFragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        navigationManager = NavigationManager(this, R.id.fragment_container)

        setupBackPressedHandler()

        goToLogin()
    }

    private fun goToRegister(){
        navigationManager.navigateToRoot(RegisterFragment.createInstance())
    }

    private fun goToHome(){
        navigationManager.navigateToRoot(HomeFragment.createInstance("id"))
    }

    private fun goToLogin(){
        navigationManager.navigateToRoot(LoginFragment.createInstance())
    }
}
