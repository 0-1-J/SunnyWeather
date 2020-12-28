package com.jie.sunnyweather.logic

import androidx.lifecycle.liveData
import com.jie.sunnyweather.logic.model.Place
import com.jie.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext

object Repository {

    fun searchPlaces(address: String) = liveData(Dispatchers.IO){

        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(address)
            if (placeResponse.status == "1") {
               // val geocodes = placeResponse.geocodes
                val geocodes = placeResponse.geocodes
                Result.success(geocodes)
            } else {
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e: Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)


    }

//    fun refreshWeather(lng: String, lat: String, placeName: String) = fire(Dispatchers.IO) {
//        coroutineScope {
//            val deferredRealtime = async {
//                SunnyWeatherNetwork.getRealtimeWeather(lng, lat)
//            }
//            val deferredDaily = async {
//                SunnyWeatherNetwork.getDailyWeather(lng, lat)
//            }
//            val realtimeResponse = deferredRealtime.await()
//            val dailyResponse = deferredDaily.await()
//            if (realtimeResponse.status == "ok" && dailyResponse.status == "ok") {
//                val weather = Weather(realtimeResponse.result.realtime, dailyResponse.result.daily)
//                Result.success(weather)
//            } else {
//                Result.failure(
//                    RuntimeException(
//                        "realtime response status is ${realtimeResponse.status}" +
//                                "daily response status is ${dailyResponse.status}"
//                    )
//                )
//            }
//        }
//    }

//    fun savePlace(place: Place) = PlaceDao.savePlace(place)
//
//    fun getSavedPlace() = PlaceDao.getSavedPlace()
//
//    fun isPlaceSaved() = PlaceDao.isPlaceSaved()
//
//    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
//        liveData<Result<T>>(context) {
//            val result = try {
//                block()
//            } catch (e: Exception) {
//                Result.failure<T>(e)
//            }
//            emit(result)
//        }

}