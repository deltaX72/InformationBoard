package com.deltax72.informationboard.presentation.fragments.userprofile

import com.deltax72.informationboard.data.database.entities.User
import javax.inject.Inject

class UserProfileRepository @Inject constructor(
    private val remote: UserProfileContract.RemoteDataSource
) : UserProfileContract.Repository {

    override suspend fun getUser(token: String): User {
        return remote.getUser("Bearer $token")
    }
}
