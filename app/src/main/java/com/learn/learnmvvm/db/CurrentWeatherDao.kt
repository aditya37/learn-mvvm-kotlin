package com.learn.learnmvvm.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.learn.learnmvvm.db.entity.CurrentWeatherEntry
import com.learn.learnmvvm.db.entity.ID_WEATHER
import com.learn.learnmvvm.db.unitlocalized.current.ImperialCurrentWeatherEntry
import com.learn.learnmvvm.db.unitlocalized.current.MetricCurrentWeatherEntry
import com.learn.learnmvvm.db.unitlocalized.current.UnitSpecificCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(vararg weatherEntry: CurrentWeatherEntry)

    @Query("select * from current_weather where id = $ID_WEATHER")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>
//
//    @Query("select * from current_weather where id = $ID_WEATHER")
//    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}