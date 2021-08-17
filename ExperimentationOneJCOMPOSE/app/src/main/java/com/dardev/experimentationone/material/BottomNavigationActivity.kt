package com.dardev.experimentationone.material

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class BottomNavigationActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            
            Column() {



            }
        }
    }
}


@Preview
@Composable
fun BasNavShowLabelComponentPrev(){

}


@Preview
@Composable
fun BasNavOnlySelectedLabelComponentPrev(){

}