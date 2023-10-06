package com.deltax72.informationboard.di.modules

import com.deltax72.informationboard.di.annotations.FragmentScope
import com.deltax72.informationboard.presentation.base.fragments.BaseFragment
import com.deltax72.informationboard.presentation.fragments.createnews.CreateNewsFragment
import com.deltax72.informationboard.presentation.fragments.edituserprofile.EditUserProfileFragment
import com.deltax72.informationboard.presentation.fragments.friendslist.FriendsListFragment
import com.deltax72.informationboard.presentation.fragments.login.LoginFragment
import com.deltax72.informationboard.presentation.fragments.news.NewsFragment
import com.deltax72.informationboard.presentation.fragments.registration.RegistrationFragment
import com.deltax72.informationboard.presentation.fragments.userprofile.UserProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun baseFragmentInjector(): BaseFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun newsFragmentInjector(): NewsFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun createNewsFragmentInjector(): CreateNewsFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun registrationFragmentInjector(): RegistrationFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun loginFragmentInjector(): LoginFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun userProfileFragmentInjector(): UserProfileFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun friendsListFragmentInjector(): FriendsListFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun editUserProfileFragmentInjector(): EditUserProfileFragment
}