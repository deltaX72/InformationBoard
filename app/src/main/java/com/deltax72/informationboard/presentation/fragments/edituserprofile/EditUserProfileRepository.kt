package com.deltax72.informationboard.presentation.fragments.edituserprofile

import javax.inject.Inject

class EditUserProfileRepository @Inject constructor(
    private val source: EditUserProfileContract.RemoteDataSource
) : EditUserProfileContract.Repository {

    override suspend fun updateUserFirstName(id: Long, token: String, firstName: String) {
        return source.updateUserFirstName(id, "Bearer $token", firstName)
    }

    override suspend fun updateUserLastName(id: Long, token: String, lastName: String) {
        return source.updateUserLastName(id, "Bearer $token", lastName)
    }
}
