package com.tes.eat.anywhere.roomallocatorapp.ui.People

import com.tes.eat.anywhere.roomallocatorapp.model.data.people.People
import com.tes.eat.anywhere.roomallocatorapp.model.data.people.PeopleItem

sealed class PeopleState {
    object Loading : PeopleState()
    data class Content(val people: PeopleItem) : PeopleState()
    object Error :PeopleState()

    /*
    object Loading : PeopleState()
    data class Content<T>(val data: T) : PeopleState()
    data class Error(val errorMessage: String) :PeopleState()
    * */
}