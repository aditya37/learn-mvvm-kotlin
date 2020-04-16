package com.learn.learnmvvm.db.repository

import androidx.lifecycle.LiveData
import com.learn.learnmvvm.db.unitlocalized.current.UnitSpecificCurrentWeatherEntry


/**
 * Created by Aditya Rahman on 4/16/20
 * Email : aditya.krohman@gmail.com
 * Copyright (c) 2020 brackets_hunt. All rights reserved.
 */

interface ForecastRepository {
    suspend fun getCurrentWeather(metric : Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>

}