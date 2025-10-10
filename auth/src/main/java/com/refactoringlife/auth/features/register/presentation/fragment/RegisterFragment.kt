package com.refactoringlife.auth.features.register.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.fragment.findNavController
import com.refactoringlife.auth.features.register.presentation.screen.RegisterScreen

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
        composeView.setContent {
            RegisterScreen(
                onBack = {
                    findNavController().navigateUp()
                }
            )
        }
        return composeView
    }

    companion object {
        fun createInstance(): RegisterFragment = RegisterFragment()
    }
}