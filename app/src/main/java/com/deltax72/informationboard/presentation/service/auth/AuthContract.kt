package com.deltax72.informationboard.presentation.service.auth

import android.content.SharedPreferences
import com.deltax72.informationboard.data.database.entities.auth.AuthRequest
import com.deltax72.informationboard.data.database.entities.auth.TokenResponse
import com.deltax72.informationboard.data.database.entities.User
import com.deltax72.informationboard.data.database.entities.auth.AuthUIEvent
import com.deltax72.informationboard.presentation.base.fragments.BaseContract
import retrofit2.http.*

interface AuthContract {

    interface View: BaseContract.View {

    }

    interface ViewModel: BaseContract.ViewModel {
        fun signUp()
        fun signIn()
        fun authenticate()

        fun onAuthEvent(event: AuthUIEvent)
    }

    interface Repository: BaseContract.Repository {
        suspend fun signUp(username: String, password: String): AuthResult<Unit>
        suspend fun signIn(username: String, password: String): AuthResult<Unit>
        suspend fun authenticate(): AuthResult<Unit>
        suspend fun logOut()

        fun getPrefs(): SharedPreferences
    }

    interface DataSource: BaseContract.DataSource {
        @POST("/users/signup")
        suspend fun signUp(@Body request: AuthRequest): User

        @POST("users/signin")
        suspend fun signIn(@Body request: AuthRequest): TokenResponse

        @GET("authenticate")
        suspend fun authenticate(@Header("Authorization") token: String)
    }
}