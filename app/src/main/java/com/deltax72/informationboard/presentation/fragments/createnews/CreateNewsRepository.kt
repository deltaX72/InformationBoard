package com.deltax72.informationboard.presentation.fragments.createnews

import com.deltax72.informationboard.data.database.entities.NewsModel
import javax.inject.Inject

class CreateNewsRepository @Inject constructor(
    private val remote: CreateNewsContract.RemoteDataSource
) : CreateNewsContract.Repository {
    override suspend fun createNews(newsModel: NewsModel): NewsModel {
        return remote.createNews(newsModel)
    }
}
