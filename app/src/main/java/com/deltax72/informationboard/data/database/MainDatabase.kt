package com.deltax72.informationboard.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.deltax72.informationboard.data.database.entities.NewsModel
import com.deltax72.informationboard.presentation.fragments.news.NewsContract

@Database(
    entities = [
        NewsModel::class
    ], version = 1, exportSchema = false
)
abstract class MainDatabase: RoomDatabase() {
//    abstract val registrationDao: RegistrationContract.LocalDataSource
//    abstract val loginDao: LoginContract.LocalDataSource
//    abstract val usersListDao: UsersListContract.LocalDataSource

    abstract val newsDao: NewsContract.LocalDataSource

    companion object {
        const val databaseName = "main_database"

        @Volatile
        var INSTANCE: MainDatabase? = null
    }
}