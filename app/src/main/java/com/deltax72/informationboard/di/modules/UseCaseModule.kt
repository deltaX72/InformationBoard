package com.deltax72.informationboard.di.modules

import com.deltax72.informationboard.presentation.fragments.createnews.CreateNewsContract
import com.deltax72.informationboard.presentation.fragments.edituserprofile.EditUserProfileContract
import com.deltax72.informationboard.presentation.fragments.news.NewsContract
import com.deltax72.informationboard.presentation.fragments.userprofile.UserProfileContract
import com.deltax72.informationboard.presentation.service.auth.AuthContract
import com.deltax72.informationboard.presentation.usecases.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideAuthenticateUseCase(
        authRepository: AuthContract.Repository
    ): AuthenticateUseCase = AuthenticateUseCase(authRepository)

    @Provides
    fun provideCreateNewsUseCase(
        createNewsRepository: CreateNewsContract.Repository
    ): CreateNewsUseCase = CreateNewsUseCase(createNewsRepository)

    @Provides
    fun provideGetAllNewsUseCase(
        newsRepository: NewsContract.Repository
    ): GetAllNewsUseCase = GetAllNewsUseCase(newsRepository)

    @Provides
    fun getUserUseCase(
        userProfileRepository: UserProfileContract.Repository
    ): GetUserUseCase = GetUserUseCase(userProfileRepository)

    @Provides
    fun provideRemoveNewsUseCase(
        newsRepository: NewsContract.Repository
    ): RemoveNewsUseCase = RemoveNewsUseCase(newsRepository)

    @Provides
    fun provideSignUpUseCase(
        authRepository: AuthContract.Repository
    ): SignUpUseCase = SignUpUseCase(authRepository)

    @Provides
    fun provideSignInUseCase(
        authRepository: AuthContract.Repository
    ): SignInUseCase = SignInUseCase(authRepository)

    @Provides
    fun provideUpdateUserFirstNameUseCase(
        editUserProfileRepository: EditUserProfileContract.Repository
    ): UpdateUserFirstNameUseCase = UpdateUserFirstNameUseCase(editUserProfileRepository)

    @Provides
    fun provideUpdateUserLastNameUseCase(
        editUserProfileRepository: EditUserProfileContract.Repository
    ): UpdateUserLastNameUseCase = UpdateUserLastNameUseCase(editUserProfileRepository)
}