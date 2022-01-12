package com.ethan.bridj.di

import com.ethan.bridj.data.EventsRepositoryImpl
import com.ethan.bridj.data.mapper.EventsResponseMapper
import com.ethan.bridj.data.mapper.Mapper
import com.ethan.bridj.data.network.model.response.EventsApiResponse
import com.ethan.bridj.domain.model.EventListModel
import com.ethan.bridj.domain.repository.EventsRepository
import com.ethan.bridj.domain.usecase.EventsUseCase
import com.ethan.bridj.domain.usecase.EventsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class EventsBindingModule {

    @Binds
    abstract fun bindEventsUseCase(useCaseImpl: EventsUseCaseImpl): EventsUseCase

    @Binds
    abstract fun bindEventsRepository(
        eventsRepositoryImpl: EventsRepositoryImpl
    ): EventsRepository

    @Binds
    abstract fun bindsEventsResponseMapper(
        eventsRequestMapper: EventsResponseMapper
    ): Mapper<EventsApiResponse, EventListModel>
}
