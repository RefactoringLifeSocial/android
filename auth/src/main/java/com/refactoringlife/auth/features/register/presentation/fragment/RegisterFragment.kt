package com.refactoringlife.auth.features.register.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.refactoringlife.auth.R
import com.refactoringlife.auth.features.AuthActivity
import com.refactoringlife.auth.features.register.presentation.screen.RegisterScreen
import com.refactoringlife.core.common.navigation.NavigationManager

class RegisterFragment : Fragment() {

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
            RegisterScreen(
                onBack = {
                    onBack(navigationManager = navigationManager)
                }
            )
        }
        return composeView
    }

    companion object {
        fun createInstance(): RegisterFragment = RegisterFragment()
    }
    private fun onBack(navigationManager: NavigationManager){
        navigationManager.onBack()
    }
}