package com.example.weatherapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.model.WeatherInfo
import com.example.weatherapp.model.WeatherResponse
import com.example.weatherapp.network.WeatherRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * The view model for weather forecast.
 */
class WeatherViewModel constructor(private val repository: WeatherRepository) : ViewModel() {
    val weatherList = MutableLiveData<WeatherResponse>()
    val list = MutableLiveData<WeatherInfo>()
    val city = MutableLiveData<String>()
    val error = MutableLiveData<String>()
    val appId = "65d00499677e59496ca2f318eb68c049"
    fun getWeatherInformation(city: String) {
        val response = repository.getWeather(city, appId)
        response.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                weatherList.postValue(response.body())
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                error.postValue(t.message)
            }
        })
    }

}

