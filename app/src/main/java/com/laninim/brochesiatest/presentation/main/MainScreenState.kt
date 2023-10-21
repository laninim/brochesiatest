package com.laninim.brochesiatest.presentation.main

import com.laninim.brochesiatest.model.repositories.DrinkModel

data class MainScreenState(
    val drinkList : List<DrinkModel> = emptyList(),
    val selectCategory : String = "Cocktail",
    val dataIsLoaded : Boolean = false
)
