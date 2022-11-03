package com.tes.eat.anywhere.roomallocatorapp.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tes.eat.anywhere.roomallocatorapp.model.data.people.People
import com.tes.eat.anywhere.roomallocatorapp.model.data.room.Room
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import retrofit2.Response

class FakeRepository: Repository{
    private val _people = MutableLiveData<People>()

    val people: LiveData<People> = _people
    override suspend fun getPeople(): Response<People> {
        TODO("Not yet implemented")
    }

    override suspend fun getRoom(): Response<Room> {
        TODO("Not yet implemented")
    }
}