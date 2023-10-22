package com.laninim.brochesiatest.model.repositories

import com.laninim.brochesiatest.data.dto.Drink
import java.io.Serializable

data class DrinkModel (
    val idDrink : String,
    val category : String,
    val drinkName : String,
    val imageUrl : String,

) : Serializable
