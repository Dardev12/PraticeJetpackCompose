package com.dardev.experimentationone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardImage(
    painter: Painter,
    contentDescription: String,
    title:String,
    modifier: Modifier=Modifier
){

    Card(
        modifier = modifier.fillMaxWidth(),
        shape= RoundedCornerShape(15.dp),
        elevation = 5.dp,

    ){
        Box(modifier=Modifier.height(200.dp)){
            Image(
                painter=painter,
                contentDescription=contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Red
                        ),
                        startY = 300f
                    )
                )
            )
            Box(
                modifier= Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ){
                Text(
                    text = title,
                    style= TextStyle(color= Color.Black,fontSize = 16.sp),
                )
            }
        }
    }

}