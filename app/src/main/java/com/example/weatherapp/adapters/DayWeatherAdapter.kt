package com.example.weatherapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.databinding.DayListItemBinding
import com.example.weatherapp.fragments.DaysFragment
import com.squareup.picasso.Picasso

class DayWeatherAdapter(val listener:Listener?) : ListAdapter<WeatherModel, DayWeatherAdapter.Holder>(Comparator()){

    class Holder(view: View, val listener: Listener?) : RecyclerView.ViewHolder(view){
        val binding = DayListItemBinding.bind(view)
        var itemTemp: WeatherModel? = null
        init {
            itemView.setOnClickListener{
                itemTemp?.let { it1 -> listener?.onClick(it1) }
            }
        }

        fun bind(item: WeatherModel) = with(binding){
            itemTemp = item
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
        return Holder(view, listener)
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    interface Listener{
        fun onClick(item: WeatherModel)
    }

}