package com.deltax72.informationboard.presentation.utils.patterns.contract

import androidx.room.Dao
import com.deltax72.informationboard.presentation.base.fragments.BaseContract

interface PatternnameContract {
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