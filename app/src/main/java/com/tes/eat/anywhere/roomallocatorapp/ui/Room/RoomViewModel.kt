package com.tes.eat.anywhere.roomallocatorapp.ui.Room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tes.eat.anywhere.roomallocatorapp.model.data.room.Room
import com.tes.eat.anywhere.roomallocatorapp.model.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(
    private val repository: Repository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
): ViewModel() {
    private val _room = MutableLiveData<Room>()
    val room: LiveData<Room> = _room
    fun getRoom() {
        CoroutineScope(Dispatchers.Main).launch(dispatcher) {
            val roomList = repository.getRoom()
            if (roomList.isSuccessful) {
                _room.postValue(roomList.body())
            } else {
                _room.postValue(Room())
            }
        }
    }

}