package com.example.weatherapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.databinding.DayListItemBinding
import com.squareup.picasso.Picasso

class DayWeatherAdapter() : ListAdapter<WeatherModel, DayWeatherAdapter.Holder>(Comparator()){

    class Holder(view: View) : RecyclerView.ViewHolder(view){
        val binding = DayListItemBinding.bind(view)

        fun bind(item: WeatherModel) = with(binding){
            tvDayDate.text = item.time
            tvDayCondition.text = item.condition
            tvDayMinMax.text = "${item.minTemp}°С/${item.maxTemp}°С"
            Picasso.get().load("https:" + item.imageUrl).into(imDayWeather)
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayWeatherAdapter.Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.day_list_item, parent, false)
        return Holder(view)
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    interface Listener{
        fun onClick(item: WeatherModel)
    }

}