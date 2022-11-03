package com.tes.eat.anywhere.roomallocatorapp.ui.People

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.tes.eat.anywhere.roomallocatorapp.MainCoroutineRule
import com.tes.eat.anywhere.roomallocatorapp.model.data.people.People
import com.tes.eat.anywhere.roomallocatorapp.model.data.people.PeopleItem
import com.tes.eat.anywhere.roomallocatorapp.model.repository.Repository
import io.mockk.coEvery
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.*
import org.junit.Assert.*
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.MockitoRule
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import retrofit2.Response
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.mockito.Mockito

@OptIn(ExperimentalCoroutinesApi::class)
class PeopleViewModelTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    private val repository:Repository = mockk{coEvery{getPeople()} returns Response.success(People()) }
    private lateinit var peopleViewModel: PeopleViewModel

    @Before
    fun setUp() {
        peopleViewModel = PeopleViewModel(repository, dispatcher)
    }

    @Test
    fun `Test state loaded -success`() {

        peopleViewModel.getPeople()
        dispatcher.scheduler.advanceUntilIdle()
        assertNotNull(peopleViewModel.people)
    }

}
