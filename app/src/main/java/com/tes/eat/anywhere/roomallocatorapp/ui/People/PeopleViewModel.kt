package com.tes.eat.anywhere.roomallocatorapp.ui.People

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tes.eat.anywhere.roomallocatorapp.model.data.people.People
import com.tes.eat.anywhere.roomallocatorapp.model.data.people.PeopleItem
import com.tes.eat.anywhere.roomallocatorapp.model.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    var currentData= PeopleItem()
    private val _people = MutableLiveData<People>()
    val people: LiveData<People> = _people
    fun getPeople() {
        CoroutineScope(Dispatchers.Main).launch {
            val peopleList = repository.getPeople()
            if (peopleList.isSuccessful) {
                _people.postValue(peopleList.body())
            } else {
                _people.postValue(People())
            }
        }
    }
}