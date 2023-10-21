package com.laninim.brochesiatest.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laninim.brochesiatest.data.repositories.DrinkRepositoryImpl
import com.laninim.brochesiatest.model.repositories.DrinkModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository : DrinkRepositoryImpl
) : ViewModel() {

    private val _mainScreenState = MutableStateFlow(MainScreenState())
    val mainScreenState get() = _mainScreenState.asStateFlow()


     init {
         _mainScreenState.update {
             it.copy(
                 dataIsLoaded = false
             )
         }
         loadDrinkByCategory()
     }

    private fun loadDrinkByCategory() {
        viewModelScope.launch {
            Log.d("Network call", "start call for drink")
            val drinkList = repository.getDrinkByCategory("Cocktail")
            if(drinkList.drinks.isNotEmpty()){
                delay(1000)
                _mainScreenState.update {
                    it.copy(

                        drinkList = drinkList.drinks.map {drink ->
                            drink.mapToModel()
                        },

                        dataIsLoaded = true
                    )
                }
            }
            Log.d("Results Network call", "get ${drinkList.drinks.size} results Drink: $drinkList" )
            Log.d("Map result", "Result ${_mainScreenState.value.drinkList}")
        }
    }
}