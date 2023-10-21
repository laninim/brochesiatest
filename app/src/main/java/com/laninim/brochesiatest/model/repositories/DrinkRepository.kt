package com.laninim.brochesiatest.model.repositories

import com.laninim.brochesiatest.data.dto.Drink
import com.laninim.brochesiatest.data.dto.DrinkDto

interface DrinkRepository {

    suspend fun getDrinkByName(name : String) : DrinkDto

    suspend fun getDrinkByCategory(category : String) : DrinkDto
}