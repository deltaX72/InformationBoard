package com.deltax72.informationboard.presentation

import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.deltax72.informationboard.R
import com.deltax72.informationboard.databinding.ActivityMainBinding
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), HasAndroidInjector {
    private lateinit var binding: ActivityMainBinding

    lateinit var navController: NavController

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private val fragmentListener = object: FragmentManager.FragmentLifecycleCallbacks() {
        override fun onFragmentViewCreated(
            fm: FragmentManager,
            f: Fragment,
            v: View,
            savedInstanceState: Bundle?
        ) {
            super.onFragmentViewCreated(fm, f, v, savedInstanceState)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.apply {
            setContentView(root)

            val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            navController = navHostFragment.navController

//            navController = Navigation.findNavController(this@MainActivity, R.id.nav_host_fragment)

            bottomNavigation.setOnItemSelectedListener(::onBottomNavigationItemClicked)
            bottomNavigation.visibility = View.GONE
        }

        if (savedInstanceState == null) {
            if (sharedPreferences.getString("jwt", null) == null) {
                navController.navigate(R.id.loginFragment)
            } else {
                navController.navigate(R.id.newsFragment)
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        }

        supportFragmentManager.registerFragmentLifecycleCallbacks(fragmentListener, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        supportFragmentManager.unregisterFragmentLifecycleCallbacks(fragmentListener)
    }

    private fun onBottomNavigationItemClicked(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_news -> {
                navController.navigate(R.id.newsFragment)
            }
            R.id.menu_item_profile -> {
                navController.navigate(R.id.userProfileFragment)
            }
            else -> return false
        }
        return true
    }

    fun setBottomNavigationVisibility(visibility: Int) {
        binding.bottomNavigation.visibility = visibility
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun refreshFragment(@IdRes fragmentIdRes: Int) {
        navController.run {
            popBackStack()
            navigate(fragmentIdRes)
        }
    }
}