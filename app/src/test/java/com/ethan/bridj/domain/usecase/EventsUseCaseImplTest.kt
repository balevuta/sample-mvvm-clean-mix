package com.ethan.bridj.domain.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
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
class EventsUseCaseImplTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var eventUseCase: EventsUseCase

    @RelaxedMockK
    lateinit var eventsRepository: EventsRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        eventUseCase = EventsUseCaseImpl(eventsRepository)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `test getEvents method`(): Unit = runBlocking {
        // create a test json file and write test logic here
        // can use okhttp3 mockwebserver to create a mock server with json for test
        eventUseCase.getEvents()
    }
}