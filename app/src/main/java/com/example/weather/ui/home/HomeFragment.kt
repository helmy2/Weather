package com.example.weather.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weather.databinding.FragmentHomeBinding
import com.example.weather.domain.model.WeatherDetails
import com.example.weather.domain.model.WeatherDay
import com.example.weather.domain.model.WeatherType
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val list = listOf(
        WeatherDetails(
            LocalDateTime.now(),
            25.0, 1012.2, 9.0, 89.0,
            WeatherType.fromWMO(2)
        ),
        WeatherDetails(
            LocalDateTime.now(),
            55.0, 1012.2, 9.0, 89.0,
            WeatherType.fromWMO(45)
        ),
        WeatherDetails(
            LocalDateTime.now(),
            25.0, 1012.2, 9.0, 89.0,
            WeatherType.fromWMO(55)
        ),
        WeatherDetails(
            LocalDateTime.now(),
            25.0, 1012.2, 9.0, 89.0,
            WeatherType.fromWMO(77)
        )
    )

    private val list2 = listOf(
        WeatherDay(
            LocalDateTime.now(),
            25.0, 19.2,
            WeatherType.fromWMO(2).weatherDesc,
            WeatherType.fromWMO(2)
        ),
        WeatherDay(
            LocalDateTime.now(),
            25.0, 19.2,
            WeatherType.fromWMO(2).weatherDesc,
            WeatherType.fromWMO(2)
        ),
        WeatherDay(
            LocalDateTime.now(),
            25.0, 19.2,
            WeatherType.fromWMO(55).weatherDesc,
            WeatherType.fromWMO(55),
        ),
        WeatherDay(
            LocalDateTime.now(),
            25.0, 19.2,
            WeatherType.fromWMO(77).weatherDesc,
            WeatherType.fromWMO(77),
        ),
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
        val todayAdapter = TodayListAdapter()
        val nextForecastAdapter = NextForecastListAdapter()

        binding.todayRecyclerView.adapter = todayAdapter
        binding.nextForecastrecyclerView.adapter = nextForecastAdapter

        binding.item = list.first()
        binding.maxTemp = 30.0
        binding.minTemp = 21.0
        todayAdapter.submitList(list)
        nextForecastAdapter.submitList(list2)
    }
}