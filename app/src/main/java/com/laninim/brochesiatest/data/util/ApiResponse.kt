package com.laninim.brochesiatest.data.util

import com.laninim.brochesiatest.data.dto.DrinkDto
import java.lang.Exception

sealed class ApiResponse {

    class Success(val response : DrinkDto) : ApiResponse()

    class Failure(val exception: Exception) : ApiResponse()
}
