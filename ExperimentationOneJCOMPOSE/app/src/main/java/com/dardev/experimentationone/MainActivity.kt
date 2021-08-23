package com.dardev.experimentationone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dardev.experimentationone.animation.AnimateColorComponent
import com.dardev.experimentationone.animation.DiveToContent
import com.dardev.experimentationone.animation.RotatingTriangleComponent
import com.dardev.experimentationone.animation.testPreviewAnimTwo
import com.dardev.experimentationone.layout.AspectRatiocompo
import com.dardev.experimentationone.layout.CustomisePadding
import com.dardev.experimentationone.layout.HorsSet
import com.dardev.experimentationone.layout.PaddingIdentical
import com.dardev.experimentationone.material.AlertActivity
import com.dardev.experimentationone.material.ClicText
import com.dardev.experimentationone.material.DrawerAppComponent
import com.dardev.experimentationone.text.CustomStyledText
import com.dardev.experimentationone.ui.theme.ExperimentationOneTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContent {
                //AnimateColorComponent()
                //testPreviewAnimTwo()
                Surface(color = Color.Blue,modifier = Modifier.fillMaxSize()) {
                    DiveToContent()
                }
            }
    }
}

@Composable
fun StockAllMonday(){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ClicText()
    }
    Spacer(modifier = Modifier.padding(10.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
    ) {
        PaddingIdentical()
        CustomisePadding()
        HorsSet()
        AspectRatiocompo()
        CustomStyledText(
            "The line height of this text has been " +
                    "increased hence you will be able to see more space between each " +
                    "line in this paragraph.",
            style = TextStyle(
                textAlign = TextAlign.Justify,
                lineHeight = 20.sp
            )
        )
        Spacer(modifier = Modifier.padding(10.dp))
        DrawerAppComponent()
    }
}

@Composable
fun StockAllTuesday(){
    DrawerAppComponent()
}

@Composable
fun StockWesneday(){
    RotatingTriangleComponent()
    AnimateColorComponent()

}


