package com.learn.learnmvvm.network.dataSource

import androidx.lifecycle.LiveData
import com.learn.learnmvvm.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {

    val downloadCurrentWeather : LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(location: String)
}