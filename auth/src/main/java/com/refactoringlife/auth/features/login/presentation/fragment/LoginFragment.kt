package com.refactoringlife.auth.features.login.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.refactoringlife.auth.features.login.presentation.screen.LoginScreen

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
        composeView.setContent {
            LoginScreen(
                onBack = {
                    // Manejar navegación hacia atrás
                }
            )
        }
        return composeView
    }

    companion object {
        fun createInstance(): LoginFragment = LoginFragment()
    }
}
