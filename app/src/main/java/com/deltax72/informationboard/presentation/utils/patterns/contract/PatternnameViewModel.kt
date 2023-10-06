package com.deltax72.informationboard.presentation.utils.patterns.contract

import com.deltax72.informationboard.presentation.base.fragments.BaseViewModel
import javax.inject.Inject

class PatternnameViewModel @Inject constructor(
    private val repository: PatternnameContract.Repository
) : BaseViewModel(),
    PatternnameContract.ViewModel
{

}