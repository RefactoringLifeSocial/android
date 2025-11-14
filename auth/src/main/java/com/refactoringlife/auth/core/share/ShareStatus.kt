package com.refactoringlife.auth.core.share

import androidx.fragment.app.Fragment

sealed class ShareStatus {
    data class NavigateTo(val fragment: Fragment) : ShareStatus()
    data object GoToBack : ShareStatus()
    data object NavigateToRoot : ShareStatus()
    data object GoToAdoption: ShareStatus()
}
