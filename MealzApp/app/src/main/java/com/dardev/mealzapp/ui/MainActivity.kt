package com.dardev.mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dardev.mealzapp.models.response.MealResponse
import com.dardev.mealzapp.navigation.MealAppNav
import com.dardev.mealzapp.ui.meals.views.MealsCategoriesScreen
import com.dardev.mealzapp.ui.theme.MealzAppTheme
import com.dardev.mealzapp.viewmodels.MealCategoriesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // val viewModel by viewModels<MealCategoriesViewModel>() //Instanciation
        setContent {
            MealzAppTheme {
                //MealsCategoriesScreen()
                MealAppNav()
            }
        }
    }
}





