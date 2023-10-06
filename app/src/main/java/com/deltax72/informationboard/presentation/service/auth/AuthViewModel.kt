package com.deltax72.informationboard.presentation.service.auth

import androidx.lifecycle.viewModelScope
import com.deltax72.informationboard.data.database.entities.auth.AuthState
import com.deltax72.informationboard.data.database.entities.auth.AuthUIEvent
import com.deltax72.informationboard.presentation.base.fragments.BaseViewModel
import com.deltax72.informationboard.presentation.usecases.AuthenticateUseCase
import com.deltax72.informationboard.presentation.usecases.SignInUseCase
import com.deltax72.informationboard.presentation.usecases.SignUpUseCase
import com.deltax72.informationboard.presentation.utils.livedata.NonNullMutableLiveData
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

open class AuthViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val signInUseCase: SignInUseCase,
    private val authenticateUseCase: AuthenticateUseCase
): BaseViewModel(),
    AuthContract.ViewModel
{
    val authState = NonNullMutableLiveData(AuthState())

    private val resultChannel = Channel<AuthResult<Unit>>()
    val authResults = resultChannel.receiveAsFlow()

    init {
        authenticate()
    }

    override fun onAuthEvent(event: AuthUIEvent) {
        when (event) {
            is AuthUIEvent.SignUpUsernameChanged -> {
                authState.value.apply {
                    signUpUsername = event.value
                }
            }
            is AuthUIEvent.SignUpPasswordChanged -> {
                authState.value.apply {
                    signUpPassword = event.value
                }
            }
            is AuthUIEvent.SignUp -> {
                signUp()
            }
            is AuthUIEvent.SignInUsernameChanged -> {
                authState.value.apply {
                    signInUsername = event.value
                }
            }
            is AuthUIEvent.SignInPasswordChanged -> {
                authState.value.apply {
                    signInPassword = event.value
                }
            }
            is AuthUIEvent.SignIn -> {
                signIn()
            }
        }
    }

    override fun signUp() {
        viewModelScope.launch {
            authState.value.isLoading = true
            val result = signUpUseCase(
                username = authState.value.signUpUsername,
                password = authState.value.signUpPassword
            )
            resultChannel.send(result)
            authState.value.isLoading = false
        }
    }

    override fun signIn() {
        viewModelScope.launch {
            authState.value.isLoading = true
            val result = signInUseCase(
                username = authState.value.signInUsername,
                password = authState.value.signInPassword
            )
            resultChannel.send(result)
            authState.value.isLoading = false
        }
    }

    final override fun authenticate() {
        viewModelScope.launch {
            authState.value.isLoading = true
            val result = authenticateUseCase()
            resultChannel.send(result)
            authState.value.isLoading = false
        }
    }

//    override fun logOut() {
//        viewModelScope.launch {
//            repository
//                .logOut()
//        }
//    }
}