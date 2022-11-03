package com.tes.eat.anywhere.roomallocatorapp.di

import com.tes.eat.anywhere.roomallocatorapp.model.remote.people.PeopleApi
import com.tes.eat.anywhere.roomallocatorapp.model.remote.people.PeopleApiDetails
import com.tes.eat.anywhere.roomallocatorapp.model.remote.room.RoomApi
import com.tes.eat.anywhere.roomallocatorapp.model.repository.Repository
import com.tes.eat.anywhere.roomallocatorapp.model.repository.RepositoryImpl

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(PeopleApiDetails.BASE_URL)
        .build()

    @Provides
    fun providePeopleApi(retrofit: Retrofit): PeopleApi =retrofit.create(PeopleApi::class.java)

    @Provides
    fun provideRoomApi(retrofit: Retrofit): RoomApi =retrofit.create(RoomApi::class.java)

    @Provides
    fun provideRepository(
        peopleApi: PeopleApi,roomApi: RoomApi
    ): Repository {
        return RepositoryImpl(peopleApi,roomApi)
    }


    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}