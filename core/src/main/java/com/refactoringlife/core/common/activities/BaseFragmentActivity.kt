package com.refactoringlife.core.common.activities

import android.net.Uri
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentActivity
import com.refactoringlife.core.common.navigation.NavigationManager

abstract class BaseFragmentActivity : FragmentActivity() {

    protected lateinit var navigationManager: NavigationManager

    fun setupBackPressedHandler() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                    navigationManager.onBack()
            }
        })
    }
}