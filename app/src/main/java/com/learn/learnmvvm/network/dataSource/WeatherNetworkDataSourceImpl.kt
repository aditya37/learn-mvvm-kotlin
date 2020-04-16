package com.learn.learnmvvm.network.dataSource

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.learn.learnmvvm.network.HttpClient
import com.learn.learnmvvm.network.response.CurrentWeatherResponse
import java.io.IOException

class WeatherNetworkDataSourceImpl(
    private val httpClient: HttpClient
) : WeatherNetworkDataSource {

    private val _downloadCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadCurrentWeather

    override suspend fun fetchCurrentWeather(location: String) {
        try {
            val request = httpClient
                .HttpService!!
                .getWeather(location).await()
            _downloadCurrentWeather.postValue(request)
        }catch (e: IOException){
            Log.e("Error Pak","Gak enek internet")
        }
    }

}