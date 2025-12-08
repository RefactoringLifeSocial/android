package com.refactoringlife.auth.features.home.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.refactoringlife.auth.core.share.ShareViewModel
import com.refactoringlife.auth.features.home.presentation.content.HomeContent
import com.refactoringlife.auth.features.login.presentation.fragment.LoginFragment
import com.refactoringlife.auth.features.register.presentation.fragment.RegisterFragment
import com.refactoringlife.auth.features.register.presentation.fragment.WelcomeRegisterFragment

class HomeFragment : Fragment() {

    val shareViewModel by activityViewModels<ShareViewModel>()
    private var id = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val composeView = ComposeView(requireContext())
        composeView.setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
        )
        arguments?.let {
            id = it.getString("id").toString()
        }

        composeView.setContent {

            HomeContent(
                onRegisterClick = {
                    shareViewModel.navigateTo(WelcomeRegisterFragment())
                },
                onLoginClick = {
                    shareViewModel.navigateTo(LoginFragment())
                },
            )
        }
        return composeView
    }

    companion object {
        fun createInstance(id: String): HomeFragment {
            return HomeFragment().apply {
                arguments = Bundle().apply {
                    putString("id", id)
                }
            }
        }
    }
}
