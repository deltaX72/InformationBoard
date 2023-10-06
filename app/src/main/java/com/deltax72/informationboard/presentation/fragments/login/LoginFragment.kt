package com.deltax72.informationboard.presentation.fragments.login

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.deltax72.informationboard.R
import com.deltax72.informationboard.data.database.entities.auth.AuthUIEvent
import com.deltax72.informationboard.databinding.FragmentLoginBinding
import com.deltax72.informationboard.presentation.MainActivity
import com.deltax72.informationboard.presentation.base.fragments.BaseFragment
import com.deltax72.informationboard.presentation.service.auth.AuthResult
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginFragment:
    BaseFragment(),
    LoginContract.View
{
    private lateinit var binding: FragmentLoginBinding

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private val viewModel: LoginViewModel by activityViewModels {
        factory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        val authState = viewModel.authState.value

        binding.apply {
            username.setText(authState.signInUsername)
            password.setText(authState.signInPassword)
        }

        lifecycleScope.launch {
            viewModel.authResults.collect { results ->
                when (results) {
                    is AuthResult.Authorized -> {
                        (activity as MainActivity).navController.navigate(R.id.newsFragment)
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
                (activity as MainActivity).navController
                    .navigate(R.id.action_loginFragment_to_registrationFragment)
            }
            signIn.setOnClickListener {
                viewModel.onAuthEvent(AuthUIEvent.SignIn)
            }
            username.doOnTextChanged { text, start, before, count ->
                viewModel.onAuthEvent(AuthUIEvent.SignInUsernameChanged(text.toString()))
            }
            password.doOnTextChanged { text, start, before, count ->
                viewModel.onAuthEvent(AuthUIEvent.SignInPasswordChanged(text.toString()))
            }
        }
    }
}
