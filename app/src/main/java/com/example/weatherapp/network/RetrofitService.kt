package com.example.weatherapp.network

import retrofit2.Call
import com.example.weatherapp.model.WeatherResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * This is a retrofit service call for making api call
 */
interface RetrofitService {

    @GET("forecast")
    fun getWeather(@Query("q")q: String, @Query("appid") appId: String): Call<WeatherResponse>

    companion object{
        var retrofitService: RetrofitService? = null
        fun getInstance() : RetrofitService {
           if(retrofitService == null) {
               val retrofit = Retrofit.Builder()
                   .baseUrl("https://api.openweathermap.org/data/2.5/")
                   .addConverterFactory(GsonConverterFactory.create())
                   .build()
               retrofitService = retrofit.create(RetrofitService::class.java)
           }
            return retrofitService!!
        }
    }

}