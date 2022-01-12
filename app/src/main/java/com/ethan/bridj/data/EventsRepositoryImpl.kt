package com.ethan.bridj.data

import com.ethan.bridj.data.mapper.EventsResponseMapper
import com.ethan.bridj.data.network.EventsNetworkService
import com.ethan.bridj.domain.model.EventModel
import com.ethan.bridj.domain.repository.EventsRepository
import javax.inject.Inject

class EventsRepositoryImpl @Inject constructor(
    private val eventsNetworkService: EventsNetworkService,
    private val eventsMapperHolder: EventsResponseMapper,
) : EventsRepository {

    override suspend fun getEvents(): Result<List<EventModel>> {
        try {
            eventsNetworkService.getEvents()?.let {
                return Result.success(
                    value = eventsMapperHolder.map(
                        input = it
                    ).events
                )
            } ?: kotlin.run {
                return Result.failure(exception = Throwable(message = "There is a server error, please try again later!"))
            }
        } catch (ex: Exception) {
            return Result.failure(exception = ex)
        }
    }

}
