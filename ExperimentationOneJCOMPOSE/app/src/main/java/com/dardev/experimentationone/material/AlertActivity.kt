package com.dardev.experimentationone.material

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class AlertActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            
        setContent { 
            Column{
                ClicText()
            }
        }
    }
}

@Composable
fun ClicText(){
    var showPopup by remember { mutableStateOf(false)}

    Column(Modifier.clickable(onClick = { showPopup = true }), content = {

        Card(
            shape = RoundedCornerShape(10.dp),modifier = Modifier.padding(16.dp),
            backgroundColor = Color.Yellow
        ) {

            Text(
                text = "Clic pour voir le dialogue",modifier = Modifier.padding(16.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Cursive
                )
            )

        }


    })



    val onPopupDismissed = {showPopup=false}

    if (showPopup){

        AlertDialog(
            onDismissRequest = onPopupDismissed,
            text = {
                Text(text = "Bien joué ! Tu as cliqué sur le bouton ahahah")
            },
            confirmButton = {
                Button(onClick = onPopupDismissed) {
                    Text(text = "Oki Doki")
                }        
            }
        ) 
    }

}

@Preview(showBackground = true)
@Composable
fun MonClicPreview(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            ClicText()
        }
    )
}