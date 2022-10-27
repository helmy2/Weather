package com.example.weather.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weather.R
import com.example.weather.databinding.FragmentHomeBinding
import com.example.weather.domain.model.WeatherData
import com.example.weather.domain.model.WeatherType
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    val list = listOf(
        WeatherData(
            LocalDateTime.now(),
            25.0, 1012.2, 9.0, 89.0,
            WeatherType.fromWMO(2)
        ),
        WeatherData(
            LocalDateTime.now(),
            55.0, 1012.2, 9.0, 89.0,
            WeatherType.fromWMO(45)
        ),
        WeatherData(
            LocalDateTime.now(),
            25.0, 1012.2, 9.0, 89.0,
            WeatherType.fromWMO(55)
        ),
        WeatherData(
            LocalDateTime.now(),
            25.0, 1012.2, 9.0, 89.0,
            WeatherType.fromWMO(77)
        )
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = TodayListAdapter()
        binding.recyclerView.adapter = adapter
        binding.item = list.first()
        binding.maxTemp = 30.0
        binding.minTemp = 21.0
        adapter.submitList(list)
    }
}