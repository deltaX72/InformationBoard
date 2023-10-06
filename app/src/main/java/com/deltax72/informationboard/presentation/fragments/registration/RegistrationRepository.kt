package com.deltax72.informationboard.presentation.fragments.registration

import com.deltax72.informationboard.data.database.entities.auth.AuthRequest
import com.deltax72.informationboard.presentation.service.auth.AuthContract
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    private val remote: RegistrationContract.RemoteDataSource,
    private val auth: AuthContract.DataSource
) : RegistrationContract.Repository {

    override suspend fun signUp(request: AuthRequest) =
        auth.signUp(request)
}
