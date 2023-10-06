package com.deltax72.informationboard.presentation.usecases

import com.deltax72.informationboard.data.database.entities.NewsModel
import com.deltax72.informationboard.presentation.fragments.createnews.CreateNewsContract
import javax.inject.Inject

class CreateNewsUseCase @Inject constructor(
    private val createNewsRepository: CreateNewsContract.Repository
) {

    suspend operator fun invoke(newsModel: NewsModel) =
        createNewsRepository.createNews(newsModel)
}