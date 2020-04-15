package com.learn.learnmvvm.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val ID_WEATHER = 0

@Entity(tableName = "current_weather")
data class CurrentWeatherEntry(
    @SerializedName("cloudcover")
    val cloudcover: Double,
    @SerializedName("feelslike")
    val feelslike: Double,
    @SerializedName("humidity")
    val humidity: Double,
    @SerializedName("is_day")
    val isDay: String,
    @SerializedName("observation_time")
    val observationTime: String,
    @SerializedName("precip")
    val precip: Double,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("temperature")
    val temperature: Double,
    @SerializedName("uv_index")
    val uvIndex: Int,
    @SerializedName("visibility")
    val visibility: Double,
    @SerializedName("weather_code")
    val weatherCode: Double,
    @SerializedName("wind_degree")
    val windDegree: Int,
    @SerializedName("wind_dir")
    val windDir: String,
    @SerializedName("wind_speed")
    val windSpeed: Double
){
  @PrimaryKey(autoGenerate = false)
  var id:Int = ID_WEATHER
}