package com.ethan.bridj.feature.events

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ethan.bridj.domain.usecase.EventsUseCase
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class EventsViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: EventsViewModel

    @MockK
    lateinit var eventsUseCase: EventsUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = EventsViewModel(eventsUseCase)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `test getEvents method`() {
        // create a test json file and write test logic here
        // can use okhttp3 mockwebserver to create a mock server with json for test
        viewModel.getEvents()
    }
}