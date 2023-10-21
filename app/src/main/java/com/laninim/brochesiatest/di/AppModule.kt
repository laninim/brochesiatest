package com.laninim.brochesiatest.di

import com.laninim.brochesiatest.data.DrinkApi
import com.laninim.brochesiatest.data.repositories.DrinkRepositoryImpl
import com.laninim.brochesiatest.model.repositories.DrinkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDrinkApi() : DrinkApi {
        val drinkApi = Retrofit.Builder().baseUrl("https://www.thecocktaildb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return  drinkApi.create(DrinkApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDrinkRepository(drinkApi: DrinkApi) : DrinkRepository {
        return DrinkRepositoryImpl(drinkApi)
    }
}