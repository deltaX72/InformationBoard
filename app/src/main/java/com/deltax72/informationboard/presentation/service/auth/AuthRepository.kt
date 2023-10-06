package com.deltax72.informationboard.presentation.service.auth

import android.content.SharedPreferences
import com.deltax72.informationboard.data.database.entities.auth.AuthRequest
import retrofit2.HttpException
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val source: AuthContract.DataSource,
    private val prefs: SharedPreferences
) : AuthContract.Repository {

    override suspend fun signUp(username: String, password: String): AuthResult<Unit> {
        return try {
            val user = source
                .signUp(
                    request = AuthRequest(
                        username = username,
                        password = password
                    )
                )
            prefs
                .edit()
                .putLong("userId", user.id)
                .apply()
            signIn(username, password)
        } catch(ex: HttpException) {
            when (ex.code()) {
                401 -> AuthResult.Unauthorized()
                else -> AuthResult.UnknownError()
            }
        } catch (ex: Exception) {
            AuthResult.UnknownError()
        }
    }

    override suspend fun signIn(username: String, password: String): AuthResult<Unit> {
        return try {
            val response = source.signIn(
                request = AuthRequest(
                    username = username,
                    password = password
                )
            )
            prefs
                .edit()
                .putString("jwt", response.token)
                .apply()
            AuthResult.Authorized()
        } catch(ex: HttpException) {
            when (ex.code()) {
                401 -> AuthResult.Unauthorized()
                else -> AuthResult.UnknownError()
            }
        } catch (ex: Exception) {
            AuthResult.UnknownError()
        }
    }

    override suspend fun authenticate(): AuthResult<Unit> {
        return try {
            val token = prefs.getString("jwt", null)
                ?: return AuthResult.Unauthorized()
            source.authenticate("Bearer $token")
            AuthResult.Authorized()
        } catch(ex: HttpException) {
            when (ex.code()) {
                401 -> AuthResult.Unauthorized()
                else -> AuthResult.UnknownError()
            }
        } catch (ex: Exception) {
            AuthResult.UnknownError()
        }
    }

    override suspend fun logOut(){
        try {
            prefs
                .edit()
                .putString("jwt", null)
                .apply()
        } catch (ex: Exception) {
            throw Exception() // ???
        }
    }

    override fun getPrefs() = prefs
}