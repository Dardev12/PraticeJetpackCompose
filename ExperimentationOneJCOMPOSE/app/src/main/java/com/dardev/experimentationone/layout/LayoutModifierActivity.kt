package com.dardev.experimentationone.layout

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import com.dardev.experimentationone.data.colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LayoutModifierActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun PaddingIdentical(){

    Surface(color = colors[0]){

        Text(
            text = "Ce Text à un padding égale de tout les côtés",
            modifier = Modifier.padding(16.dp),
            style = TextStyle(fontSize = 20.sp,fontFamily = FontFamily.Cursive)
        )
    }

}

@Composable
fun CustomisePadding(){

    Surface(color = colors[1]) {
        Text(
            text = "On padding de  partout mon chère ami codeur " +
                    "Vient donc codé avec nous!!!",
            modifier = Modifier.padding(start = 32.dp,end=4.dp,top=10.dp,bottom = 0.dp),
            style = TextStyle(fontSize = 20.sp,fontFamily = FontFamily.Cursive)
        )
    }

}
@Composable
fun HorsSet(){

    Surface(color=colors[2],modifier = Modifier.offset(x=8.dp,y=8.dp)) {
        Text(
            text = "This is an example of ..."+
            "NAN nan on vas arrêter d'être billingue !!"+
            "Un peu de sérieux en tant que programmeur. :)",
            style= TextStyle(fontSize = 20.sp,fontFamily = FontFamily.Monospace)
        )
    }
}

@Composable
fun AspectRatiocompo(){

    Surface(
        color = colors[3],modifier = Modifier
            .aspectRatio(16/9f)
            .padding(top=16.dp)
    ) {

        Text(
            text="Ce texte est fixé dans un layout qui a pour ratio  16/9",
            style= TextStyle(fontSize = 20.sp,fontFamily = FontFamily.Monospace),
        modifier=Modifier.padding(16.dp)
        )

    }
}

@Preview("Example with same padding applied to a composable")
@Composable
fun SamePaddingComponentPreview() {
    Column {
        PaddingIdentical()
    }
}

@Preview("Example with custom padding in each direction applied to a composable")
@Composable
fun CustomPaddingComponentPreview() {
    Column {
        CustomisePadding()
    }
}

@Preview("Example using offsets to position the composable")
@Composable
fun OffsetComponentPreview() {
    Column {
        HorsSet()
    }
}

@Preview("Example showing how a fixed aspect ration is applied a composable")
@Composable
fun AspectRatioComponentPreview() {
    Column {
        AspectRatiocompo()
    }
}