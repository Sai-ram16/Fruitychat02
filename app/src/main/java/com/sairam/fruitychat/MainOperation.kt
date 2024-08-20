package com.sairam.fruitychat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sairam.fruitychat.app.FruitsApp

class MainOperation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           FruitsApp()
        }
    }
}



