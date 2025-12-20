package com.refactoringlife.auth.features.register.presentation.fragment

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
import com.refactoringlife.auth.features.register.presentation.screen.WelcomeRegisterScreen
import com.refactoringlife.auth.features.register.presentation.viewmodel.RegisterViewModel

class WelcomeRegisterFragment : Fragment() {

    val shareViewModel by activityViewModels <ShareViewModel> ()
    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val composeView = ComposeView(requireContext())
        composeView.setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
        )

        composeView.setContent {
            WelcomeRegisterScreen(
                goToFoundationRegister = {

                },
                goToUserRegister = {
                    shareViewModel.navigateTo(RegisterFragment())
                },
            )
        }
        return composeView
    }

    companion object {
        fun createInstance(): WelcomeRegisterFragment = WelcomeRegisterFragment()
    }
}
