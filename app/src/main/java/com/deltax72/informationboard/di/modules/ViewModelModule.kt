package com.deltax72.informationboard.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.deltax72.informationboard.di.annotations.ViewModelKey
import com.deltax72.informationboard.presentation.fragments.createnews.CreateNewsViewModel
import com.deltax72.informationboard.presentation.fragments.edituserprofile.EditUserProfileViewModel
import com.deltax72.informationboard.presentation.fragments.friendslist.FriendsListViewModel
import com.deltax72.informationboard.presentation.fragments.login.LoginViewModel
import com.deltax72.informationboard.presentation.fragments.news.NewsViewModel
import com.deltax72.informationboard.presentation.fragments.registration.RegistrationViewModel
import com.deltax72.informationboard.presentation.fragments.userprofile.UserProfileViewModel
import com.deltax72.informationboard.presentation.service.auth.AuthViewModel
import com.deltax72.informationboard.presentation.utils.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    fun bindNewsViewModel(viewModel: NewsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreateNewsViewModel::class)
    fun bindCreateNewsViewModel(viewModel: CreateNewsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RegistrationViewModel::class)
    fun bindRegistrationViewModel(viewModel: RegistrationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserProfileViewModel::class)
    fun bindUserProfileViewModel(viewModel: UserProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EditUserProfileViewModel::class)
    fun bindEditUserProfileViewModel(viewModel: EditUserProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FriendsListViewModel::class)
    fun bindFriendsListViewModel(viewModel: FriendsListViewModel): ViewModel
}