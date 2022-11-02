package com.tes.eat.anywhere.roomallocatorapp.ui.Room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tes.eat.anywhere.roomallocatorapp.databinding.FragmentRoomBinding
import com.tes.eat.anywhere.roomallocatorapp.model.data.room.Room
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomFragment : Fragment() {

    lateinit var binding: FragmentRoomBinding

    private val viewModel by activityViewModels<RoomViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRoomBinding.inflate(inflater)

        viewModel.room.observe(viewLifecycleOwner) {
            setupUI(it)
        }
        viewModel.getRoom()

        return binding.root
    }

    private fun setupUI(roomList: Room) {
        binding.roomList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = RoomAdapter(
                roomList
            )
        }
    }
}