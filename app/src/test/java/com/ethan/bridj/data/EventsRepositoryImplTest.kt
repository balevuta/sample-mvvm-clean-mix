package com.ethan.bridj.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ethan.bridj.data.mapper.EventsResponseMapper
import com.ethan.bridj.data.network.EventsNetworkService
import com.ethan.bridj.domain.repository.EventsRepository
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class EventsRepositoryImplTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var eventRepository: EventsRepository

    @RelaxedMockK
    lateinit var eventsNetworkService: EventsNetworkService

    @RelaxedMockK
    lateinit var eventsMapperHolder: EventsResponseMapper

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        eventRepository = EventsRepositoryImpl(eventsNetworkService, eventsMapperHolder)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getEvents(): Unit = runBlocking {
        // create a test json file and write test logic here
        // can use okhttp3 mockwebserver to create a mock server with json for test
        eventRepository.getEvents()
    }
}