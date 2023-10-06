package com.deltax72.informationboard.presentation.fragments.userprofile

import androidx.room.Dao
import com.deltax72.informationboard.data.database.entities.User
import com.deltax72.informationboard.presentation.base.fragments.BaseContract
import retrofit2.http.GET
import retrofit2.http.Header

interface UserProfileContract {
    interface ViewModel: BaseContract.ViewModel {
        fun getUser(token: String)
    }

    interface View: BaseContract.View {

    }

    interface Repository: BaseContract.Repository {
        suspend fun getUser(token: String): User
    }

    @Dao
    interface LocalDataSource: BaseContract.DataSource {

    }

    interface RemoteDataSource: BaseContract.DataSource {
        @GET("/users/get/token")
        suspend fun getUser(
            @Header("Authorization")
            token: String
        ): User
    }
}
