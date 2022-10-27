package com.example.weather.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.databinding.HourItemBinding
import com.example.weather.domain.model.WeatherDetails

class TodayListAdapter : ListAdapter<WeatherDetails, TodayWeatherViewHolder>(WeatherDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayWeatherViewHolder {
        return TodayWeatherViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TodayWeatherViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class WeatherDiffCallback : DiffUtil.ItemCallback<WeatherDetails>() {
    override fun areItemsTheSame(oldItem: WeatherDetails, newItem: WeatherDetails): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: WeatherDetails, newItem: WeatherDetails): Boolean {
        return oldItem == newItem
    }
}

class TodayWeatherViewHolder(private val binding: HourItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: WeatherDetails) {
        binding.item = item
    }

    companion object {
        fun from(parent: ViewGroup): TodayWeatherViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = HourItemBinding.inflate(layoutInflater, parent, false)
            return TodayWeatherViewHolder(binding)
        }
    }
}