package com.refactoringlife.core.common.activities

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

open class BaseActivity(private val containerId: Int) : FragmentActivity() {

    fun navigateToRoot(fragment: Fragment) {
        this.supportFragmentManager.popBackStack(
            null,
            androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
        this.supportFragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .commit()
    }

    fun navigateTo(fragment: Fragment, tag: String? = null) {
        this.supportFragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .addToBackStack(tag ?: fragment.javaClass.simpleName)
            .commit()
    }

    fun addFragment(fragment: Fragment, tag: String? = null) {
        this.supportFragmentManager.beginTransaction()
            .add(containerId, fragment)
            .addToBackStack(tag ?: fragment.javaClass.simpleName)
            .commit()
    }

    fun onBack() {
        val fm = this.supportFragmentManager
        if (fm.backStackEntryCount > 0) fm.popBackStack()
        else this.finishAfterTransition()
    }
}
