package com.example.weatherapp.model

/**
 * The data class for weather response.
 */
data class WeatherResponse(
    val cod: String,
    val message: Int,
    val cnt: Int,
    val list: ArrayList<WeatherInfo>,
    val city: City
)