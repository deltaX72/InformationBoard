package com.deltax72.informationboard.presentation.fragments.userprofile

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.deltax72.informationboard.R
import com.deltax72.informationboard.databinding.FragmentUserProfileBinding
import com.deltax72.informationboard.presentation.base.fragments.BaseFragment
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserProfileFragment:
    BaseFragment(),
    UserProfileContract.View
{
    private lateinit var binding: FragmentUserProfileBinding

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private val viewModel: UserProfileViewModel by activityViewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        onBackPressed(R.id.action_editUserProfileFragment_to_userProfileFragment)
//        refreshFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserProfileBinding.inflate(inflater, container, false)

        binding.apply {

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            editProfileButton.setOnClickListener {
                findNavController()
                    .navigate(R.id.action_userProfileFragment_to_editUserProfileFragment)
            }
        }

        val token = sharedPreferences.getString("jwt", null)!!

        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.getUser(token)
                viewModel.user.collect { user ->
                    binding.apply {
                        usernameTv.text = user.username
                        firstNameTv.text = user.firstName
                        lastNameTv.text = user.lastName
                    }
                }
            }
        }
    }



    override fun onResume() {
        super.onResume()
//        navController().popBackStack()
//        navController().navigate(R.id.action_userProfileFragment_self)
        Toast.makeText(context, "onResume", Toast.LENGTH_SHORT).show()

    }
}
