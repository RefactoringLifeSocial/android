package com.refactoringlife.auth.features.forgotpassword.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.refactoringlife.auth.core.share.ShareViewModel
import com.refactoringlife.auth.features.forgotpassword.presentation.screen.ForgotPasswordScreen
import com.refactoringlife.auth.features.forgotpassword.presentation.viewmodel.ForgotPasswordViewModel

class ForgotPasswordFragment : Fragment() {

    val shareViewModel by activityViewModels<ShareViewModel>()
    private val viewModel: ForgotPasswordViewModel by viewModels()

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
            ForgotPasswordScreen(
                viewModel = viewModel
            )
        }
        return composeView
    }
    companion object {
        fun createInstance(): ForgotPasswordFragment = ForgotPasswordFragment()
    }
}
