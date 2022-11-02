package com.tes.eat.anywhere.roomallocatorapp.model.remote.people

import com.tes.eat.anywhere.roomallocatorapp.model.data.people.People
import retrofit2.Response
import retrofit2.http.GET

interface PeopleApi {
    @GET(PeopleApiDetails.PEOPLE)
    suspend fun getPeople(): Response<People>
}