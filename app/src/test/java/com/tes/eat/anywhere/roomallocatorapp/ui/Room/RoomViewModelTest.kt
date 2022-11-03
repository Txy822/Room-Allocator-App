package com.tes.eat.anywhere.roomallocatorapp.ui.Room

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.tes.eat.anywhere.roomallocatorapp.model.data.people.People
import com.tes.eat.anywhere.roomallocatorapp.model.data.room.Room
import com.tes.eat.anywhere.roomallocatorapp.model.repository.Repository
import com.tes.eat.anywhere.roomallocatorapp.ui.People.PeopleViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.StandardTestDispatcher
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class RoomViewModelTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    private val repository: Repository = mockk { coEvery { getRoom() } returns mockk() }
    private lateinit var roomViewModel: RoomViewModel


    @Before
    fun setUp() {
        roomViewModel = RoomViewModel(repository, dispatcher)
    }

    @Test
    fun `Test state loaded -success`() {
        roomViewModel.getRoom()
        dispatcher.scheduler.advanceUntilIdle()
        assert(roomViewModel.room.value is Room)
    }

    @Test
    fun `Test state loaded -failure`() {
        roomViewModel.getRoom()
        dispatcher.scheduler.advanceUntilIdle()
        assert(roomViewModel.room.value is Room)
    }
}