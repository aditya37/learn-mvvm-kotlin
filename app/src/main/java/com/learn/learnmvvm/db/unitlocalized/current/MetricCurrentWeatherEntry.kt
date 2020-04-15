package com.learn.learnmvvm.db.unitlocalized.current

import androidx.room.ColumnInfo

data class MetricCurrentWeatherEntry(
    @ColumnInfo(name = "temperature")
    override val temperature: Double ,
    @ColumnInfo(name = "windSpeed")
    override val windSpeed: Double,
    @ColumnInfo(name = "precip")
    override val precipitationVolume: Double,
    @ColumnInfo(name = "feelslike")
    override val feelsLikeTemperature: Double,
    @ColumnInfo(name = "visibility")
    override val visibilityDistance: Double
):UnitSpecificCurrentWeatherEntry