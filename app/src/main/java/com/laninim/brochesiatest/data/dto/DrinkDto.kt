package com.laninim.brochesiatest.data.dto


import com.google.gson.annotations.SerializedName
import com.laninim.brochesiatest.data.dto.Drink

data class DrinkDto(
    @SerializedName("drinks")
    val drinks: List<Drink>
)