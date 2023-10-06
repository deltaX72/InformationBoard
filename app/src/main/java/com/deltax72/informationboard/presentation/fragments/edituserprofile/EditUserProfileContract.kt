package com.deltax72.informationboard.presentation.fragments.edituserprofile

import androidx.room.Dao
import com.deltax72.informationboard.presentation.base.fragments.BaseContract
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query

interface EditUserProfileContract {
    interface ViewModel: BaseContract.ViewModel {
        fun updateUserProfile(token: String, firstName: String, lastName: String)
    }

    interface View: BaseContract.View {

    }

    interface Repository: BaseContract.Repository {
        suspend fun updateUserFirstName(id: Long, token: String, firstName: String)
        suspend fun updateUserLastName(id: Long, token: String, lastName: String)
    }

    @Dao
    interface LocalDataSource: BaseContract.DataSource {

    }

    interface RemoteDataSource: BaseContract.DataSource {
        @PATCH("/users/{id}/edit/firstname")
        suspend fun updateUserFirstName(
            @Path("id") id: Long,
            @Header("Authorization") token: String,
            @Query("firstName") firstName: String
        )

        @PATCH("/users/{id}/edit/lastname")
        suspend fun updateUserLastName(
            @Path("id") id: Long,
            @Header("Authorization") token: String,
            @Query("lastName") lastName: String
        )
    }
}
