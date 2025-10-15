package com.refactoringlife.socialpets

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.refactoringlife.core.common.utils.AUTH_DEEPLINK
import com.refactoringlife.core.common.utils.navigateToDeeplink
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigateToDeeplink(AUTH_DEEPLINK)
        finish()
    }
}
