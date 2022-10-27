package com.example.weather.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.databinding.TodayItemBinding
import com.example.weather.domain.model.WeatherData

class TodayListAdapter: ListAdapter<WeatherData, TodayWeatherViewHolder>(WeatherDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayWeatherViewHolder {
        return TodayWeatherViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TodayWeatherViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class WeatherDiffCallback : DiffUtil.ItemCallback<WeatherData>() {
    override fun areItemsTheSame(oldItem: WeatherData, newItem: WeatherData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: WeatherData, newItem: WeatherData): Boolean {
        return oldItem == newItem
    }
}

class TodayWeatherViewHolder(private val binding: TodayItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: WeatherData) {
        binding.item = item
    }

    companion object {
        fun from(parent: ViewGroup): TodayWeatherViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = TodayItemBinding.inflate(layoutInflater, parent, false)
            return TodayWeatherViewHolder(binding)
        }
    }
}