package com.deltax72.informationboard.presentation.usecases

import com.deltax72.informationboard.presentation.fragments.userprofile.UserProfileContract
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userProfileRepository: UserProfileContract.Repository
) {

    suspend operator fun invoke(token: String) =
        userProfileRepository.getUser(token)
}