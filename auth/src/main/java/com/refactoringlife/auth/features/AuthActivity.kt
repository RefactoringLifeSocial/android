package com.refactoringlife.auth.features

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.refactoringlife.auth.R
import com.refactoringlife.core.common.utils.DeepLinks

class AuthActivity : FragmentActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        setupNavigation()
        handleDeepLink()
    }

    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    private fun handleDeepLink() {
        val data: Uri? = intent.data
        val defaultFragment = intent.getStringExtra("default_fragment")

        when {
            data?.path?.startsWith("/${DeepLinks.Host.AUTH}${DeepLinks.Path.LOGIN}") == true -> {
                navController.navigate(R.id.loginFragment)
            }
            data?.path?.startsWith("/${DeepLinks.Host.AUTH}${DeepLinks.Path.REGISTER}") == true -> {
                navController.navigate(R.id.registerFragment)
            }
//            data?.path?.startsWith("/auth/login") == true -> {
//                navController.navigate(R.id.loginFragment)
//            }
//            data?.path?.startsWith("/auth/register") == true -> {
//                navController.navigate(R.id.registerFragment)
//            }
            // Pantalla por defecto
            defaultFragment == "login" -> {
                navController.navigate(R.id.registerFragment)
            }
        }
    }
}