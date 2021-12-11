package com.example.weatherapp.model

import java.util.*

/**
 * The data class for city
 */
data class City(
    val id: Int,
    val name: String,
    val country: String,
    val population: Int,
    val coord: Coord,
    val timeZone: TimeZone,
    val sunrise: Int,
    val sunset: Int
)

/**
 * The data class for coordinates
 */
data class Coord(
    val lat: Float,
    val lon: Float
)