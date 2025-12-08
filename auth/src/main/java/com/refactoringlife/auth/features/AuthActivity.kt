package com.refactoringlife.auth.features

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.firebase.auth.FirebaseAuth
import com.refactoringlife.auth.R
import com.refactoringlife.auth.core.share.ShareStatus
import com.refactoringlife.auth.core.share.ShareViewModel
import com.refactoringlife.auth.features.home.presentation.fragment.HomeFragment
import com.refactoringlife.auth.features.onboarding.presentation.fragment.OnboardingPage1Fragment
import com.refactoringlife.auth.features.resetpassword.fragment.ResetPasswordFragment
import com.refactoringlife.core.common.activities.BaseActivity
import com.refactoringlife.core.common.utils.ADOPTION_DEEPLINK
import com.refactoringlife.core.common.utils.DeepLinkRouter
import com.refactoringlife.core.common.utils.navigateToDeeplink
import com.refactoringlife.core.data.datastore.AppPreferencesRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class AuthActivity : BaseActivity(R.id.fragment_container) {

    val shareViewModel by viewModels<ShareViewModel>()

    @Inject
    lateinit var appPreferencesRepository: AppPreferencesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val handledDeepLink = handleDeepLinkIfNeeded(intent)

        if (!handledDeepLink && savedInstanceState == null) {
            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    checkInitialNavigation()
                }
            }
        }
        observer()
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

        return when (val result = DeepLinkRouter.parseDeepLink(uri)) {
            is DeepLinkRouter.DeepLinkResult.ResetPassword -> {
                val fragment = ResetPasswordFragment.createInstance(result.token)
                navigateToRoot(fragment)
                true
            }
            is DeepLinkRouter.DeepLinkResult.Unknown -> false
        }
    }

    private suspend fun checkInitialNavigation() {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val accessToken = appPreferencesRepository.getAccessToken()

        if (currentUser != null || !accessToken.isNullOrEmpty()) {
            navigateToDeeplink(ADOPTION_DEEPLINK)
            finish()
            return
        }

        val onboardingCompleted = appPreferencesRepository.getOnboardingCompleted()

        if (onboardingCompleted) {
            navigateToRoot(HomeFragment.createInstance("id"))
        } else {
            navigateToRoot(OnboardingPage1Fragment.createInstance())
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
                    navigateToRoot(HomeFragment.createInstance("id"))
                }

                is ShareStatus.GoToAdoption -> {
                    navigateToDeeplink(deeplink = ADOPTION_DEEPLINK)
                    finish()
                }
            }
        }
    }
}
