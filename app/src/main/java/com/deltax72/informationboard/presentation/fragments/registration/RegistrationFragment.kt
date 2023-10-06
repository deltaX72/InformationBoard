package com.deltax72.informationboard.presentation.fragments.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.deltax72.informationboard.R
import com.deltax72.informationboard.data.database.entities.auth.AuthUIEvent
import com.deltax72.informationboard.databinding.FragmentRegistrationBinding
import com.deltax72.informationboard.presentation.base.fragments.BaseFragment
import com.deltax72.informationboard.presentation.service.auth.AuthResult
import kotlinx.coroutines.launch

class RegistrationFragment:
    BaseFragment(),
    RegistrationContract.View
{
    private lateinit var binding: FragmentRegistrationBinding

    private val viewModel: RegistrationViewModel by activityViewModels {
        factory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)

        val authState = viewModel.authState.value

        binding.apply {
            username.setText(authState.signUpUsername)
            password.setText(authState.signUpPassword)
        }

        lifecycleScope.launch {
            viewModel.authResults.collect { results ->
                when (results) {
                    is AuthResult.Authorized -> {
                        findNavController().navigate(R.id.action_registrationFragment_to_newsFragment)
                    }
                    is AuthResult.Unauthorized -> {
                        Toast.makeText(
                            context,
                            "You're not authorized",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    is AuthResult.Conflict -> {}
                    is AuthResult.UnknownError -> {
                        Toast.makeText(
                            context,
                            "An unknown error occurred",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            signUp.setOnClickListener {
                viewModel.onAuthEvent(AuthUIEvent.SignUp)
            }

            username.doOnTextChanged { text, start, before, count ->
                viewModel.onAuthEvent(AuthUIEvent.SignUpUsernameChanged(text.toString()))
            }

            password.doOnTextChanged { text, start, before, count ->
                viewModel.onAuthEvent(AuthUIEvent.SignUpPasswordChanged(text.toString()))
            }
        }
    }
}
