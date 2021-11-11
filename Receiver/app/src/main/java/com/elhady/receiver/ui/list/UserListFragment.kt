package com.elhady.receiver.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elhady.receiver.databinding.UserListFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by islam elhady on 11-Nov-21.
 */
class UserListFragment : Fragment() {

    private val viewModel: UserListViewModel by viewModel()
    private lateinit var binding: UserListFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UserListFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this
        binding.list.adapter = UsersAdapter()
        binding.viewModel = viewModel

    }

    companion object {
        @JvmStatic
        fun newInstance() = UserListFragment()
    }


}