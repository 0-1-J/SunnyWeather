package com.jie.sunnyweather.logic.network

import android.app.Application
import com.jie.sunnyweather.SunnyWeatherApplication
import com.jie.sunnyweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {
    @GET("v3/geocode/geo?key=${SunnyWeatherApplication.KEY}")
    fun searchPlaces(@Query("address") address: String): Call<PlaceResponse>
}