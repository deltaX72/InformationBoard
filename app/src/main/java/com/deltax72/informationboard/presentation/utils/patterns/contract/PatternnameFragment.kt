package com.deltax72.informationboard.presentation.utils.patterns.contract

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.deltax72.informationboard.databinding.FragmentPatternnameBinding
import com.deltax72.informationboard.presentation.base.fragments.BaseFragment

class PatternnameFragment:
    BaseFragment(),
    PatternnameContract.View
{
    private lateinit var binding: FragmentPatternnameBinding

    private val viewModel: PatternnameViewModel by activityViewModels {
        factory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPatternnameBinding.inflate(inflater, container, false)

        binding.apply {

        }

        return binding.root
    }
}