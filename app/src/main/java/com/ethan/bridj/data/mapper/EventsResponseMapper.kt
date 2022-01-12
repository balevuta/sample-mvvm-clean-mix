package com.ethan.bridj.data.mapper

import com.ethan.bridj.data.network.model.response.EventsApiResponse
import com.ethan.bridj.domain.model.EventListModel
import com.ethan.bridj.domain.model.EventModel
import javax.inject.Inject

class EventsResponseMapper @Inject constructor() : Mapper<EventsApiResponse, EventListModel> {

    override fun map(input: EventsApiResponse): EventListModel {
        return EventListModel(events = EventModel.convertToEventListModel(input.events))
    }
}
