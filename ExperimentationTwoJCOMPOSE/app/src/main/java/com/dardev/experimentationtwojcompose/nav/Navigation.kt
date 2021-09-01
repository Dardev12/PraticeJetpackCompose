package com.dardev.experimentationtwojcompose.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.dardev.experimentationtwojcompose.utils.Screen
import com.dardev.experimentationtwojcompose.views.DetailsScreen
import com.dardev.experimentationtwojcompose.views.RootScreen

@Composable
fun Navigation(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            RootScreen(navController)
        }
        composable(
            route = Screen.DetailScreen.route+ "/{name}",//is going to crasdh if we dont niullable the route
            arguments = listOf(
                navArgument("name"){
                    type= NavType.StringType
                    defaultValue = "Darren"
                    nullable = true
                }
            )
        ){entry->
            DetailsScreen(name = entry.arguments?.getString("name"))
        }
    }
}