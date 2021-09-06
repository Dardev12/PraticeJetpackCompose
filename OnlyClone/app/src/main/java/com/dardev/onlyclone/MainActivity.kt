package com.dardev.onlyclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.dardev.onlyclone.navigate.NavOnlyFan
import com.dardev.onlyclone.ui.theme.OnlyCloneTheme
import com.dardev.onlyclone.views.SplashScreen

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashScreen:SplashScreen= SplashScreen()
        setContent {
            OnlyCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.White) {

                    val navController= rememberNavController()
                    NavOnlyFan(navController = navController)

                }



            }
        }
    }
}

