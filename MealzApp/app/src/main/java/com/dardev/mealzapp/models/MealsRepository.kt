package com.dardev.mealzapp.models

import com.dardev.mealzapp.models.api.MealsWebService
import com.dardev.mealzapp.models.response.MealResponse
import com.dardev.mealzapp.models.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService= MealsWebService()){
    //La class qui recoit les données du serveur
    private var cachedMeals = listOf<MealResponse>()

    suspend fun getMeals(): MealsCategoriesResponse{
        //return webService.getMeals().execute().body() //Mauvaise Pratique
        val response =webService.getMeals()
        cachedMeals=response.categories
        return response
    }

    fun getMeal(id:String):MealResponse?{
        return cachedMeals.firstOrNull{
            it.id==id
        }
    }

    companion object{
        @Volatile
        private var instance:MealsRepository? = null

        fun getInstance() = instance?: synchronized(this){
            instance?:MealsRepository().also { instance = it  }
        }

    }

}