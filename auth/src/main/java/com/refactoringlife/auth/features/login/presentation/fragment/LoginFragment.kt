package com.refactoringlife.auth.features.login.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.refactoringlife.auth.features.AuthActivity
import com.refactoringlife.auth.features.login.presentation.screen.LoginScreen
import com.refactoringlife.auth.features.login.presentation.viewmodel.LoginViewModel

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
        //val viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        composeView.setContent {
            LoginScreen(
                onRegisterClick = {
                    (requireActivity() as AuthActivity).goToRegisterFragment()
                }
            )
        }
        return composeView
    }

    companion object {
        fun createInstance(): LoginFragment = LoginFragment()
    }
}
