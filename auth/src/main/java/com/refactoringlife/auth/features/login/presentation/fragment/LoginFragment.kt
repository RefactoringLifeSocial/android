package com.refactoringlife.auth.features.login.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.login.presentation.screen.LoginScreen
import com.refactoringlife.auth.features.register.presentation.fragment.RegisterFragment
import com.refactoringlife.core.common.navigation.NavigationManager

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val composeView = ComposeView(requireContext())
        composeView.setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
        )
        val navigationManager = NavigationManager(requireActivity(), R.id.fragment_container)
        composeView.setContent {
            LoginScreen(
                onBack = {
                    onBack(navigationManager = navigationManager)
                },
                goToRegister = {
                    goToRegister(navigationManager = navigationManager)
                },
                success = {

                }
            )
        }
        return composeView
    }

    companion object {
        fun createInstance(): LoginFragment = LoginFragment()
    }

    private fun onBack(navigationManager: NavigationManager) {
        navigationManager.onBack()
    }

    private fun goToRegister(navigationManager: NavigationManager) {
        requireActivity().supportFragmentManager.popBackStack()
        navigationManager.navigateTo(fragment = RegisterFragment.createInstance())
    }
}
