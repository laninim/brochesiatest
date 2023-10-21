package com.laninim.brochesiatest.data

import com.laninim.brochesiatest.data.dto.Drink
import com.laninim.brochesiatest.data.dto.DrinkDto
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkApi {

    @GET("api/json/v1/1/search.php?")
    suspend fun getDrinkByName(@Query("s") drink: String) : DrinkDto

    //category can be Ordinary_Drink or Cocktail.
    @GET("api/json/v1/1/filter.php?")
    suspend fun getDrinkByCategory(@Query("c") categoryDrink : String) : DrinkDto

}