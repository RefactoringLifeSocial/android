package com.refactoringlife.auth.features.onboarding.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.refactoringlife.auth.core.share.ShareViewModel
import com.refactoringlife.auth.features.home.presentation.fragment.HomeFragment
import com.refactoringlife.auth.features.onboarding.presentation.content.ContentOnboardingPage2
import com.refactoringlife.core.data.datastore.AppPreferencesRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class OnboardingPage2Fragment : Fragment() {

    val shareViewModel by activityViewModels<ShareViewModel>()

    @Inject
    lateinit var appPreferencesRepository: AppPreferencesRepository

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
            ContentOnboardingPage2(
                onNextClick = {
                    shareViewModel.navigateTo(OnboardingPage3Fragment())
                },
                onSkipClick = {
                    lifecycleScope.launch {
                        appPreferencesRepository.setOnboardingCompleted(true)
                        shareViewModel.navigateTo(HomeFragment.createInstance("id"))
                    }
                }
            )
        }
        return composeView
    }
}