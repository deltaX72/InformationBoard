package com.deltax72.informationboard.presentation.usecases

import com.deltax72.informationboard.presentation.service.auth.AuthContract
import javax.inject.Inject

class AuthenticateUseCase @Inject constructor(
    private val authRepository: AuthContract.Repository
) {

    suspend operator fun invoke() =
        authRepository.authenticate()
}