package com.deltax72.informationboard.presentation.fragments.login

import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val remote: LoginContract.RemoteDataSource
) : LoginContract.Repository {


}
