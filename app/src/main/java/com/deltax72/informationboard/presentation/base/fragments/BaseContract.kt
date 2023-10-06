package com.deltax72.informationboard.presentation.base.fragments

import androidx.lifecycle.ViewModelProvider

interface BaseContract {
    interface ViewModel {
        abstract class Factory: ViewModelProvider.Factory
    }

    interface View

    interface Repository

    interface DataSource
}