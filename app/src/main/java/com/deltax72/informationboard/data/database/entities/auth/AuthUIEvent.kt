package com.deltax72.informationboard.data.database.entities.auth

sealed class AuthUIEvent {
    data class SignUpUsernameChanged(val value: String): AuthUIEvent()
    data class SignUpPasswordChanged(val value: String): AuthUIEvent()
    object SignUp: AuthUIEvent()

    data class SignInUsernameChanged(val value: String): AuthUIEvent()
    data class SignInPasswordChanged(val value: String): AuthUIEvent()
    object SignIn: AuthUIEvent()
}