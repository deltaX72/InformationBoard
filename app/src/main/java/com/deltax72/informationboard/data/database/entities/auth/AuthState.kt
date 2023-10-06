package com.deltax72.informationboard.data.database.entities.auth

data class AuthState(
    var isLoading: Boolean = false,
    var signUpUsername: String = "",
    var signUpPassword: String = "",
    var signInUsername: String = "",
    var signInPassword: String = ""
)
