package com.example.weatherapp.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentFirstBinding
import com.example.weatherapp.network.RetrofitService
import com.example.weatherapp.network.WeatherRepository
import com.example.weatherapp.viewModel.WeatherViewModel
import com.example.weatherapp.viewModel.WeatherViewModelFactory

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class WeatherFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    lateinit var viewModel: WeatherViewModel
    private val retrofitService = RetrofitService.getInstance()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = requireActivity().run {
            ViewModelProvider(
                this,
                WeatherViewModelFactory(WeatherRepository(retrofitService))
            ).get(WeatherViewModel::class.java)
        }
        binding.buttonFirst.setOnClickListener {
            viewModel.getWeatherInformation(binding.editText.text.toString())
            viewModel.city.value = (binding.editText.text.toString())
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}