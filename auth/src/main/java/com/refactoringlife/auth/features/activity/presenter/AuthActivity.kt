package com.refactoringlife.auth.features.activity.presenter

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.refactoringlife.auth.R
import com.refactoringlife.auth.core.share.ShareStatus
import com.refactoringlife.auth.core.share.ShareViewModel
import com.refactoringlife.auth.features.activity.domain.blocs.AuthEvent
import com.refactoringlife.auth.features.activity.presenter.viewModel.AuthViewModel
import com.refactoringlife.auth.features.activity.domain.state.NavigationDestination
import com.refactoringlife.auth.features.home.presentation.fragment.HomeFragment
import com.refactoringlife.core.common.activities.BaseActivity
import com.refactoringlife.core.common.utils.ADOPTION_DEEPLINK
import com.refactoringlife.core.common.utils.DeepLinkRouter
import com.refactoringlife.core.common.utils.navigateToDeeplink
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import androidx.core.view.WindowCompat

@AndroidEntryPoint
class AuthActivity : BaseActivity(R.id.fragment_container) {

    val shareViewModel by viewModels<ShareViewModel>()
    private val authViewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val handled = handleDeepLinkIfNeeded(intent)

        if (!handled && savedInstanceState == null) {
            authViewModel.sendEvent(AuthEvent.CheckInitialNavigation)
        }
        observer()
        observeAuthState()
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleDeepLinkIfNeeded(intent)
    }

    override fun onResume() {
        super.onResume()
        handleDeepLinkIfNeeded(intent)
    }

    private fun handleDeepLinkIfNeeded(intent: Intent?): Boolean {
        val uri = intent?.data ?: return false
        val result = DeepLinkRouter.parseDeepLink(uri)
        val isValid = result is DeepLinkRouter.DeepLinkResult.ResetPassword

        if (isValid) {
            authViewModel.sendEvent(AuthEvent.HandleDeepLink(uri))
            intent.data = null
        }
        return isValid
    }

    private fun observeAuthState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                authViewModel.state.collectLatest { state ->
                    state.navigationDestination?.let { destination ->
                        handleNavigation(destination)
                        authViewModel.sendEvent(AuthEvent.ClearNavigation)
                    }
                }
            }
        }
    }

    private fun handleNavigation(destination: NavigationDestination) {
        when (destination) {
            is NavigationDestination.NavigateToRoot -> {
                navigateToRoot(destination.fragment)
            }
            is NavigationDestination.NavigateTo -> {
                navigateTo(destination.fragment)
            }
            is NavigationDestination.NavigateToDeeplink -> {
                navigateToDeeplink(destination.deeplink)
                finish()
            }
            is NavigationDestination.Finish -> {
                finish()
            }
            is NavigationDestination.GoBack -> {
                onBack()
            }
        }
    }

    fun observer() {
        shareViewModel.status.observe(this) { status ->
            when (status) {
                is ShareStatus.GoToBack -> {
                    onBack()
                }

                is ShareStatus.NavigateTo -> {
                    navigateTo(status.fragment)
                }

                is ShareStatus.NavigateToRoot -> {
                    navigateToRoot(HomeFragment.Companion.createInstance("id"))
                }

                is ShareStatus.GoToAdoption -> {
                    navigateToDeeplink(deeplink = ADOPTION_DEEPLINK)
                    finish()
                }
            }
        }
    }
}