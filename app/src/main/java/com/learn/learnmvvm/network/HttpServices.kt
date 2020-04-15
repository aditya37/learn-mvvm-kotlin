package com.learn.learnmvvm.network

import com.learn.learnmvvm.network.response.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface HttpServices {

    @GET("current")
    fun getWeather(
        @Query("query") location: String
    ): Deferred<CurrentWeatherResponse>
}