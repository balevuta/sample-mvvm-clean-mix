package com.ethan.bridj.domain.usecase

import com.ethan.bridj.domain.model.EventModel
import com.ethan.bridj.domain.repository.EventsRepository
import javax.inject.Inject

class EventsUseCaseImpl @Inject constructor(
    private val repository: EventsRepository
) : EventsUseCase {

    override suspend fun getEvents(): Result<List<EventModel>> {
        return repository.getEvents()
    }
}
