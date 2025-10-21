package com.refactoringlife.auth.features.register.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.fragment.app.Fragment
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.refactoringlife.auth.features.register.domain.blocs.RegisterEvent
import com.refactoringlife.auth.features.register.presentation.screen.RegisterScreen
import com.refactoringlife.auth.features.register.presentation.viewmodel.RegisterViewModel

class RegisterFragment : Fragment() {

    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val composeView = ComposeView(requireContext())
        composeView.setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
        )
        composeView.setContent {
            RegisterScreen(
                onBack = {},
                onClickRegister = { email, password ->
                    viewModel.sendEvent(RegisterEvent.Register(email, password))
                }
            )
        }
        return composeView
    }

    companion object {
        fun createInstance(): RegisterFragment = RegisterFragment()
    }
}