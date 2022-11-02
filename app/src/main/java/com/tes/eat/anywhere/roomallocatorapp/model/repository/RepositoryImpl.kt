package com.tes.eat.anywhere.roomallocatorapp.model.repository

import com.tes.eat.anywhere.roomallocatorapp.model.remote.people.PeopleApi
import com.tes.eat.anywhere.roomallocatorapp.model.remote.room.RoomApi
import javax.inject.Inject


class RepositoryImpl @Inject constructor(
        private val peopleApi: PeopleApi, private val roomApi: RoomApi
    ) : Repository {
        override suspend fun getPeople() = peopleApi.getPeople()

        override suspend fun getRoom() = roomApi.getRoom()
    }