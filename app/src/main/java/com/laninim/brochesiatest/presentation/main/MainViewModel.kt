package com.laninim.brochesiatest.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laninim.brochesiatest.data.repositories.DrinkRepositoryImpl
import com.laninim.brochesiatest.data.util.ApiResponse
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
                 screenState = SCREENSTATE.LOADING
             )
         }
         loadDrinkByCategory()
     }

    private fun loadDrinkByCategory() {
        viewModelScope.launch {

            val drinkList = repository.getDrinkByCategory("Cocktail")
            when(drinkList){
                is ApiResponse.Success -> {
                    if(drinkList.response.drinks.isNotEmpty()){
                        delay(1000)
                        _mainScreenState.update {
                            it.copy(

                                drinkList = drinkList.response.drinks.map {drink ->
                                    drink.mapToModel()
                                },

                                screenState = SCREENSTATE.LOADED
                            )
                        }
                    }
                }
                is ApiResponse.Failure -> {
                    Log.d("Errore di rete", "Errore di rete")
                    _mainScreenState.update {
                        it.copy(
                            screenState = SCREENSTATE.ERROR
                        )
                    }
                }

            }

        }
    }
}