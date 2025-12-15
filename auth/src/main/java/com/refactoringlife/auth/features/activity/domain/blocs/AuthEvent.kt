package com.refactoringlife.auth.features.activity.domain.blocs

import android.net.Uri

sealed class AuthEvent {
    object CheckInitialNavigation : AuthEvent()
    data class HandleDeepLink(val uri: Uri?) : AuthEvent()
    object ClearNavigation : AuthEvent()
}

