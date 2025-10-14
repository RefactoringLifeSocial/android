package com.refactoringlife.socialpets

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.refactoringlife.auth.features.AuthActivity
import com.refactoringlife.core.common.utils.DeepLinks
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleDeepLink(intent)
    }

    private fun handleDeepLink(intent: Intent) {
        val data: Uri? = intent.data
        when {
            data?.scheme == DeepLinks.SCHEME && data.host == DeepLinks.HOST -> {
                val authIntent = Intent(this, AuthActivity::class.java)
                authIntent.data = data
                startActivity(authIntent)
            }
            else -> {
                val authIntent = Intent(this, AuthActivity::class.java)
                authIntent.putExtra("default_fragment", DeepLinks.Screen.LOGIN)
                startActivity(authIntent)
            }
        }
        finish()
    }
}