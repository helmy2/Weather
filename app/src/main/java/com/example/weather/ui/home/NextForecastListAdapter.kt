package com.example.weather.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.databinding.DayItemBinding
import com.example.weather.domain.model.WeatherDay

class NextForecastListAdapter : ListAdapter<WeatherDay, NextForecastViewHolder>(DayDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextForecastViewHolder {
        return NextForecastViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: NextForecastViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class DayDiffCallback : DiffUtil.ItemCallback<WeatherDay>() {
    override fun areItemsTheSame(oldItem: WeatherDay, newItem: WeatherDay): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: WeatherDay, newItem: WeatherDay): Boolean {
        return oldItem == newItem
    }
}

class NextForecastViewHolder(private val binding: DayItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: WeatherDay) {
        binding.item = item
    }

    companion object {
        fun from(parent: ViewGroup): NextForecastViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = DayItemBinding.inflate(layoutInflater, parent, false)
            return NextForecastViewHolder(binding)
        }
    }
}