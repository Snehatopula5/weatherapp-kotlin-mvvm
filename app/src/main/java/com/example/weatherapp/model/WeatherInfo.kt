package com.example.weatherapp.model

import java.util.*

/**
 * This is the data class for weather.
 */
data class WeatherInfo(
    val dt: Int,
    val main: Main,
    val weather: ArrayList<Weather>,
    val clouds: Cloud,
    val wind: Wind,
    val sys: Sys,
    val dt_txt: String,
)

/**
 *This is data class for Sys.
 */
data class Sys(
    val pod: String
)

/**
 * This is data class for wind.
 */
data class Wind(
    val speed: Float, val deg: Float, val gust: Float
)

/**
 * This is data class for Cloud.
 */
data class Cloud(
    val all: Float
)

/**
 * This is a data class for Weather.
 */
data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String,
)

/**
 * This is a data class for Main class
 */
data class Main(
    val temp: Float,
    val feels_like: Float,
    val temp_min: Float,
    val temp_max: Float,
    val pressure: Float,
    val sea_level: Float,
    val grnd_level: Float,
    val humidity: Float,
    val temp_kf: Float
)
