package com.dardev.notecomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.defaultDecayAnimationSpec
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dardev.notecomposeapp.feature.note.presenter.add_edit_note.AjoutEditYanoteScreen
import com.dardev.notecomposeapp.feature.note.presenter.notes.YanoteView
import com.dardev.notecomposeapp.feature.note.presenter.util.Screen
import com.dardev.notecomposeapp.ui.theme.NoteComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteComposeAppTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ){
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.YanoteScreen.route
                    ){
                        composable(route = Screen.YanoteScreen.route){
                            YanoteView(navController = navController)
                        }
                        composable(
                            route = Screen.AjoutEditYanoteScreen.route +
                                    "?yanoteId={yanoteId}&yanoteColor={yanoteColor}",
                            arguments = listOf(
                                navArgument(
                                    name = "yanoteId"
                                ){
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(
                                    name = "yanoteColor"
                                ){
                                    type = NavType.IntType
                                    defaultValue = 1
                                },
                            )
                        ){
                            val color = it.arguments?.getInt("yanoteColor") ?: -1
                            AjoutEditYanoteScreen(
                                navController = navController,
                                yanoteColor = color
                            )
                        }
                    }
                }
            }
        }
    }
}

