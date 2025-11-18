package com.refactoringlife.auth.features

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
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
import javax.inject.Inject

@AndroidEntryPoint
class AuthActivity : BaseActivity(R.id.fragment_container) {

    val shareViewModel by viewModels<ShareViewModel>()

    @Inject
    lateinit var appPreferencesRepository: AppPreferencesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        lifecycleScope.launchWhenStarted {
            // Verificar que la inyección se haya completado
            if (::appPreferencesRepository.isInitialized) {
                checkInitialNavigation()
            }
        }

        observer()
    }

    private suspend fun checkInitialNavigation() {
        // 1. Verificar si el usuario está autenticado
        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) {
            // Usuario autenticado → ir directo a la app
            navigateToDeeplink(ADOPTION_DEEPLINK)
            finish()
            return
        }

        // 2. Verificar si el onboarding ya se completó
        val onboardingCompleted = appPreferencesRepository.getOnboardingCompleted()

        if (onboardingCompleted) {
            // Onboarding ya visto → ir a Home (login/register)
            navigateToRoot(HomeFragment.createInstance("id"))
        } else {
            // Primera vez → mostrar onboarding
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