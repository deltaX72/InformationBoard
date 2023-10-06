package com.deltax72.informationboard.presentation.fragments.friendslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.deltax72.informationboard.databinding.FragmentFriendsListBinding
import com.deltax72.informationboard.presentation.base.fragments.BaseFragment

class FriendsListFragment:
    BaseFragment(),
    FriendsListContract.View
{
    private lateinit var binding: FragmentFriendsListBinding

    private val viewModel: FriendsListViewModel by activityViewModels {
        factory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFriendsListBinding.inflate(inflater, container, false)

        binding.apply {

        }

        return binding.root
    }
}
