package com.tes.eat.anywhere.roomallocatorapp.model.remote.room

import com.tes.eat.anywhere.roomallocatorapp.model.data.room.Room
import retrofit2.Response
import retrofit2.http.GET

interface RoomApi {
    @GET(RoomApiDetails.ROOM)
    suspend fun getRoom(): Response<Room>
}