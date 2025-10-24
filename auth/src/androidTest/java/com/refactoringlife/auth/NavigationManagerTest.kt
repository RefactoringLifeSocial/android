package com.refactoringlife.auth

import com.refactoringlife.core.common.navigation.NavigationManager
import androidx.fragment.app.Fragment
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.refactoringlife.auth.features.AuthActivity
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@MediumTest
@RunWith(AndroidJUnit4::class)
class NavigationManagerTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(AuthActivity::class.java)

    private val containerId = R.id.fragment_container
    private lateinit var navigationManager: NavigationManager

    @Before
    fun setup() {
        activityRule.scenario.onActivity { activity ->
            // Crear dinámicamente el contenedor para fragmentos
            val container = android.widget.FrameLayout(activity)
            container.id = containerId
            activity.setContentView(container)

            navigationManager = NavigationManager(activity, containerId)
        }
    }

    @Test
    fun navigateToAndAddToBackStack() {
        activityRule.scenario.onActivity { activity ->
            val firstFragment = FakeFragment()
            val secondFragment = FakeFragment()

            navigationManager.navigateTo(firstFragment)
            activity.supportFragmentManager.executePendingTransactions()

            var currentFragment = activity.supportFragmentManager.findFragmentById(containerId)
            assertTrue(currentFragment === firstFragment)

            navigationManager.navigateTo(secondFragment, "SecondTag")
            activity.supportFragmentManager.executePendingTransactions()

            currentFragment = activity.supportFragmentManager.findFragmentById(containerId)
            assertTrue(currentFragment === secondFragment)

            val fm = activity.supportFragmentManager
            assertEquals(2, fm.backStackEntryCount)
            assertEquals("SecondTag", fm.getBackStackEntryAt(1).name)
        }
    }

    class FakeFragment : Fragment()
}