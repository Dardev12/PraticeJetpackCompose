package com.dardev.mealzapp.models.response

import com.google.gson.annotations.SerializedName

//https://www.themealdb.com/api/json/v1/1/categories.php

data class MealsCategoriesResponse(
    val categories:List<MealResponse>
)

data class MealResponse(
     @SerializedName("idCategory") val id:String,
     @SerializedName("strCategory") val  name:String,
     @SerializedName("strCategoryDescription") val  description:String,
     @SerializedName("strCategoryThumb") val  imageUrl:String
)



//Besoin de transformer le JSON en GSON
//GSON deserialization:
//JSON -> data classes