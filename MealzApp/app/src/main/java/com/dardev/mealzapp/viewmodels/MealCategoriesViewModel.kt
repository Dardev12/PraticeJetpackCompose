package com.dardev.mealzapp.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dardev.mealzapp.models.MealsRepository
import com.dardev.mealzapp.models.response.MealResponse
import com.dardev.mealzapp.models.response.MealsCategoriesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealCategoriesViewModel (private val repository: MealsRepository = MealsRepository.getInstance()): ViewModel() {

    //private val mealsJob = Job() viewModelScope simplifie notre tache
    init {
       // val scope= CoroutineScope(mealsJob + Dispatchers.IO)
        //Log.d("TAG_COROUTINES","On vas lancé une coroutine") //1
        viewModelScope.launch(Dispatchers.IO) {
            //Log.d("TAG_COROUTINES","On a lancé une coroutine #2") //3
            val meals = getMeals()
            //Log.d("TAG_COROUTINES","On a reçue les donnée asynchrone") //4
            mealsState.value=meals
        }
        //Log.d("TAG_COROUTINES","Autre tâches") // 2
    }

    val mealsState: MutableState<List<MealResponse>> = mutableStateOf(emptyList<MealResponse>())

    /*override fun onCleared() {
        super.onCleared()
        mealsJob.cancel()
    }*/

    suspend fun getMeals(): List<MealResponse>{
        return repository.getMeals().categories
    }
}