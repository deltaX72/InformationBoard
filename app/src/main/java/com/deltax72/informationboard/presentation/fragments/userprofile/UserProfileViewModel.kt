package com.deltax72.informationboard.presentation.fragments.userprofile

import androidx.lifecycle.viewModelScope
import com.deltax72.informationboard.data.database.entities.User
import com.deltax72.informationboard.presentation.base.fragments.BaseViewModel
import com.deltax72.informationboard.presentation.usecases.GetUserUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserProfileViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : BaseViewModel(),
    UserProfileContract.ViewModel
{
    private val userChannel = Channel<User>()
    val user = userChannel.receiveAsFlow()

    override fun getUser(token: String) {
        viewModelScope.launch {
            userChannel.send(getUserUseCase(token))
        }
    }
}
