package com.deltax72.informationboard.presentation.fragments.registration

import com.deltax72.informationboard.presentation.service.auth.AuthViewModel
import com.deltax72.informationboard.presentation.usecases.AuthenticateUseCase
import com.deltax72.informationboard.presentation.usecases.SignInUseCase
import com.deltax72.informationboard.presentation.usecases.SignUpUseCase
import javax.inject.Inject

class RegistrationViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val signInUseCase: SignInUseCase,
    private val authenticateUseCase: AuthenticateUseCase
) : AuthViewModel(
    signUpUseCase,
    signInUseCase,
    authenticateUseCase),

    RegistrationContract.ViewModel
{

}
