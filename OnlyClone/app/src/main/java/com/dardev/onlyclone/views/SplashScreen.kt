package com.dardev.onlyclone.views

import android.annotation.SuppressLint
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController
import com.dardev.onlyclone.R
import com.dardev.onlyclone.navigate.RouteNav
import com.dardev.onlyclone.ui.theme.MainColorLight
import com.dardev.onlyclone.ui.theme.MainColorNight
import kotlinx.coroutines.delay

class SplashScreen {

    @Composable
    fun AnimeSplashScreen(navController: NavController?=null){
        val scale= remember {
          Animatable(0f)
        }

        LaunchedEffect(key1 = true){
            scale.animateTo(
                targetValue = 0.3f,
                animationSpec = tween(
                    durationMillis = 300,
                    easing =
                        FastOutLinearInEasing

                )
            )
            delay(3000L)
            navController?.navigate(route = RouteNav.main_route)
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MainColorLight)
                ,
            contentAlignment = Alignment.Center
        ){
            Image(painter = painterResource(id = R.drawable.ic_red_lips),
                contentDescription = "Only Fan Clone Logo",
                modifier = Modifier.scale(scale.value)
                )
            Text(
                text = "Only Fan Clone",
                modifier = Modifier.align(Alignment.BottomCenter),
                fontSize = 50.sp,
                fontFamily = FontFamily.Cursive
            )
        }
    }

    @Preview
    @Composable
    fun AnimeScreenPreview(){
        AnimeSplashScreen()
    }

}