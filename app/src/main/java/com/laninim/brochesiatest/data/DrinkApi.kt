package com.laninim.brochesiatest.data

import com.laninim.brochesiatest.data.dto.Drink
import retrofit2.http.GET

interface DrinkApi {

    @GET("/api/json/v1/1/search.php?s={drink}")
    fun getDrinkByName(drink: String) : List<Drink>

    //category can be Ordinary_Drink or Cocktail.
    @GET("/api/json/v1/1/filter.php?c={category}")
    fun getDrinkByCategory(categoryDrink : String) : List<Drink>

}