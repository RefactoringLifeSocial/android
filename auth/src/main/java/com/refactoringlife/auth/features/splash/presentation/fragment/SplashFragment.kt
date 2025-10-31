package com.refactoringlife.auth.features.splash.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.refactoringlife.auth.core.share.ShareViewModel
import com.refactoringlife.auth.features.home.presentation.fragment.HomeFragment
import com.refactoringlife.auth.features.splash.domain.blocs.SplashEvent
import com.refactoringlife.auth.features.splash.presentation.screen.SplashScreen
import com.refactoringlife.auth.features.splash.presentation.viewmodel.SplashViewModel
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {

    private val shareViewModel by activityViewModels<ShareViewModel>()
    private val splashViewModel: SplashViewModel by viewModels()

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
            SplashScreen(
                splashViewModel = splashViewModel,
                onFinish = {
                    shareViewModel.navigateTo(HomeFragment.createInstance("id"))
                }
            )
        }

        viewLifecycleOwner.lifecycleScope.launch {
            splashViewModel.sendEvent(SplashEvent.Start)
        }

        return composeView
    }

    companion object {
        fun createInstance(): SplashFragment = SplashFragment()
    }
}
