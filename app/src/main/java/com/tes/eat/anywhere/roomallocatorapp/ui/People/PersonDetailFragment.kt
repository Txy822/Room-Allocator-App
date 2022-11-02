package com.tes.eat.anywhere.roomallocatorapp.ui.People

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.tes.eat.anywhere.roomallocatorapp.R
import com.tes.eat.anywhere.roomallocatorapp.databinding.FragmentPersonDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonDetailFragment : Fragment(R.layout.fragment_person_detail) {

    lateinit var binding: FragmentPersonDetailBinding
    val viewModel by activityViewModels<PeopleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonDetailBinding.inflate(inflater)
        // Inflate the layout for this fragment

        viewModel.currentData.let {
            binding.tvUserName.text = "Full Name: ${it.firstName}  ${it.lastName}"
            binding.tvJobTitle.text = "Job Title: ${it.jobtitle}"
            binding.tvEmail.text = "Email: ${it.email}"
            binding.tvFavoriteColor.text = "Favorite Color: ${it.favouriteColor}"


            Glide.with(requireContext())
                .load(it.avatar)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.tvProfilePicture)
        }
        return binding.root
    }
}

