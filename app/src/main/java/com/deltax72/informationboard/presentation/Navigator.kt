package com.deltax72.informationboard.presentation

import androidx.fragment.app.Fragment

interface Navigator {
//    fun launch(fragment: BaseFragment)
////    fun launch(@IdRes resId: Int)
//    fun getActiveFragment(): BaseFragment?
//    fun clear()
}

fun Fragment.navigator() = requireActivity() as Navigator

//fun Fragment.refresh() =

//fun Fragment.navController() =
//    Navigation
//        .findNavController(
//            requireActivity() as MainActivity,
//            R.id.nav_host_fragment
//        )