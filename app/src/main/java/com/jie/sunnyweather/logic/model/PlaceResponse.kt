package com.jie.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

data class PlaceResponse(val status: String, val geocodes: List<Place>)


data class Place(val city: String, val location: String,
                 @SerializedName("formatted_address") val address: String)

