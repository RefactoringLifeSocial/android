package com.refactoringlife.auth.features.onboarding.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.refactoringlife.auth.core.share.ShareViewModel
import com.refactoringlife.auth.features.home.presentation.fragment.HomeFragment
import com.refactoringlife.auth.features.onboarding.presentation.content.ContentOnboardingPage3

class OnboardingPage3Fragment : Fragment() {
    val shareViewModel by activityViewModels<ShareViewModel>()

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
            ContentOnboardingPage3(
                onNextClick = {
                    shareViewModel.navigateTo(OnboardingPage4Fragment())
                },
                onSkipClick = {
                    shareViewModel.navigateToRoot(HomeFragment.createInstance("id"))
                }
            )
        }
        return composeView
    }
}
