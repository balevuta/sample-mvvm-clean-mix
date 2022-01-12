package com.ethan.bridj.feature.events.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ethan.bridj.databinding.LayoutEventItemBinding
import com.ethan.bridj.domain.model.EventModel
import com.ethan.bridj.utils.toStandardDateDisplay

class EventItemVH constructor(
    private val binding: LayoutEventItemBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(model: EventModel) {
        binding.tvName.text = model.name
        binding.tvPrice.text = model.price.toString()
        binding.tvVanue.text = model.venue
        binding.tvDate.text = model.date.toStandardDateDisplay()
    }

    companion object {

        fun onCreateViewHolder(
            parent: ViewGroup,
        ): RecyclerView.ViewHolder {
            val binding = LayoutEventItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            return EventItemVH(binding = binding)
        }
    }
}