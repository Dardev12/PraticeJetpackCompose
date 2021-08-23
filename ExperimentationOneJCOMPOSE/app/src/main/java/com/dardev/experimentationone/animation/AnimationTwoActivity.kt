package com.dardev.experimentationone.animation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.ui.tooling.preview.Preview

class AnimationTwoActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AnimateColorComponent()
        }
    }
}

@Composable
fun AnimateColorComponent(){

    val currentColor by remember { mutableStateOf(Color.Red) }

    val transition:Transition<Color> = updateTransition(targetState = currentColor)


    val colors by transition.animateColor(
        transitionSpec={
            TweenSpec<Color>(durationMillis = 20000)
        }
    ){ state ->

            when(state){
                Color.Red-> Color.Green
                Color.Green->Color.Blue
                Color.Blue->Color.Red
                else->Color.Red
            }


    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colors)
    ) {
            RotatingTriangleComponent()
    }
}



@Preview
@Composable
fun PreviewAnimateColor(){
    AnimateColorComponent()
}