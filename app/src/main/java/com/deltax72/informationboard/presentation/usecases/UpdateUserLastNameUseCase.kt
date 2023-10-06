package com.deltax72.informationboard.presentation.usecases

import com.deltax72.informationboard.presentation.fragments.edituserprofile.EditUserProfileContract
import javax.inject.Inject

class UpdateUserLastNameUseCase @Inject constructor(
    private val editUserProfileRepository: EditUserProfileContract.Repository
) {

    suspend operator fun invoke(id: Long, token: String, lastName: String) =
        editUserProfileRepository.updateUserLastName(id, token, lastName)
}