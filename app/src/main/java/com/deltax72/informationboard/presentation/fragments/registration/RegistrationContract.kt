package com.deltax72.informationboard.presentation.fragments.registration

import androidx.room.Dao
import androidx.room.Insert
import com.deltax72.informationboard.data.database.entities.auth.AuthRequest
import com.deltax72.informationboard.data.database.entities.User
import com.deltax72.informationboard.presentation.base.fragments.BaseContract
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

interface RegistrationContract {
    interface ViewModel: BaseContract.ViewModel {

    }

    interface View: BaseContract.View {

    }

    interface Repository: BaseContract.Repository {
        suspend fun signUp(request: AuthRequest): User
    }

    @Dao
    interface LocalDataSource: BaseContract.DataSource {
        @Insert
        suspend fun saveUser(request: AuthRequest)
    }

    interface RemoteDataSource: BaseContract.DataSource {
        @GET("/users/{id}")
        suspend fun getUser(@Path("id") userId: Long): Single<User>

        @GET("/users/get/username")
        suspend fun getUserByUsername(
            @Query(value = "username", encoded = true) username: String
        ): Single<User>

        @GET("/users")
        suspend fun getAllUsers(): Single<List<User>>

        @POST("/users/signup")
        suspend fun createUser(@Body request: AuthRequest): Single<User>

        @DELETE("/users/{id}")
        suspend fun deleteUser(@Path("id") userId: Long): Single<User>

        @PUT("/users/{id}/edit/password")
        suspend fun updateUserPassword(
            @Path("id") userId: Long,
            @Query(value = "password", encoded = true) newPassword: String
        ): Completable
    }
}
