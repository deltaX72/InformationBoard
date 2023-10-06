package com.deltax72.informationboard.presentation.base.fragments

import androidx.activity.OnBackPressedCallback
import androidx.annotation.IdRes
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.deltax72.informationboard.presentation.utils.helpers.OnBackPressedListener
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment:
    DaggerFragment(),
    BaseContract.View,
    OnBackPressedListener
{

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onBackPressed(@IdRes fragmentIdRes: Int) {
        val onBackPressedCallback = object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
//                refreshFragment()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
//        refreshFragment()
    }

    fun refreshFragment() {
        findNavController().run {
//            val id = currentDestination?.id
//            if (id != null) {
//                popBackStack(id, true)
//                navigate(id)
//            }
            popBackStack()
        }
    }

    fun refreshFragment(@IdRes fragmentId: Int) {
        findNavController().run {
            popBackStack()
            navigate(fragmentId)
        }
    }
}