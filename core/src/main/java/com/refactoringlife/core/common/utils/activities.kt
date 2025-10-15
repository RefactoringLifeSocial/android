package com.refactoringlife.core.common.utils

import android.app.Activity
import android.content.Intent
import android.net.Uri

fun Activity.navigateToDeeplink(deeplink: String){
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse(deeplink)
        `package` = packageName
    }
    startActivity(intent)
}