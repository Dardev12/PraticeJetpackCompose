package com.dardev.experimentationone.text

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CustomTextActivity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}



@Composable
fun CustomStyledText(displayText:String,style:TextStyle? = null,maxLines: Int? = null){
    Text(
        text = displayText,
        modifier = Modifier.padding(16.dp),
        style = style?: TextStyle.Default,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines ?: Int.MAX_VALUE
    )

    Divider(color = Color.Gray, thickness = 10.dp)
}

@Preview
@Composable
fun ComponentPreviewSText(){
    CustomStyledText(
        "This is my world !!",
        style= TextStyle(
            color=Color.Red,
            fontWeight = FontWeight.W900,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Cursive,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        ),
        2
    )
}