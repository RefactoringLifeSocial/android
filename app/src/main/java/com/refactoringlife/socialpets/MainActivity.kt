package com.refactoringlife.socialpets

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openDeepLink("https://refactoringlife.com/auth")
    }
}

fun Activity.openDeepLink(deeplinkUrl: String) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deeplinkUrl))

        startActivity(intent)

    } catch (e: ActivityNotFoundException) {
        Toast.makeText(this, "No se pudo abrir el enlace", Toast.LENGTH_SHORT).show()
     }
}