package com.refactoringlife.auth.features.resetpassword.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.refactoringlife.auth.features.resetpassword.presentation.screen.ResetPasswordScreen
import com.refactoringlife.auth.features.resetpassword.presentation.viewmodel.ResetPasswordViewModel

class ResetPasswordFragment : Fragment() {

    private val viewModel: ResetPasswordViewModel by viewModels()

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
            ResetPasswordScreen(
                viewModel = viewModel
            )
        }

        return composeView
    }

    companion object {
        fun createInstance(): ResetPasswordFragment = ResetPasswordFragment()
    }
}
