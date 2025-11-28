package com.refactoringlife.auth.features

import android.content.Intent
import android.net.Uri
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

        // Primero verificamos si venimos de un deeplink de reset password
        val handledDeepLink = handleDeepLinkIfNeeded(intent)

        // Solo ejecutamos la navegación normal si NO venimos de un deeplink de reset
        if (!handledDeepLink) {
            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    checkInitialNavigation()
                }
            }
        }
        observer()
    }

    // AGREGAR ESTE MÉTODO (importante para singleTop)
    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent) // Actualizar el intent actual
        handleDeepLinkIfNeeded(intent)
    }

    // Manejar deeplinks cuando la Activity ya está abierta
    override fun onResume() {
        super.onResume()
        // Verificamos si hay un nuevo intent con deeplink
        handleDeepLinkIfNeeded(intent)
    }

    // Función que detecta y maneja el deeplink de reset password
    private fun handleDeepLinkIfNeeded(intent: Intent?): Boolean {
        val data: Uri = intent?.data ?: return false

        // Verificamos que sea el path de reset password
        val path = data.path
        val token = data.getQueryParameter("token")

        // CAMBIO: Acepta tanto huella:// como https:// para reset-password
        val isResetPasswordPath = path == "/auth/reset-password" && !token.isNullOrEmpty()
        val isCustomScheme = data.scheme == "huella"
        val isHttpsScheme = data.scheme == "https"

        return if (isResetPasswordPath && (isCustomScheme || isHttpsScheme)) {
            // Navegamos directamente a la pantalla de "Nueva contraseña" con el token
            val fragment = ResetPasswordFragment.createInstance(token)
            navigateToRoot(fragment)
            true
        } else {
            false
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
