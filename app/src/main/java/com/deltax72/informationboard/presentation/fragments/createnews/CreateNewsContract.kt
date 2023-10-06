package com.deltax72.informationboard.presentation.fragments.createnews

import androidx.room.Dao
import com.deltax72.informationboard.data.database.entities.NewsModel
import com.deltax72.informationboard.presentation.base.fragments.BaseContract
import retrofit2.http.Body
import retrofit2.http.POST

interface CreateNewsContract {
    interface ViewModel: BaseContract.ViewModel {
        fun createNews(newsModel: NewsModel)
    }

    interface View: BaseContract.View {

    }

    interface Repository: BaseContract.Repository {
        suspend fun createNews(newsModel: NewsModel): NewsModel
    }

    @Dao
    interface LocalDataSource: BaseContract.DataSource {

    }

    interface RemoteDataSource: BaseContract.DataSource {
        @POST("news")
        suspend fun createNews(@Body newsModel: NewsModel): NewsModel
    }
}
