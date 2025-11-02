package com.refactoringlife.auth.features.login.presentation.fragment

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
import com.refactoringlife.auth.features.login.presentation.screen.LoginScreen
import com.refactoringlife.auth.features.login.presentation.viewmodel.LoginViewModel
import com.refactoringlife.auth.features.register.presentation.fragment.RegisterFragment
import kotlin.getValue

class LoginFragment : Fragment() {

    val shareViewModel by activityViewModels <ShareViewModel> ()
    private val viewModel : LoginViewModel by viewModels()

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
                loginViewModel = viewModel,
                onBack = {
                    shareViewModel.goToBack()
                },
                goToRegister = {
                    shareViewModel.navigateTo(RegisterFragment())
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
}
