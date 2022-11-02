package com.tes.eat.anywhere.roomallocatorapp.model.repository

import com.tes.eat.anywhere.roomallocatorapp.model.data.people.People
import com.tes.eat.anywhere.roomallocatorapp.model.data.room.Room
import retrofit2.Response

interface Repository {
    suspend fun  getPeople(): Response<People>

    suspend fun  getRoom(): Response<Room>
}