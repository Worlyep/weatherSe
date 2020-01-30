package com.worlyep.weatherse.data.restful

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * 2020-01-03
 * @author worlyep
 **/

@Entity(tableName = "cities")
data class WeatherResponse(
    @SerializedName("title")
    @Expose
    val locaName: String,
    @SerializedName("location_type")
    @Expose
    val locaType: String? = null,
    @PrimaryKey
    @SerializedName("woeid")
    @Expose
    val woeid: Int? = 0,
    @SerializedName("latt_long")
    @Expose
    val locaCode: String? = ""
) {
    val woeIdString
        get() = woeid.toString()
}