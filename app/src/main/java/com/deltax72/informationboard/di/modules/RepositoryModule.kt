package com.deltax72.informationboard.di.modules

import android.content.SharedPreferences
import com.deltax72.informationboard.presentation.fragments.createnews.CreateNewsContract
import com.deltax72.informationboard.presentation.fragments.createnews.CreateNewsRepository
import com.deltax72.informationboard.presentation.fragments.edituserprofile.EditUserProfileContract
import com.deltax72.informationboard.presentation.fragments.edituserprofile.EditUserProfileRepository
import com.deltax72.informationboard.presentation.fragments.friendslist.FriendsListContract
import com.deltax72.informationboard.presentation.fragments.friendslist.FriendsListRepository
import com.deltax72.informationboard.presentation.fragments.login.LoginContract
import com.deltax72.informationboard.presentation.fragments.login.LoginRepository
import com.deltax72.informationboard.presentation.fragments.news.NewsContract
import com.deltax72.informationboard.presentation.fragments.news.NewsRepository
import com.deltax72.informationboard.presentation.fragments.registration.RegistrationContract
import com.deltax72.informationboard.presentation.fragments.registration.RegistrationRepository
import com.deltax72.informationboard.presentation.fragments.userprofile.UserProfileContract
import com.deltax72.informationboard.presentation.fragments.userprofile.UserProfileRepository
import com.deltax72.informationboard.presentation.service.auth.AuthContract
import com.deltax72.informationboard.presentation.service.auth.AuthRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideNewsRepository(
        remote: NewsContract.RemoteDataSource
    ): NewsContract.Repository = NewsRepository(remote)

    @Provides
    fun provideCreateNewsRepository(
        remote: CreateNewsContract.RemoteDataSource
    ): CreateNewsContract.Repository = CreateNewsRepository(remote)

    @Provides
    fun provideRegistrationRepository(
        remote: RegistrationContract.RemoteDataSource,
        auth: AuthContract.DataSource
    ): RegistrationContract.Repository = RegistrationRepository(remote, auth)

    @Provides
    fun provideLoginRepository(
        remote: LoginContract.RemoteDataSource
    ): LoginContract.Repository = LoginRepository(remote)

    @Provides
    fun provideUserProfileRepository(
        remote: UserProfileContract.RemoteDataSource
    ): UserProfileContract.Repository = UserProfileRepository(remote)

    @Provides
    fun provideEditUserProfileRepository(
        remote: EditUserProfileContract.RemoteDataSource
    ): EditUserProfileContract.Repository = EditUserProfileRepository(remote)

    @Provides
    fun provideFriendsListRepository(
        remote: FriendsListContract.RemoteDataSource
    ): FriendsListContract.Repository = FriendsListRepository()

    @Provides
    fun provideAuthRepository(
        remote: AuthContract.DataSource,
        prefs: SharedPreferences
    ): AuthContract.Repository = AuthRepository(remote, prefs)
}