package com.deltax72.informationboard.presentation.usecases

import com.deltax72.informationboard.presentation.fragments.edituserprofile.EditUserProfileContract
import javax.inject.Inject

class UpdateUserFirstNameUseCase @Inject constructor(
    private val editUserProfileRepository: EditUserProfileContract.Repository
) {

    suspend operator fun invoke(id: Long, token: String, firstName: String) =
        editUserProfileRepository.updateUserFirstName(id, token, firstName)
}