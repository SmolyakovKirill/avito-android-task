package com.example.weatherapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.databinding.HourListItemBinding
import com.squareup.picasso.Picasso

class HourWeatherAdapter : ListAdapter<WeatherModel, HourWeatherAdapter.Holder>(Comparator()){

    class Holder(view: View) : RecyclerView.ViewHolder(view){
        val binding = HourListItemBinding.bind(view)

        fun bind(item: WeatherModel) = with(binding){
            tvDate.text = item.time.takeLast(5)
            tvFeels.text = "RealFeel: ${item.realFeelTemp}°С"
            tvTemp.text = "Temp: ${item.currentTemp}°С"
            Picasso.get().load("https:" + item.imageUrl).into(imageHourWeather)
        }
    }

    class Comparator: DiffUtil.ItemCallback<WeatherModel>(){
        override fun areItemsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hour_list_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

}