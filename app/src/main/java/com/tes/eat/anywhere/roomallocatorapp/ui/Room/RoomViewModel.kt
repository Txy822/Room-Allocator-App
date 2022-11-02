package com.tes.eat.anywhere.roomallocatorapp.ui.Room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RoomViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is People Fragment"
    }
    val text: LiveData<String> = _text
}