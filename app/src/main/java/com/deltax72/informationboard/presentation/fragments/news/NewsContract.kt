package com.deltax72.informationboard.presentation.fragments.news

import androidx.room.Dao
import com.deltax72.informationboard.data.database.entities.NewsModel
import com.deltax72.informationboard.presentation.base.fragments.BaseContract
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsContract {
    interface ViewModel: BaseContract.ViewModel {
        fun getAllNews()
        fun removeNews(id: Long)
    }

    interface View: BaseContract.View {

    }

    interface Repository: BaseContract.Repository {
        suspend fun getAllNews(): List<NewsModel>
        suspend fun removeNews(id: Long): Response<NewsModel>
    }

    @Dao
    interface LocalDataSource: BaseContract.DataSource {

    }

    interface RemoteDataSource: BaseContract.DataSource {
        @GET("news")
        suspend fun getAllNews(): List<NewsModel>

        @DELETE("news/{id}")
        suspend fun removeNews(@Path("id") id: Long): Response<NewsModel>
    }
}
