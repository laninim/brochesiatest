package com.laninim.brochesiatest.data.repositories

import com.laninim.brochesiatest.data.DrinkApi
import com.laninim.brochesiatest.data.dto.Drink
import com.laninim.brochesiatest.data.dto.DrinkDto
import com.laninim.brochesiatest.model.repositories.DrinkRepository
import javax.inject.Inject

class DrinkRepositoryImpl @Inject constructor(
    private val drinkApi: DrinkApi
): DrinkRepository {
    override suspend fun getDrinkByName(name: String): DrinkDto {
        return drinkApi.getDrinkByName(name)
    }

    override suspend fun getDrinkByCategory(category: String): DrinkDto {
       return drinkApi.getDrinkByCategory(category)
    }
}