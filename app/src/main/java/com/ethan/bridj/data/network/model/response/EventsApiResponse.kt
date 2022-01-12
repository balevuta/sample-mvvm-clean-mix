package com.ethan.bridj.data.network.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EventsApiResponse(
    val events: List<EventResponse>? = null
) {
    @JsonClass(generateAdapter = true)
    data class EventResponse(
        @Json(name = "available_seats")
        val availableSeats: Int? = null,
        val date: String? = null,
        val labels: List<String>? = null,
        val name: String? = null,
        val price: Double? = null,
        val venue: String? = null
    )
}