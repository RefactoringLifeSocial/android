package com.refactoringlife.adoption.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.refactoringlife.adoption.R

class AdoptionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adoption)
    }
}