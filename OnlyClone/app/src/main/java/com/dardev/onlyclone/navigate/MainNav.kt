package com.dardev.onlyclone.navigate

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.dardev.onlyclone.views.HomeScreen
import com.dardev.onlyclone.views.ProfilScreen
import com.dardev.onlyclone.views.SplashScreen

object RouteNav{
    const val splash_route="splash"
    const val main_route="main"
    const val profil_route="profil"
    const val tchats_route="tchat"
    //
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun NavOnlyFan(
    modifier: Modifier=Modifier,
    navController:NavHostController=rememberNavController(),
    startDestination:String= RouteNav.splash_route
){
    val splashScreen = SplashScreen()
    val profilScreen = ProfilScreen(navController)
    val homeScreen = HomeScreen(navController)

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable(RouteNav.splash_route){
            splashScreen.AnimeSplashScreen(navController = navController)
        }
        composable(RouteNav.main_route){
            homeScreen.PatronHome()
        }
        composable(RouteNav.profil_route){
            profilScreen.PatronProfil()
        }
        composable(RouteNav.tchats_route){

        }
        //Soon...
    }
    
}