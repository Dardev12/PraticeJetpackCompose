package com.dardev.experimentationone.text

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dardev.experimentationone.ui.theme.ExperimentationOneTheme

class TextActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ExperimentationOneTheme {
                // A surface container using the 'background' color from the theme
                Column (
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    content = {
                        simpleText("Mes Expérimentation Jetpack Compose !!")
                    }
                )
            }
        }
    }
}

@Composable
fun simpleText(tonTexte:String){
    Text(text = tonTexte)
}



@Preview
@Composable
fun PreviewSText(){
    simpleText("Mes Expérimentation Jetpack Compose !!")
}