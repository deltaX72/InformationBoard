package com.deltax72.informationboard.presentation.fragments.news

import com.deltax72.informationboard.data.database.entities.NewsModel
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val remote: NewsContract.RemoteDataSource
) : NewsContract.Repository {

    override suspend fun getAllNews(): List<NewsModel> {
        return remote.getAllNews()
    }

    override suspend fun removeNews(id: Long): Response<NewsModel> {
        return remote.removeNews(id)
    }
}
