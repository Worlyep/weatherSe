package com.worlyep.weatherse.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.worlyep.weatherse.data.restful.WeatherResponse

@Dao
interface WeatherRoomDao {
    @Insert(onConflict = REPLACE)
    fun insert(item: WeatherResponse)

    @Delete
    fun deleteData(item: WeatherResponse)

    @Query("SELECT woeid FROM cities WHERE locaName=:name")
    fun getWoeId(name: String?): Int

    @Query("SELECT COUNT(*) FROM cities")
    fun loadAllDataCount(): Int

    @Query("SELECT * FROM cities")
    fun loadAllData(): MutableList<WeatherResponse>
}