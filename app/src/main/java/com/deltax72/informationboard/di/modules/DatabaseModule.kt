package com.deltax72.informationboard.di.modules

import android.content.Context
import androidx.room.Room
import com.deltax72.informationboard.data.database.MainDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): MainDatabase {
        val inst = MainDatabase.INSTANCE
        if (inst != null) return inst

        synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                MainDatabase::class.java,
                MainDatabase.databaseName
            )
                .fallbackToDestructiveMigration()
                .build()
            MainDatabase.INSTANCE = instance
            return instance
        }
    }

//    @Provides
//    fun provideLocalRegistrationDataSource(
//        database: MainDatabase
//    ): RegistrationContract.LocalDataSource = database.registrationDao
//
//    @Provides
//    fun provideLocalLoginDataSource(
//        database: MainDatabase
//    ): LoginContract.LocalDataSource = database.loginDao
//
//    @Provides
//    fun provideLocalUsersListDataSource(
//        database: MainDatabase
//    ): UsersListContract.LocalDataSource = database.usersListDao
}