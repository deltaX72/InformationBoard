package com.deltax72.informationboard.presentation.fragments.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.deltax72.informationboard.data.database.entities.NewsModel
import com.deltax72.informationboard.presentation.base.fragments.BaseViewModel
import com.deltax72.informationboard.presentation.usecases.GetAllNewsUseCase
import com.deltax72.informationboard.presentation.usecases.RemoveNewsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val getAllNewsUseCase: GetAllNewsUseCase,
    private val removeNewsUseCase: RemoveNewsUseCase
) : BaseViewModel(),
    NewsContract.ViewModel
{
    val newsListModelLiveData = MutableLiveData<MutableList<NewsModel>>()

    override fun getAllNews() {
        viewModelScope.launch {
            newsListModelLiveData.value = getAllNewsUseCase().toMutableList()
        }
    }

    override fun removeNews(id: Long) {
        viewModelScope.launch {
            val news = removeNewsUseCase(id)
        }
    }
}
