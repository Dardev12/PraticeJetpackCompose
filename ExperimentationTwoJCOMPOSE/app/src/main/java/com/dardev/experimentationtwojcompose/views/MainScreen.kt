package com.dardev.experimentationtwojcompose.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dardev.experimentationtwojcompose.utils.Screen

@Composable
fun RootScreen(navController: NavController){
    var text by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        TextField(
            value = text,
            onValueChange = { text=it },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                navController.navigate(Screen.DetailScreen.withArgs(text))
                      },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text="Voir Detail Screen")
        }
    }
}


