package com.refactoringlife.auth.features

import android.os.Bundle
import androidx.activity.viewModels
import com.refactoringlife.auth.R
import com.refactoringlife.auth.core.share.ShareStatus
import com.refactoringlife.auth.core.share.ShareViewModel
import com.refactoringlife.auth.features.home.presentation.fragment.HomeFragment
import com.refactoringlife.auth.features.onboarding.presentation.fragment.OnboardingPage1Fragment
import com.refactoringlife.core.common.activities.BaseActivity
import com.refactoringlife.core.common.utils.ADOPTION_DEEPLINK
import com.refactoringlife.core.common.utils.navigateToDeeplink

class AuthActivity : BaseActivity(R.id.fragment_container) {

    val shareViewModel by viewModels <ShareViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        navigateToRoot(OnboardingPage1Fragment.createInstance())
        observer()
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
