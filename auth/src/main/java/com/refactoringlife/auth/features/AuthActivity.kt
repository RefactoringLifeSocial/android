package com.refactoringlife.auth.features

import android.net.Uri
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.login.presentation.fragment.LoginFragment
import com.refactoringlife.auth.features.register.presentation.fragment.RegisterFragment
import com.refactoringlife.core.common.activities.BaseFragmentActivity
import com.refactoringlife.core.common.utils.DeepLinks

class AuthActivity : BaseFragmentActivity() {

    override fun getLayoutResId(): Int = R.layout.activity_auth
    override fun getContainerId(): Int = R.id.fragment_container
    override fun getDefaultFragment(): String = DeepLinks.Screen.LOGIN

    override fun handleDeepLink(data: Uri?, defaultFragment: String?) {
        when {
            data?.path?.contains(DeepLinks.Routes.authLogin()) == true -> goToLoginFragment()
            data?.path?.contains(DeepLinks.Routes.authRegister()) == true -> goToRegisterFragment()
            defaultFragment == DeepLinks.Screen.LOGIN -> goToLoginFragment()
            else -> goToRegisterFragment()
        }
    }

    fun goToLoginFragment() {
        navigationManager.navigateToInitial(LoginFragment.createInstance())
    }

    fun goToRegisterFragment() {
        navigationManager.navigateTo(RegisterFragment.createInstance())
    }
}
