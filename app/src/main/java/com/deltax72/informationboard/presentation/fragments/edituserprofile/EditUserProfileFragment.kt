package com.deltax72.informationboard.presentation.fragments.edituserprofile

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.deltax72.informationboard.R
import com.deltax72.informationboard.databinding.FragmentEditUserProfileBinding
import com.deltax72.informationboard.presentation.base.fragments.BaseFragment
import javax.inject.Inject

class EditUserProfileFragment:
    BaseFragment(),
    EditUserProfileContract.View
{
    private lateinit var binding: FragmentEditUserProfileBinding

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private val viewModel: EditUserProfileViewModel by activityViewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onBackPressed(R.id.action_editUserProfileFragment_to_userProfileFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditUserProfileBinding.inflate(inflater, container, false)

        binding.apply {

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val token = sharedPreferences.getString("jwt", null)!!

        binding.apply {
            saveButton.setOnClickListener {
                viewModel.updateUserProfile(
                    token,
                    firstNameEt.text.toString(),
                    lastNameEt.text.toString()
                )
                findNavController().popBackStack()
//                onBackPressed(R.id.action_editUserProfileFragment_to_userProfileFragment)
                findNavController().navigate(R.id.action_userProfileFragment_self)
//                refreshFragment(R.id.action_editUserProfileFragment_to_userProfileFragment)
            }
        }
    }
}
