package com.deltax72.informationboard.presentation.usecases

import com.deltax72.informationboard.presentation.fragments.news.NewsContract
import javax.inject.Inject

class GetAllNewsUseCase @Inject constructor(
    private val newsRepository: NewsContract.Repository
) {

    suspend operator fun invoke() =
        newsRepository.getAllNews()
}