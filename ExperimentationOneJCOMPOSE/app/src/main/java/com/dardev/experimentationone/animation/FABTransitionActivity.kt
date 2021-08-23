package com.dardev.experimentationone.animation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.dardev.experimentationone.BottomNavigationBar
import com.dardev.experimentationone.Navigation
import com.dardev.experimentationone.model.BottomNavItem

class FABTransitionActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent { 
            
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun DiveToContent(){

    var showPopup by remember { mutableStateOf(false) }
    val navController= rememberNavController()


    
    
    Scaffold(
        topBar ={
            TopAppBar(
                title = {
                    Text(
                        text = "Ma Page",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(
                                onClick = { showPopup = true }
                            )
                      
                    )
                },
                elevation = 0.dp
            )
        },
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name="Main",
                        route = "main",
                        icon=Icons.Default.Home

                    ),
                    BottomNavItem(
                        name="Tchat",
                        route = "tchat",
                        icon=Icons.Default.Email,
                        badgeCount = 12
                    ),
                    BottomNavItem(
                        name="Animation",
                        route = "anime",
                        icon=Icons.Default.Call,
                        badgeCount=250
                    )
                ),
                navController = navController,
                onItemClick ={
                    navController.navigate(it.route)
                } )
        }
        /*floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(asset = Icons.Default.Add)
            }
        },

        bodyContent={
            Column {

            }
        }*/
    ){
        Navigation(navController = navController)
    }



    var onPopupDismissed = {showPopup=false}

    if (showPopup == true){

        AlertDialog(
            onDismissRequest = onPopupDismissed,
            text = {
                Text(text = "Bien joué ! Tu as cliqué sur le bouton ahahah")
            },
            confirmButton = {
                Button(onClick = onPopupDismissed) {
                    Text(text = "Oki Doki")
                }
            },
            modifier = Modifier.background(Color.Cyan)
        )
    }




}

/*
@Composable
fun AlertAuDialog(showPopup:Boolean?=false){

    var onPopupDismissed = {showPopup=false}

    if (showPopup == true){

        AlertDialog(
            onDismissRequest = onPopupDismissed,
            text = {
                Text(text = "Bien joué ! Tu as cliqué sur le bouton ahahah")
            },
            confirmButton = {
                Button(onClick = onPopupDismissed) {
                    Text(text = "Oki Doki")
                }
            },
            modifier = Modifier.background(Color.Cyan)
        )
    }
}*/
