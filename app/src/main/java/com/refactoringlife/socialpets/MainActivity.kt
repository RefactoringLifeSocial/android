package com.refactoringlife.socialpets

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.refactoringlife.auth.features.AuthActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        startActivity( Intent(this, AuthActivity::class.java))
        finish()
    }
}
