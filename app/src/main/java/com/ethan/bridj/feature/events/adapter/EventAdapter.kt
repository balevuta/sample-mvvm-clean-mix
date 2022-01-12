package com.ethan.bridj.feature.events.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ethan.bridj.domain.model.EventModel

class EventAdapter(
) : ListAdapter<EventModel, RecyclerView.ViewHolder>(EventDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EventItemVH.onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItem(position)) {
            is EventModel -> {
                (holder as EventItemVH).onBind(model = getItem(position) as EventModel)
            }
        }
    }
}

class EventDiffCallback : DiffUtil.ItemCallback<EventModel>() {

    override fun areItemsTheSame(
        oldItem: EventModel,
        newItem: EventModel
    ): Boolean {
        return oldItem.name == newItem.name
            && oldItem.date == newItem.date
            && oldItem.venue == newItem.venue
    }

    override fun areContentsTheSame(
        oldItem: EventModel,
        newItem: EventModel
    ): Boolean {
        return oldItem == newItem
    }
}
