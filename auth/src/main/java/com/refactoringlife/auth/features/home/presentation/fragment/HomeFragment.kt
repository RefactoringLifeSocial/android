package com.refactoringlife.auth.features.home.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.home.presentation.content.HomeContent
import com.refactoringlife.auth.features.login.presentation.fragment.LoginFragment
import com.refactoringlife.auth.features.register.presentation.fragment.RegisterFragment
import com.refactoringlife.core.common.navigation.NavigationManager

class HomeFragment : Fragment() {

    private var id = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val composeView = ComposeView(requireContext())
        composeView.setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
        )
        arguments?.let {
            id = it.getString("id").toString()
        }
        val navigationManager = NavigationManager(requireActivity(), R.id.fragment_container)

        composeView.setContent {
            HomeContent(
                onRegisterClick = {
                    goToRegister(navigationManager = navigationManager)
                },
                onLoginClick = {
                    goToLogin(navigationManager = navigationManager)
                },
                onGoogleLoginClick = {},
                goToSupport = {}
            )
        }
        return composeView
    }

    companion object {
        fun createInstance(id: String): HomeFragment {
            return HomeFragment().apply {
                arguments = Bundle().apply {
                    putString("id", id)
                }
            }
        }
    }
    private fun goToRegister(navigationManager: NavigationManager) {
        navigationManager.navigateTo(fragment = RegisterFragment.createInstance())
    }

    private fun goToLogin(navigationManager: NavigationManager) {
        navigationManager.navigateTo(fragment = LoginFragment.createInstance())
    }
}
