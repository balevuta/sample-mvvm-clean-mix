package com.ethan.bridj.feature.events

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ethan.bridj.domain.model.EventModel
import com.ethan.bridj.domain.usecase.EventsUseCase
import com.ethan.bridj.feature.events.model.EventsViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val eventsUseCase: EventsUseCase,
) : ViewModel() {

    val detailViewState = MutableLiveData<EventsViewState>()

    fun getEvents() {
        detailViewState.postValue(EventsViewState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            val result = eventsUseCase.getEvents()
            when {
                result.isFailure -> {
                    detailViewState.postValue(EventsViewState.Error(throwable = result.exceptionOrNull()))
                }
                result.isSuccess -> {
                    result.getOrNull()?.let {
                        detailViewState.postValue(
                            EventsViewState.GetEventsSucceed(
                                seatAvailableEvents = filterSeatAvailableEvents(it),
                                playEvents = filterPlayEvents(it)
                            )
                        )
                    }
                }
            }
        }
    }

    private fun filterSeatAvailableEvents(input: List<EventModel>): List<EventModel> {
        return input.filter { it.availableSeats > 0 }.sortedByDescending { it.getDate() }
    }

    private fun filterPlayEvents(input: List<EventModel>): List<EventModel> {
        return input.filter { it.availableSeats > 0 && it.labels.contains("play") }.sortedByDescending { it.getDate() }
    }
}