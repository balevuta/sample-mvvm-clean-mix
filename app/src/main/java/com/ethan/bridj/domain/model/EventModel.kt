package com.ethan.bridj.domain.model

import com.ethan.bridj.data.network.model.response.EventsApiResponse.EventResponse
import com.ethan.bridj.utils.DateFormat
import com.ethan.bridj.utils.orDefault
import java.util.*

data class EventModel(
    val availableSeats: Int,
    val date: String,
    val labels: List<String>,
    val name: String,
    val price: Double,
    val venue: String
) {

    fun getDate(): Date? {
        return try {
            DateFormat.DATE_LONG_FORMAT.parse(date)
        } catch (ex: Exception) {
            null
        }
    }

    companion object {

        private fun convertToEventModel(response: EventResponse): EventModel {
            return EventModel(
                availableSeats = response.availableSeats.orDefault(0),
                date = response.date.orEmpty(),
                labels = response.labels.orEmpty(),
                name = response.name.orEmpty(),
                price = response.price.orDefault(0.0),
                venue = response.venue.orEmpty()
            )
        }

        fun convertToEventListModel(listResponse: List<EventResponse>?): List<EventModel> {
            return listResponse?.map { it -> convertToEventModel(it) } ?: arrayListOf()
        }
    }
}

data class EventListModel(
    val events: List<EventModel>
)