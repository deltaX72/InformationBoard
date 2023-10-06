package com.deltax72.informationboard.presentation.fragments.news

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.deltax72.informationboard.R
import com.deltax72.informationboard.data.database.entities.NewsModel
import com.deltax72.informationboard.databinding.FragmentNewsBinding
import com.deltax72.informationboard.presentation.MainActivity
import com.deltax72.informationboard.presentation.adapters.news.NewsAdapter
import com.deltax72.informationboard.presentation.base.fragments.BaseFragment
import javax.inject.Inject

class NewsFragment:
    BaseFragment(),
    NewsContract.View
{
    private lateinit var binding: FragmentNewsBinding

    private lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private val viewModel: NewsViewModel by activityViewModels {
        factory
    }

    private val adapter = NewsAdapter {
        onRemoveNewsButtonClicked(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)

        viewModel.newsListModelLiveData.observe(viewLifecycleOwner, ::loadNews)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.newsList
        recyclerView.adapter = adapter

        (activity as MainActivity).apply {
            supportActionBar?.setDisplayShowTitleEnabled(true)
            setBottomNavigationVisibility(View.VISIBLE)
        }
        onMenuItemClick()

        viewModel.getAllNews()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_news_toolbar, menu)
    }

    private fun loadNews(news: MutableList<NewsModel>) {
        adapter.newsList = news
    }

    private fun onMenuItemClick() {
        binding.toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.addNews -> {
                    findNavController()
                        .navigate(R.id.action_newsFragment_to_createNewsFragment)
                }
                R.id.logOut -> {
                    sharedPreferences
                        .edit()
                        .putString("jwt", null)
                        .apply()
                    activity?.finish()
                }
            }
            true
        }
    }

    private fun onRemoveNewsButtonClicked(newsModel: NewsModel) {
        viewModel.removeNews(newsModel.id.toLong())
//        viewModel.getAllNews()
    }
}
