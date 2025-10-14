package com.refactoringlife.core.common.activities

import android.net.Uri
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentActivity
import com.refactoringlife.core.common.navigation.NavigationManager

abstract class BaseFragmentActivity : FragmentActivity() {

    protected lateinit var navigationManager: NavigationManager

    abstract fun getLayoutResId(): Int
    abstract fun getContainerId(): Int
    abstract fun handleDeepLink(data: Uri?, defaultFragment: String?)
    abstract fun getDefaultFragment(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        navigationManager = NavigationManager(this, getContainerId())

        handleDeepLink(intent.data, intent.getStringExtra("default_fragment"))
        setupBackPressedHandler()
    }

    private fun setupBackPressedHandler() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (navigationManager.canGoBack()) {
                    navigationManager.navigateBack()
                } else {
                    finishAffinity()
                }
            }
        })
    }
}