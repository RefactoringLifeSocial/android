package com.refactoringlife.core.common.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class NavigationManager(
    private val activity: FragmentActivity,
    private val containerId: Int
) {
    fun navigateToInitial(fragment: Fragment) {
        activity.supportFragmentManager.popBackStack(
            null,
            androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
        activity.supportFragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .commit()
    }

    fun navigateTo(fragment: Fragment, tag: String? = null) {
        activity.supportFragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .addToBackStack(tag ?: fragment.javaClass.simpleName)
            .commit()
    }

    fun navigateBack(): Boolean {
        return if (activity.supportFragmentManager.backStackEntryCount > 0) {
            activity.supportFragmentManager.popBackStack()
            true
        } else {
            false
        }
    }

    fun canGoBack(): Boolean {
        return activity.supportFragmentManager.backStackEntryCount > 0
    }
}