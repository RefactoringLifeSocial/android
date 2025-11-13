package com.refactoringlife.auth.core.share

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel : ViewModel() {

    private val _status: MutableLiveData<ShareStatus> = MutableLiveData()
    val status: LiveData<ShareStatus> = _status

    fun goToBack() {
        _status.value = ShareStatus.GoToBack
    }

    fun navigateTo(fragment: Fragment) {
        _status.value = ShareStatus.NavigateTo(fragment)
    }

    fun navigateToRoot() {
        _status.value = ShareStatus.NavigateToRoot
    }
    fun navigateToRoot(fragment: Fragment) {
        _status.value = ShareStatus.NavigateToRootFragment(fragment)
    }
    fun goToAdoption(){
        _status.value = ShareStatus.GoToAdoption
    }
}
