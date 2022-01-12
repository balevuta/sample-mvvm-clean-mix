package com.ethan.bridj.domain.usecase

import com.ethan.bridj.domain.model.EventModel

interface EventsUseCase {

    suspend fun getEvents(): Result<List<EventModel>>
}
