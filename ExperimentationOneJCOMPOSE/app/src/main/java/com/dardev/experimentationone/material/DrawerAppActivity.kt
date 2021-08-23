package com.dardev.experimentationone.material

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class DrawerAppActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}

@Preview
@Composable
fun DrawerAppComponentPreview() {
    DrawerAppComponent()
}


@Composable
fun DrawerAppComponent(){
    val draweState = rememberDrawerState(DrawerValue.Closed )

    val currentScreen = remember{ mutableStateOf(DrawerAppScreen.Screen1)}

    val coroutine = rememberCoroutineScope()

    ModalDrawer(
        drawerState=draweState,
        gesturesEnabled=draweState.isOpen,
        drawerContent = {
            DrawerContentComponent(
                currentScreen = currentScreen,
                closeDrawer = {coroutine.launch { draweState.close() }}
                )
        },
        content = {
            BodyContentCompo(
                currentScreen = currentScreen.value,
                openDrawer = {
                    coroutine.launch { draweState.open() }
                }
            )
        }
    )

}


@Composable
fun DrawerContentComponent(
    currentScreen: MutableState<DrawerAppScreen>,
    closeDrawer:()->Unit
){

    Column(modifier = Modifier.fillMaxSize()) {

        for(index in DrawerAppScreen.values().indices){

            val screen = getScreenBasedOnIndex(index)
            Column(Modifier.clickable(onClick = {
                currentScreen.value=screen

                closeDrawer()
            }),content = {
                Surface(
                    modifier = Modifier.fillMaxWidth(),

                    color = if (currentScreen.value == screen) {
                        MaterialTheme.colors.secondary
                    } else {
                        MaterialTheme.colors.surface
                    }
                ) {

                    Text(text = screen.name, modifier = Modifier.padding(16.dp))
                }
            })

        }

    }

}

fun getScreenBasedOnIndex(index:Int)= when (index){
    0->DrawerAppScreen.Screen1
    1->DrawerAppScreen.Screen2
    2->DrawerAppScreen.Screen3
    else->DrawerAppScreen.Screen1
}

@Composable
fun BodyContentCompo(
    currentScreen:DrawerAppScreen,
    openDrawer:()->Unit
){
    when(currentScreen){
        DrawerAppScreen.Screen1-> Screen1Component (
            openDrawer
                )
        DrawerAppScreen.Screen2-> Screen2Component (
            openDrawer
                )
        DrawerAppScreen.Screen3-> Screen3Component (
            openDrawer
                )
    }


}
@Composable
fun Screen1Component(openDrawer: () -> Unit){

    Column(modifier = Modifier.fillMaxSize()) {

        TopAppBar(
            title = { Text("Screen Kotlin #1")},
            navigationIcon = {
                IconButton(onClick = openDrawer) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Ajout")
                }
            }
        )
        
        Surface(color = Color.Yellow,modifier = Modifier.weight(1f)) {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Text(text = "Screen 1")
                }
            )
            
        }
    }
}

@Composable
fun Screen2Component(openDrawer: () -> Unit){
    Column(modifier = Modifier.fillMaxSize()) {

        TopAppBar(
            title = { Text("Screen Android #2")},
            navigationIcon = {
                IconButton(onClick = openDrawer) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                }
            }
        )

        Surface(color = Color.Cyan,modifier = Modifier.weight(1f)) {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Text(text = "Screen 2")
                }
            )

        }
    }
}

@Composable
fun Screen3Component(openDrawer: () -> Unit){
    Column(modifier = Modifier.fillMaxSize()) {

        TopAppBar(
            title = { Text("Screen JCompose #3")},
            navigationIcon = {
                IconButton(onClick = openDrawer) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                }
            }
        )

        Surface(color = Color.Blue,modifier = Modifier.weight(1f)) {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Text(text = "Screen 3")
                }
            )

        }
    }
}

enum class DrawerAppScreen{
    Screen1,
    Screen2,
    Screen3
}