package com.dardev.mealzapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.dardev.mealzapp.ui.meals.views.MealDetailsView
import com.dardev.mealzapp.ui.meals.views.MealsCategoriesScreen
import com.dardev.mealzapp.viewmodels.MealDetailsViewModel


@Composable
fun MealAppNav(){
    val navController=rememberNavController()

    NavHost(navController, startDestination = "home_screen"){
        composable("home_screen") {
            MealsCategoriesScreen{navigationMealid ->
                navController.navigate("details_meal_screen/$navigationMealid")

            }
        }
        composable(
            route="details_meal_screen/{meal_category_id}",
            arguments = listOf(navArgument("meal_category_id"){
                type= NavType.StringType
                nullable=false
            })
        ){
            val viewModel:MealDetailsViewModel= viewModel()
            MealDetailsView(viewModel.mealState.value)
        }
    }
}