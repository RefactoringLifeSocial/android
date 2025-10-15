package com.refactoringlife.core.common.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class NavigationManager(
    private val activity: FragmentActivity,
    private val containerId: Int
) {
    fun navigateToRoot(fragment: Fragment) {
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

    fun addFragment(fragment: Fragment, tag: String? = null) {
        activity.supportFragmentManager.beginTransaction()
            .add(containerId, fragment)
            .addToBackStack(tag ?: fragment.javaClass.simpleName)
            .commit()
    }

    fun onBack() {
        val fm = activity.supportFragmentManager
        if (fm.backStackEntryCount > 0) fm.popBackStack()
        else activity.finishAfterTransition()
    }
}