package com.example.weatherapp.network

/**
 * This is a repository class for making the retrofit call.
 */
class WeatherRepository constructor(private val retrofitService: RetrofitService) {

    fun getWeather( city: String, appId: String) = retrofitService.getWeather(city, appId)
}