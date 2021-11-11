package com.elhady.receiver.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import com.elhady.receiver.R
import com.elhady.receiver.background.server.ServerService
import com.elhady.receiver.databinding.FragmentHomeBinding

/**
 * Created by islam elhady on 11-Nov-21.
 */
class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding;


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStartReceiving.setOnClickListener { startServerService() }
        binding.btnShowData.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_userListFragment)
        }
    }

    private fun startServerService() {
        val intent = Intent(requireContext(), ServerService::class.java)
        ContextCompat.startForegroundService(requireContext(), intent)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

}