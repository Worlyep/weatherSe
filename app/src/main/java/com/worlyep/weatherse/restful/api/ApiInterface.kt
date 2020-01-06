package com.worlyep.weatherse.restful.api

import com.worlyep.weatherse.restful.data.LocationResponse
import com.worlyep.weatherse.restful.data.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * 2020-01-03
 * @author worlyep
 **/
interface ApiInterface {
    /**
     * Single 타입으로 반환하는 이유
     * - 배압을 신경쓰지 않아도 되기 때문
     * - 성공 또는 실패의 2가지 경우로 결과값이 넘어오기 때문
     *
     * searchLocation 의 결과값이 있어야만 다음 처리가 가능하기에 Single 로 처리함
     */
    @GET("api/location/search")
    fun searchLocation(
        @Query("query") query: String?
    ): Single<ArrayList<WeatherResponse>>

    @GET("api/location/{woeid}")
    fun getLocationWeather(
        @Path("woeid") woeid: String?
    ): Single<LocationResponse>
}