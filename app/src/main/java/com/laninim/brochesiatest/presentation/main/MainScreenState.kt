package com.laninim.brochesiatest.presentation.main

import com.laninim.brochesiatest.model.repositories.DrinkModel

enum class SCREENSTATE {
    LOADING, ERROR, LOADED
}
data class MainScreenState(
    val drinkList : List<DrinkModel> = emptyList(),
    val selectCategory : String = "Cocktail",
    val screenState : SCREENSTATE = SCREENSTATE.LOADING
)
