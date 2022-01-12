package com.ethan.bridj.data.network

import com.ethan.bridj.data.network.model.response.EventsApiResponse
import retrofit2.http.GET

interface EventsNetworkService {

    @GET("bridj-coding-challenge/events.json")
    suspend fun getEvents(): EventsApiResponse?
}
