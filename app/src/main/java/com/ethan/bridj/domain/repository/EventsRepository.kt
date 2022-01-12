package com.ethan.bridj.domain.repository

import com.ethan.bridj.domain.model.EventModel

interface EventsRepository {

    suspend fun getEvents(): Result<List<EventModel>>
}
