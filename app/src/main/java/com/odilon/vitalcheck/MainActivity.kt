package com.odilon.vitalcheck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.odilon.vitalcheck.ui.theme.VitalCheckTheme
import com.odilon.vitalcheck.ui.VitalCheckApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            setContent {
                VitalCheckTheme {
                    VitalCheckApp()
                }
            }
        }
    }
}

