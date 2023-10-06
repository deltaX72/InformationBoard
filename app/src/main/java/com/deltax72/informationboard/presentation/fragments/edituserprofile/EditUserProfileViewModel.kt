package com.deltax72.informationboard.presentation.fragments.edituserprofile

import androidx.lifecycle.viewModelScope
import com.deltax72.informationboard.presentation.base.fragments.BaseViewModel
import com.deltax72.informationboard.presentation.usecases.GetUserUseCase
import com.deltax72.informationboard.presentation.usecases.UpdateUserFirstNameUseCase
import com.deltax72.informationboard.presentation.usecases.UpdateUserLastNameUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class EditUserProfileViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val updateUserFirstNameUseCase: UpdateUserFirstNameUseCase,
    private val updateUserLastNameUseCase: UpdateUserLastNameUseCase
) : BaseViewModel(),
    EditUserProfileContract.ViewModel
{
    override fun updateUserProfile(token: String, firstName: String, lastName: String) {
        viewModelScope.launch {
            val user = getUserUseCase(token)
            updateUserFirstNameUseCase(user.id, token, firstName)
            updateUserLastNameUseCase(user.id, token, lastName)
        }
    }
}
