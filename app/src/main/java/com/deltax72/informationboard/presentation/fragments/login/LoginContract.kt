package com.deltax72.informationboard.presentation.fragments.login

import androidx.room.Dao
import com.deltax72.informationboard.presentation.base.fragments.BaseContract

interface LoginContract {
    interface ViewModel: BaseContract.ViewModel {

    }

    interface View: BaseContract.View {

    }

    interface Repository: BaseContract.Repository {

    }

    @Dao
    interface LocalDataSource: BaseContract.DataSource {

    }

    interface RemoteDataSource: BaseContract.DataSource {

    }
}
