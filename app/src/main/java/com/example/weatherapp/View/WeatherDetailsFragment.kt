package com.example.weatherapp.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentWeatherDetailsBinding
import com.example.weatherapp.network.RetrofitService
import com.example.weatherapp.viewModel.WeatherViewModel

/**
 * This fragment will give detail information of weather.
 */
class WeatherDetailsFragment : Fragment() {

    private var _binding: FragmentWeatherDetailsBinding? = null
    lateinit var viewModel: WeatherViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentWeatherDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(WeatherViewModel::class.java)
        viewModel.list.observe(viewLifecycleOwner, Observer {
            it.let {
                binding.tvTemp.text = it.main.temp.toString()
                binding.tvFeels.text =
                    getString(R.string.feels_like) + it.main.feels_like.toString()
                binding.tvWeather.text = it.weather[0].main
                binding.tvWeatherCondition.text = it.weather[0].description
            }

        })
        viewModel.city.observe(viewLifecycleOwner, Observer<String> {
            (activity as AppCompatActivity?)?.supportActionBar?.title = it
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}