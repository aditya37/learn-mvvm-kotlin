package com.learn.learnmvvm.network.response


import com.google.gson.annotations.SerializedName
import com.learn.learnmvvm.db.entity.CurrentWeatherEntry
import com.learn.learnmvvm.db.entity.CurrentLocationEntry

data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    @SerializedName("location")
    val currentLocationEntry: CurrentLocationEntry
)