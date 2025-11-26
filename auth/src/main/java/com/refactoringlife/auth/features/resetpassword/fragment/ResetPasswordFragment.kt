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
        val token = arguments?.getString(ARG_TOKEN).orEmpty()
        val composeView = ComposeView(requireContext())
        composeView.setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
        )
        composeView.setContent {
            ResetPasswordScreen(
                viewModel = viewModel,
                token = token
            )
        }

        return composeView
    }

    companion object {
        private const val ARG_TOKEN = "arg_token"

        // PASO 3: createInstance ahora recibe el token
        fun createInstance(token: String): ResetPasswordFragment {
            val fragment = ResetPasswordFragment()
            fragment.arguments = Bundle().apply {
                putString(ARG_TOKEN, token)
            }
            return fragment
        }
    }
}
