package com.worlyep.weatherse.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.worlyep.weatherse.data.restful.WeatherResponse

@Database(
    entities = [WeatherResponse::class],
    version = 1,
    exportSchema = false
)
abstract class WeatherRoomData : RoomDatabase() {
    abstract fun weatherRoomDao(): WeatherRoomDao

    companion object {
        private var INSTANCE: WeatherRoomData? = null

        fun getInstance(context: Context): WeatherRoomData? {
            if (INSTANCE == null) {
                synchronized(WeatherRoomData::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        WeatherRoomData::class.java,
                        "cities_data.db"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}