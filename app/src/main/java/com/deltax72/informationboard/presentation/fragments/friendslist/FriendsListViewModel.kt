package com.deltax72.informationboard.presentation.fragments.friendslist

import com.deltax72.informationboard.presentation.base.fragments.BaseViewModel
import javax.inject.Inject

class FriendsListViewModel @Inject constructor(
    private val repository: FriendsListContract.Repository
) : BaseViewModel(),
    FriendsListContract.ViewModel
{

}
