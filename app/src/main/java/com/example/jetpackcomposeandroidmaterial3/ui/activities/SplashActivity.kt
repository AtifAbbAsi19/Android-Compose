package com.example.jetpackcomposeandroidmaterial3.ui.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.example.jetpackcomposeandroidmaterial3.ui.activities.ui.theme.JetPackComposeAndroidMaterial3Theme
import kotlinx.coroutines.delay


@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
            val splashScreen = installSplashScreen()
            splashScreen.setKeepOnScreenCondition { true }
        }

        super.onCreate(savedInstanceState)


        lifecycleScope.launchWhenCreated {
            delay(3000)
            navigateToHomeScreen(this@SplashActivity)
            finish()
        }


  /*      setContent {
            JetPackComposeAndroidMaterial3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }*/
    }
}


inline fun navigateToHomeScreen(context : Context){
    val intent = Intent(context, MainActivity::class.java)
    context.startActivity(intent)
}
