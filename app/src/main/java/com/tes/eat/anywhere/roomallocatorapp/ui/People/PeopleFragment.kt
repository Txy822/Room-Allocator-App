package com.tes.eat.anywhere.roomallocatorapp.ui.People

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tes.eat.anywhere.roomallocatorapp.R
import com.tes.eat.anywhere.roomallocatorapp.databinding.FragmentPeopleBinding
import com.tes.eat.anywhere.roomallocatorapp.model.data.people.People
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment : Fragment(R.layout.fragment_people) {

    lateinit var binding: FragmentPeopleBinding
    val viewModel by activityViewModels<PeopleViewModel>()

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPeopleBinding.inflate(inflater)

        viewModel.people.observe(viewLifecycleOwner) {
            setupUI(it)
        }
        viewModel.getPeople()

        return binding.root
    }

    private fun setupUI(peopleList: People) {
        binding.peopleList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = PeopleAdapter(
                peopleList
            ) {item->


                viewModel.currentData=item
                //if the second parameter it mpve ot the function
//                findNavController().navigate(R.id.action_peopleFragment_to_detailFragment, bundleOf(Pair("FName", item.f)))
                findNavController().navigate(R.id.action_nav_people_to_nav_PersonDetail)
            }

        }


    }
}