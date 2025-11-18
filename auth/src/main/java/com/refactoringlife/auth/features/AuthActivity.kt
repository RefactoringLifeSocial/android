package com.refactoringlife.auth.features

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
import com.refactoringlife.core.common.activities.BaseActivity
import com.refactoringlife.core.common.utils.ADOPTION_DEEPLINK
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

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                checkInitialNavigation()
            }
        }
        observer()
    }

    private suspend fun checkInitialNavigation() {
        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) {
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

    fun observer(){
        shareViewModel.status.observe(this){status->
            when(status){
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
