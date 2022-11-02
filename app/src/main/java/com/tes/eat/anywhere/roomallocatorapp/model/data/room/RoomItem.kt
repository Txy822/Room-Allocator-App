package com.tes.eat.anywhere.roomallocatorapp.model.data.room


import com.google.gson.annotations.SerializedName

data class RoomItem(
    @SerializedName("createdAt")
    val createdAt: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("isOccupied")
    val isOccupied: Boolean = false,
    @SerializedName("maxOccupancy")
    val maxOccupancy: Int = 0
)