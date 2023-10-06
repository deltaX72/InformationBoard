package com.deltax72.informationboard.presentation.fragments.createnews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.deltax72.informationboard.R
import com.deltax72.informationboard.data.database.entities.NewsModel
import com.deltax72.informationboard.databinding.FragmentCreateNewsBinding
import com.deltax72.informationboard.presentation.MainActivity
import com.deltax72.informationboard.presentation.base.fragments.BaseFragment

class CreateNewsFragment:
    BaseFragment(),
    CreateNewsContract.View
{
    private lateinit var binding: FragmentCreateNewsBinding

    private val viewModel: CreateNewsViewModel by activityViewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onBackPressed(R.id.action_createNewsFragment_to_newsFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateNewsBinding.inflate(inflater, container, false)

        binding.apply {

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        binding.apply {
            toolbar.apply {
                setNavigationOnClickListener {
                    findNavController().navigate(R.id.action_createNewsFragment_to_newsFragment)
                }
            }

            createNewsButton.setOnClickListener {
                viewModel.createNews(
                    NewsModel(
                        username = username.text.toString(),
                        topic = topic.text.toString(),
                        message = message.text.toString()
                    )
                )
                findNavController().popBackStack()
            }
        }
    }
}
