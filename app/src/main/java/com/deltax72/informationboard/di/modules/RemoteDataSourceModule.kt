package com.deltax72.informationboard.di.modules

import com.deltax72.informationboard.presentation.fragments.createnews.CreateNewsContract
import com.deltax72.informationboard.presentation.fragments.edituserprofile.EditUserProfileContract
import com.deltax72.informationboard.presentation.fragments.friendslist.FriendsListContract
import com.deltax72.informationboard.presentation.fragments.login.LoginContract
import com.deltax72.informationboard.presentation.fragments.news.NewsContract
import com.deltax72.informationboard.presentation.fragments.registration.RegistrationContract
import com.deltax72.informationboard.presentation.fragments.userprofile.UserProfileContract
import com.deltax72.informationboard.presentation.service.auth.AuthContract
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RemoteDataSourceModule {

    @Provides
    fun provideRemoteNewsDataSource(
        retrofit: Retrofit
    ): NewsContract.RemoteDataSource =
        retrofit.create(NewsContract.RemoteDataSource::class.java)

    @Provides
    fun provideRemoteCreateNewsDataSource(
        retrofit: Retrofit
    ): CreateNewsContract.RemoteDataSource =
        retrofit.create(CreateNewsContract.RemoteDataSource::class.java)

    @Provides
    fun provideRemoteRegistrationDataSource(
        retrofit: Retrofit
    ): RegistrationContract.RemoteDataSource =
        retrofit.create(RegistrationContract.RemoteDataSource::class.java)

    @Provides
    fun provideRemoteLoginDataSource(
        retrofit: Retrofit
    ): LoginContract.RemoteDataSource =
        retrofit.create(LoginContract.RemoteDataSource::class.java)

    @Provides
    fun provideUserProfileDataSource(
        retrofit: Retrofit
    ): UserProfileContract.RemoteDataSource =
        retrofit.create(UserProfileContract.RemoteDataSource::class.java)

    @Provides
    fun provideEditUserProfileDataSource(
        retrofit: Retrofit
    ): EditUserProfileContract.RemoteDataSource =
        retrofit.create(EditUserProfileContract.RemoteDataSource::class.java)

    @Provides
    fun provideFriendsListDataSource(
        retrofit: Retrofit
    ): FriendsListContract.RemoteDataSource =
        retrofit.create(FriendsListContract.RemoteDataSource::class.java)

    @Provides
    fun provideRemoteAuthDataSource(
        retrofit: Retrofit
    ): AuthContract.DataSource =
        retrofit.create(AuthContract.DataSource::class.java)
}