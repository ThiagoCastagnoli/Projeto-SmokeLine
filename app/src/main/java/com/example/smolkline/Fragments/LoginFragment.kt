package com.example.smolkline.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smolkline.R
import com.example.smolkline.databinding.HomePageBinding

class LoginFragment : Fragment(R.layout.home_page) {

    private var _binding: HomePageBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = HomePageBinding.bind(view)




        binding.button.setOnClickListener {
            findNavController().navigate(
                R.id.action_homepageFrament_to_home_screen
            )
        }

        binding.txtRegister.setOnClickListener {
            findNavController().navigate(
                R.id.action_homePageFragment_to_cadastroFragment
            )
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}