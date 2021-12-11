package com.example.weatherapp.View

/**
 * This is adapter class to form the weather list for a particular city.
 */
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.LayoutRowItemBinding
import com.example.weatherapp.model.WeatherInfo

class WeatherAdapter(
    private val mList: List<WeatherInfo>,
    private val onWeatherDetailsClickListener: OnWeatherDetailsClickListener
) :
    RecyclerView.Adapter<WeatherAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class MainViewHolder(val binding: LayoutRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemViewModel: WeatherInfo) {
            binding.value.text = itemViewModel.main.temp.toString()
            binding.tvHeader.text = itemViewModel.weather[0].main
            binding.topLayout.setOnClickListener { view ->
                onWeatherDetailsClickListener.onWeatherDetailsClick(itemViewModel)
            }
        }
    }

    interface OnWeatherDetailsClickListener {
        fun onWeatherDetailsClick(weatherInfo: WeatherInfo)
    }

}



