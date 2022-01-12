package com.ethan.bridj.feature.events.model

import com.ethan.bridj.domain.model.EventModel

sealed class EventsViewState {
    object Loading : EventsViewState()

    class GetEventsSucceed(val seatAvailableEvents: List<EventModel>,
                           val playEvents: List<EventModel>) :
        EventsViewState()

    class Error(val throwable: Throwable?) : EventsViewState()
}