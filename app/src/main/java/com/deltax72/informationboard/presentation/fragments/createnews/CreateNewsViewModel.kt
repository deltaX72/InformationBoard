package com.deltax72.informationboard.presentation.fragments.createnews

import androidx.lifecycle.viewModelScope
import com.deltax72.informationboard.data.database.entities.NewsModel
import com.deltax72.informationboard.presentation.base.fragments.BaseViewModel
import com.deltax72.informationboard.presentation.usecases.CreateNewsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CreateNewsViewModel @Inject constructor(
    private val createNewsUseCase: CreateNewsUseCase
) : BaseViewModel(),
    CreateNewsContract.ViewModel
{

    override fun createNews(newsModel: NewsModel) {
        viewModelScope.launch {
            createNewsUseCase(newsModel)
        }
    }
}
